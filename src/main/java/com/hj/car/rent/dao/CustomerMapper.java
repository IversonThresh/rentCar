package com.hj.car.rent.dao;

import com.hj.car.rent.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByCustomerId(int customerId);

    int insert(Customer record);

    Customer selectByCustomerId(int customerId);

    List<Customer> customers();
}
