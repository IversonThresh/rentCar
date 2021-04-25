package com.hj.car.rent.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RentOrder {
    private int orderId;

    private int customerId;

    private int carId;

    private double price;

    private int rentFlag;

    private Date beginDate;

    private Date returnDate;

    private Date createTime;

    private RentOrder(Builder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.carId = builder.carId;
        this.price = builder.price;
        this.rentFlag = builder.rentFlag;
        this.beginDate = builder.beginDate;
        this.returnDate = builder.returnDate;
        this.createTime = builder.createTime;
    }

    public static class Builder {
        private int orderId;

        private int customerId;

        private int carId;

        private double price;

        private int rentFlag;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date beginDate;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date returnDate;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createTime;

        public Builder() {
        }

        public Builder orderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder carId(int carId) {
            this.carId = carId;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder beginDate(Date beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Builder returnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder rentFlag(int rentFlag) {
            this.rentFlag = rentFlag;
            return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public RentOrder build() {
            return new RentOrder(this);
        }
    }

    @Override
    public String toString() {
        return "CarRentOrder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", price=" + price +
                ", rentFlag=" + rentFlag +
                ", beginDate=" + beginDate +
                ", returnDate=" + returnDate +
                ", createTime=" + createTime +
                '}';
    }
}
