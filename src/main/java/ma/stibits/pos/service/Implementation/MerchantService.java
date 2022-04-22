package ma.stibits.pos.service.Implementation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ma.stibits.pos.model.bo.*;
import ma.stibits.pos.model.dao.*;
import ma.stibits.pos.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class MerchantService implements IMerchantService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Merchant saveMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public Merchant getMerchant(Long id) {
        return merchantRepository.findById(id).get();
    }

    @Override
    public List<Merchant> listMerchants() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant addCurrency(Long idM,Long idO) {
        Merchant m = merchantRepository.findById(idM).get();
        log.info("merchant => {}",m.getFirstName());
        Currency c = currencyRepository.findById(idO).get();
        log.info("currecy => id : {} , name : {}",c.getId() , c.getCurrencyName());
        m.getCurrencies().add(c);
        c.getMerchants().add(m);
        currencyRepository.save(c);
        return merchantRepository.save(m);
    }

    @Override
    public Merchant removeCurrency(Long idM,Long idO) {
        Merchant m = merchantRepository.findById(idM).get();
        log.info("merchant => {}",m.getFirstName());
        Currency c = currencyRepository.findById(idO).get();
        log.info("currecy => id : {} , name : {}",c.getId() , c.getCurrencyName());
        m.getCurrencies().remove(c);
        c.getMerchants().remove(m);
        currencyRepository.save(c);
        return merchantRepository.save(m);
    }

    @Override
    public Merchant addAccount(Long idM, Long idA) {
        Merchant m = merchantRepository.findById(idM).get();
        Account a= accountRepository.findById(idA).get();
        m.setAccount(a);
        merchantRepository.save(m);
        return m;
    }
/*
    @Override
    public Merchant addProduct(Long idM, Long idP) {
        Merchant m = merchantRepository.findById(idM).get();
        Product p = productRepository.findById(idP).get();
        m.getProducts().add(p);
        p.setMerchant(m);
        productRepository.save(p);
        return merchantRepository.save(m);
    }

    @Override
    public Merchant removeProduct(Long idM, Long idP) {
        Merchant m = merchantRepository.findById(idM).get();
        Product p = productRepository.findById(idP).get();
        m.getProducts().remove(p);
        productRepository.deleteById(idP);
        return merchantRepository.save(m);
    }

    @Override
    public Merchant addReview(Long idM, Long idR) {
        Merchant m = merchantRepository.findById(idM).get();
        Review r = reviewRepository.findById(idR).get();
        m.getReviews().add(r);
        r.setMerchant(m);
        reviewRepository.save(r);
        return merchantRepository.save(m);
    }

    @Override
    public Merchant removeReview(Long idM, Long idR) {
        Merchant m = merchantRepository.findById(idM).get();
        Review r = reviewRepository.findById(idR).get();
        m.getReviews().add(r);
        r.setMerchant(m);
        reviewRepository.save(r);
        return merchantRepository.save(m);
    }

 */
}
