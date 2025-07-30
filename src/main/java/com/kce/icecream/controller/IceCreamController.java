package com.kce.icecream.controller;

import com.kce.icecream.FeignClient.CouponFeign;
import com.kce.icecream.entity.Coupon;
import com.kce.icecream.entity.Flavor;
import com.kce.icecream.model.ErrorDetails;
import com.kce.icecream.service.IceCreamService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1/ice")
@RestController
public class IceCreamController {
    private IceCreamService iceCreamService;
    @Autowired
    private CouponFeign couponFeign;


    public IceCreamController(@Autowired IceCreamService iceCreamService) {
        this.iceCreamService = iceCreamService;
    }
    @CircuitBreaker(name = "icecream-service", fallbackMethod = "handleError")
    @GetMapping("{id}/{couponCode}")
    public ResponseEntity<Flavor> getProductDiscountByCouponCode(@PathVariable int id,
                                                                 @PathVariable String couponCode) {
        Coupon coupon = couponFeign.findByCouponCode(couponCode).getBody();
        Flavor flavor = iceCreamService.findById(id);

        // Subtract discount_amount, not "discount"
        double discountAmount = coupon.getDiscount_amount(); // <-- use correct field
        double originalPrice = flavor.getPrice();
        flavor.setPrice(originalPrice - discountAmount);

        return new ResponseEntity<>(flavor, HttpStatus.OK);
    }
    public ResponseEntity<ErrorDetails> handleError(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<Flavor>> findAllFlavors() {
        List<Flavor> _flavors =iceCreamService.findAll();
        return new ResponseEntity<>(_flavors, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Flavor> findFlavorById(@PathVariable long id) {
        Flavor _flavor = iceCreamService.findById(id);
        return new ResponseEntity<>(_flavor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Flavor> addFlavor(@RequestBody Flavor flavor) {
        Flavor _flavor=iceCreamService.addFlavor(flavor);
        return new ResponseEntity<>(_flavor, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Flavor> updateFlavorById(@RequestBody Flavor flavor, @PathVariable long id) {
        Flavor _flavor=iceCreamService.updateById(flavor, id);
        return new ResponseEntity<>(_flavor, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Flavor> deleteFlavorById(@PathVariable long id) {
        Flavor _flavor=iceCreamService.deleteById(id);
        return  new ResponseEntity<>(_flavor, HttpStatus.OK);
    }
}
