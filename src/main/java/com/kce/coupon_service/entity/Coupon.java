package com.kce.coupon_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name="coupon_tbl")
public class Coupon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long coupon_id;
    private double discount_amount;
    private String couponCode;

    public Coupon(long coupon_id, double discount_amount, String couponCode) {
        this.coupon_id = coupon_id;
        this.discount_amount = discount_amount;
        this.couponCode = couponCode;
    }
    public Coupon() {

    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public long getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(long coupon_id) {
        this.coupon_id = coupon_id;
    }

    public double getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }

}
