package ma.stibits.pos.model.dao;

import ma.stibits.pos.model.bo.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    public Currency findCurrencyById(Long id);
}
