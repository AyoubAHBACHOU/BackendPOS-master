package ma.stibits.pos.model.dao;

import ma.stibits.pos.model.bo.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
