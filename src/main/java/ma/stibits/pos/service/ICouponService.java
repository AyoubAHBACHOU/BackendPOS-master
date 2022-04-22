package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.Coupon;

import java.util.List;
import java.util.Optional;

public interface ICouponService {
    public Coupon saveCoupon(Coupon c);
    public List<Coupon> listCoupons();
    public void deleteCoupon(Long id);
    public Coupon updateCoupon(Coupon c);
    public Coupon getCoupon(Long id);
    public Coupon addCommand(Long idCp,Long idC);
    public Coupon addCreatorMerchant(Long idC, Long id);
}
