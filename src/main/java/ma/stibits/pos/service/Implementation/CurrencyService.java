package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Currency;
import ma.stibits.pos.model.dao.CurrencyRepository;
import ma.stibits.pos.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CurrencyService implements ICurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency saveCurrency(Currency c) {
        return currencyRepository.save(c);
    }

    @Override
    public Currency updateCurrency(Currency c) {
        return currencyRepository.save(c);
    }

    @Override
    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public Currency getCurrency(Long id) {
        return currencyRepository.findById(id).get();
    }

    @Override
    public List<Currency> listCurrencies() {
        return currencyRepository.findAll();
    }
}
