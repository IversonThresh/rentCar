package com.hj.car.rent.controller;

import com.hj.car.rent.entity.Car;
import com.hj.car.rent.entity.Customer;
import com.hj.car.rent.service.CarService;
import com.hj.car.rent.service.CustomerService;
import com.hj.car.rent.service.RentOrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

@SpringBootTest()
public class RentCarControllerTest {
    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentOrderService rentOrderService;

    @BeforeEach
    @Rollback(value = false)
    public void insertCar() {
        System.out.println("------------Start to init customer data----------");
        Customer customer = new Customer();
        customer.setCustomerName("sam");
        customer.setCustomerId(10000);
        customer.setAddress("test");
        customer.setPhone("12345678911");
        customer.setSex(1);
        customerService.insert(customer);
        System.out.println("------------Finish to init customer data----------");

        System.out.println("------------Start to init car data----------");
        Car car = new Car();
        car.setCarId(19999);
        car.setIsRenting(0);
        car.setCarImg("20210424/202104240931596284786.jpg");
        car.setCarModel("Toyota Camry");
        car.setCarType(1);
        car.setDescription("test");
        car.setPrice(250000.00);
        car.setRentPrice(250.00);
        carService.insert(car);
        System.out.println("------------Finish to init car data----------");
    }

    @Test
    public void testRentCar() {
        Car car = carService.selectByCarId(19999);
        Customer customer = customerService.selectByCustomerId(10000);
        String s = rentOrderService.saveOrder(car, customer, 1);
        Assert.notNull(s, "result");
    }

    @AfterEach
    @Rollback(value = false)
    public void testRemove() {
        System.out.println("------------Start to clear data----------");
        carService.deleteByCarId(19999);
        customerService.deleteByCustomerId(10000);
        System.out.println("------------Finish to clear data----------");
    }
}
