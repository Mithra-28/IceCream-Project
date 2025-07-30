package com.kce.coupon_service.controller;

import com.kce.coupon_service.entity.Coupon;
import com.kce.coupon_service.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(@Autowired CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/code/{couponCode}")
    public ResponseEntity<Coupon> findByCouponCode(@PathVariable String couponCode) {
        Coupon coupon = couponService.findByCouponCode(couponCode);
        return new ResponseEntity<>(coupon, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Coupon> findById(@PathVariable long id) {
        Coupon coupon = couponService.findById(id);
        return new ResponseEntity<>(coupon, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Coupon> saveCoupon(@RequestBody Coupon coupon) {
        Coupon savedCoupon = couponService.saveCoupon(coupon);
        return new ResponseEntity<>(savedCoupon, HttpStatus.CREATED);
    }

}
