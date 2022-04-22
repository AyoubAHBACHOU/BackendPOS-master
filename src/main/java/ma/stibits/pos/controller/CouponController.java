package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Coupon;
import ma.stibits.pos.service.Implementation.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coupons")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CouponController {
    @Autowired
    public CouponService couponService;

    @PostMapping("/add")
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon c){
        Coupon cp=couponService.saveCoupon(c);
        return  new ResponseEntity<>(cp, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon c){
        Coupon cp=couponService.updateCoupon(c);
        return  new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> lst=couponService.listCoupons();
        return  new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Coupon> getOneCoupon(@PathVariable("id") Long id){
        Coupon cp=couponService.getCoupon(id);
        return  new ResponseEntity<>(cp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCoupon(@PathVariable("id") Long id){
        couponService.deleteCoupon(id);
        return  new ResponseEntity<>( HttpStatus.OK);
    }

    /*******************************************************/
    @PostMapping("/addCom")
    public Coupon addComToCoupon(@RequestBody FormAddTo form){
        return  couponService.addCommand(form.idO,form.idM);
    }

    @PostMapping("/addCreatorMerchant")
    public Coupon addCreatorMerchant(@RequestBody FormAddTo form){
        return  couponService.addCreatorMerchant(form.idO,form.idM);
    }
}

