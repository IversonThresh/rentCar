package com.hj.car.rent.service.serviceImpl;

import com.hj.car.rent.common.constant.CommonConstant;
import com.hj.car.rent.common.constant.RentStatus;
import com.hj.car.rent.dao.RentOrderMapper;
import com.hj.car.rent.entity.Car;
import com.hj.car.rent.entity.RentOrder;
import com.hj.car.rent.entity.Customer;
import com.hj.car.rent.service.CarService;
import com.hj.car.rent.service.RentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RentOrderServiceImpl implements RentOrderService {

    @Autowired
    private RentOrderMapper rentOrderMapper;

    @Autowired
    private CarService carService;

    /**
     * 租车逻辑
     * @param car 车信息
     * @param customer 用户信息
     * @param rentDay 租用天数
     * @return 是否成功
     */
    @Override
    @Transactional
    public String saveOrder(Car car, Customer customer, int rentDay) {
        car.setIsRenting(RentStatus.RENTED.getRentType());
        carService.updateCar(car);

        double price = rentDay * car.getRentPrice();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, rentDay);
        RentOrder.Builder orderBuilder = new RentOrder.Builder();
        RentOrder carRentOrder = orderBuilder.price(price)
                .customerId(customer.getCustomerId())
                .carId(car.getCarId())
                .createTime(date)
                .beginDate(date)
                .returnDate(calendar.getTime()).build();
        if (rentOrderMapper.insert(carRentOrder) > 0) {
            return CommonConstant.RENT_CREATE_SUCCESS;
        }
        return CommonConstant.RENT_CREATE_FAILED;
    }

    /**
     * 还车逻辑
     * @param orderId 租车记录id
     * @return 是否还车成功
     */
    @Override
    @Transactional
    public String returnCar(int orderId) {
        RentOrder rentOrder = rentOrderMapper.selectByOrderId(orderId);
        Car car = carService.selectByCarId(rentOrder.getCarId());
        car.setIsRenting(0);
        carService.updateCar(car);

        rentOrder.setRentFlag(0);
        if (rentOrderMapper.updateByOrderId(rentOrder) > 0) {
            return CommonConstant.RENT_CREATE_SUCCESS;
        }
        return CommonConstant.RENT_CREATE_FAILED;
    }

    @Override
    public int deleteByOrderId(int orderId) {
        return 0;
    }

    @Override
    public RentOrder selectByOrderId(int orderId) {
        return rentOrderMapper.selectByOrderId(orderId);
    }

    @Override
    public int updateByOrderId(RentOrder record) {
        return 0;
    }

    @Override
    public List<RentOrder> orders() {
        return rentOrderMapper.orders();
    }
}
