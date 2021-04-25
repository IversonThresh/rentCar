package com.hj.car.rent.common.constant;

public enum RentStatus {

    RENTING(0, "未租赁"),
    RENTED(1, "已租赁");

    private int rentType;
    private String name;

    RentStatus(int rentType, String name) {
        this.rentType = rentType;
        this.name = name;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
