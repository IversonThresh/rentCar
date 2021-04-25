package com.hj.car.rent.dao;

import com.hj.car.rent.entity.RentOrder;

import java.util.List;

public interface RentOrderMapper {
    int deleteByOrderId(int orderId);

    int insert(RentOrder record);

    int getMaxOrderId();

    RentOrder selectByOrderId(int orderId);

    int updateByOrderId(RentOrder record);

    List<RentOrder> orders();
}
