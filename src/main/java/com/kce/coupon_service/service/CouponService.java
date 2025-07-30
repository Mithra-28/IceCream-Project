package com.kce.coupon_service.service;

import com.kce.coupon_service.entity.Coupon;

public interface CouponService {
    Coupon findById(long id);
    Coupon saveCoupon(Coupon coupon);
    Coupon findByCouponCode(String couponCode);
}
