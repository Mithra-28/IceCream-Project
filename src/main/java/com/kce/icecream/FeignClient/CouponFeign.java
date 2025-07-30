package com.kce.icecream.FeignClient;

import com.kce.icecream.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "COUPON-SERVICE")
public interface CouponFeign {
    @GetMapping("/api/v1/coupon/code/{couponCode}")
    ResponseEntity<Coupon> findByCouponCode(@PathVariable String couponCode);

}
