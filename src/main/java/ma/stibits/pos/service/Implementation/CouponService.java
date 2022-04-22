package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.Coupon;
import ma.stibits.pos.model.bo.Merchant;
import ma.stibits.pos.model.dao.CommandRepository;
import ma.stibits.pos.model.dao.CouponRepository;
import ma.stibits.pos.model.dao.MerchantRepository;
import ma.stibits.pos.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CouponService implements ICouponService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private CommandRepository commandRepository;
    @Override
    public Coupon saveCoupon(Coupon c) {
        return couponRepository.save(c);
    }

    @Override
    public List<Coupon> listCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public void deleteCoupon(Long id) {
        couponRepository.getById(id);

    }

    @Override
    public Coupon updateCoupon(Coupon c) {
        return couponRepository.save(c);

    }

    @Override
    public Coupon getCoupon(Long id) {
        return couponRepository.findById(id).get();
    }

    @Override
    public Coupon addCommand(Long idCp, Long idC) {
        Coupon cp=couponRepository.findById(idCp).get();
        Command c=commandRepository.findById(idC).get();
        cp.getCommands().add(c);
        return cp;
    }
    @Override
    public Coupon addCreatorMerchant(Long idCp, Long idC) {
        Coupon cp=couponRepository.findById(idCp).get();
        Merchant c=merchantRepository.findById(idC).get();
        cp.setMerchantCreatorCoupon(c);
        return cp;
    }
}
