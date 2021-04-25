package com.hj.car.rent.service;

import com.hj.car.rent.entity.Car;
import com.hj.car.rent.entity.Customer;
import com.hj.car.rent.entity.RentOrder;

import java.util.List;

public interface RentOrderService {
    String saveOrder(Car car, Customer customer, int day);

    String returnCar(int orderId);

    int deleteByOrderId(int orderId);

    RentOrder selectByOrderId(int orderId);

    int updateByOrderId(RentOrder record);

    List<RentOrder> orders();
}
