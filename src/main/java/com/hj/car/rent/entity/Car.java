package com.hj.car.rent.entity;

import lombok.Data;

@Data
public class Car {
    private int carId;

    private String carModel;

    private int carType;

    private double price;

    private double rentPrice;

    private int isRenting;

    private String description;

    private String carImg;
}
