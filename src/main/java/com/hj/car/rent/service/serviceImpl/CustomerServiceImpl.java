package com.hj.car.rent.service.serviceImpl;

import com.hj.car.rent.dao.CustomerMapper;
import com.hj.car.rent.entity.Customer;
import com.hj.car.rent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int deleteByCustomerId(int customerId) {
        return customerMapper.deleteByCustomerId(customerId);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public Customer selectByCustomerId(int customerId) {
        return customerMapper.selectByCustomerId(customerId);
    }

    @Override
    public List<Customer> customers() {
        return null;
    }
}
