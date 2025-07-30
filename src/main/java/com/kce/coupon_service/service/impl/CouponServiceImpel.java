package com.kce.coupon_service.service.impl;

import com.kce.coupon_service.entity.Coupon;
import com.kce.coupon_service.repository.CouponRespository;
import com.kce.coupon_service.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpel implements CouponService {
    private CouponRespository couponRespository;
    public CouponServiceImpel(@Autowired CouponRespository couponRespository) {
        this.couponRespository = couponRespository;
    }
    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return couponRespository.save(coupon);
    }

    public Coupon findById(long id) {
        return couponRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon with id " + id + " not found"));

    }
    public Coupon findByCouponCode(String code) {
        return couponRespository.findByCouponCode(code);
    }

    public double calculateDiscount(Coupon coupon) {
        return coupon.getDiscount_amount();
    }
}
