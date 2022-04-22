package ma.stibits.pos.model.dao;

import ma.stibits.pos.model.bo.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface MerchantRepository extends JpaRepository<Merchant,Long> {
    public Merchant findMerchantById(Long id);
}
