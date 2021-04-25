package com.hj.car.rent.service.serviceImpl;

import com.hj.car.rent.dao.CarMapper;
import com.hj.car.rent.entity.Car;
import com.hj.car.rent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getCars() {
        return carMapper.cars();
    }

    @Override
    public Car selectByCarId(int carId) {
        return carMapper.selectByCarId(carId);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateByCarId(car);
    }

    @Override
    public int insert(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public int deleteByCarId(int carId) {
        return carMapper.deleteByCarId(carId);
    }
}
