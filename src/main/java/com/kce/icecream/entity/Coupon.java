package com.kce.icecream.entity;

public class Coupon {
    private long coupon_id;
    private String couponCode;
    private double discount_amount;

    public double getDiscount_amount() {
        return discount_amount;
    }


    public long getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(long coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscount() {
        return discount_amount;
    }

    public void setDiscount(double discount) {
        this.discount_amount = discount_amount;
    }


}
