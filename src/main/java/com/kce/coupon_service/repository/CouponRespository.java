package com.kce.coupon_service.repository;

import com.kce.coupon_service.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRespository extends JpaRepository<Coupon, Long> {
    Coupon findByCouponCode(String couponCode);

}

