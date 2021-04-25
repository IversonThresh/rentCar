package com.hj.car.rent.controller;

import com.hj.car.rent.entity.Car;
import com.hj.car.rent.service.CarService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest()
public class CarControllerTest {

    @Autowired
    private CarService carService;

    @BeforeEach
    @Rollback(value = false)
    public void insertCar() {
        System.out.println("------------Start to init data----------");
        Car car = new Car();
        car.setCarId(9999);
        car.setIsRenting(0);
        car.setCarImg("20210424/202104240931596284786.jpg");
        car.setCarModel("Toyota Camry");
        car.setCarType(1);
        car.setDescription("test");
        car.setPrice(250000.00);
        car.setRentPrice(250.00);
        carService.insert(car);
        System.out.println("------------Finish to init data----------");
    }

    @Test
    public void testCars() {
        List<Car> cars = carService.getCars();
        Assert.notEmpty(cars, "Is not empty");
    }

    @Test
    public void testCar() {
        Car car = carService.selectByCarId(9999);
        Assert.notNull(car, "Is not empty");
    }

    @AfterEach
    @Rollback(value = false)
    public void testRemove() {
        System.out.println("------------Start to clear data----------");
        carService.deleteByCarId(9999);
        System.out.println("------------Finish to clear data----------");
    }
}
