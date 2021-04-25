package com.hj.car.rent.controller;

import com.hj.car.rent.common.constant.Result;
import com.hj.car.rent.common.constant.ResultCode;
import com.hj.car.rent.entity.Car;
import com.hj.car.rent.service.CarService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "CarController")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation(value = "查看所有汽车")
    @RequestMapping(value = "cars",method = RequestMethod.GET)
    public Result cars() {
        List<Car> cars;
        try {
            cars = carService.getCars();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.ERROR);
        }
        return Result.success(cars);
    }

    @ApiOperation(value = "根据汽车id查看汽车详细信息")
    @RequestMapping(value = "car/{carId}", method = RequestMethod.GET)
    public Result car(@PathVariable int carId) {
        Car car;
        try {
            car = carService.selectByCarId(carId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.ERROR);
        }
        return Result.success(car);
    }

}
