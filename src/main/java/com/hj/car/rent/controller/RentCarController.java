package com.hj.car.rent.controller;

import com.hj.car.rent.common.constant.CommonConstant;
import com.hj.car.rent.common.constant.RentStatus;
import com.hj.car.rent.common.constant.Result;
import com.hj.car.rent.common.constant.ResultCode;
import com.hj.car.rent.entity.Car;
import com.hj.car.rent.entity.Customer;
import com.hj.car.rent.entity.RentOrder;
import com.hj.car.rent.service.CarService;
import com.hj.car.rent.service.CustomerService;
import com.hj.car.rent.service.RentOrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentOrderService rentOrderService;

    @ApiOperation(value = "租车")
    @RequestMapping(value = "car/rent", method = RequestMethod.POST)
    public Result rentCar(@ApiParam(name = "carId", value = "汽车id") @RequestParam("carId") int carId,
                          @ApiParam(name = "customerId", value = "用户id") @RequestParam("customerId") int customerId,
                          @ApiParam(name = "rentDay", value = "租车天数") @RequestParam("rentDay") int rentDay) {
        try {
            Customer customer = customerService.selectByCustomerId(customerId);
            if (customer == null) {
                return Result.failure(ResultCode.USER_NOT_EXIST);
            }
            Car car = carService.selectByCarId(carId);
            if (car == null || car.getIsRenting() == RentStatus.RENTED.getRentType()) {
                return Result.failure(ResultCode.DISPATCH_FAILURE);
            }
            String flag = rentOrderService.saveOrder(car, customer, rentDay);
            if (CommonConstant.RENT_CREATE_SUCCESS.equalsIgnoreCase(flag)) {
                return Result.success(ResultCode.DISPATCH_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure(ResultCode.ERROR);
    }

    @ApiOperation(value = "还车")
    @RequestMapping(value = "car/return", method = RequestMethod.POST)
    public Result returnCar(@ApiParam(name = "orderId", value = "租车记录id") @RequestParam("orderId") int orderId) {
        try {
            String result = rentOrderService.returnCar(orderId);
            if (CommonConstant.RENT_CREATE_SUCCESS.equalsIgnoreCase(result)) {
                return Result.success(ResultCode.RETURN_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure(ResultCode.RETURN_FAILURE);
    }

    @ApiOperation(value = "查看所有租车记录")
    @RequestMapping(value = "rentOrders", method = RequestMethod.GET)
    public Result allRentOrder() {
        List<RentOrder> orders;
        try {
            orders = rentOrderService.orders();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.ERROR);
        }
        return Result.success(orders);
    }
}
