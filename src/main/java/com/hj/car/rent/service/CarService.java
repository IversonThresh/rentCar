package com.hj.car.rent.service;

import com.hj.car.rent.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car selectByCarId(int carId);

    int updateCar(Car car);

    int insert(Car car);

    int deleteByCarId(int carId);
}
