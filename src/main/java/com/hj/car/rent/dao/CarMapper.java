package com.hj.car.rent.dao;

import com.hj.car.rent.entity.Car;

import java.util.List;

public interface CarMapper {
    int deleteByCarId(int carId);

    int insert(Car record);

    Car selectByCarId(int carId);

    int updateByCarId(Car record);

    List<Car> cars();
}
