package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Currency;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICurrencyService {
    public Currency saveCurrency(Currency c);
    public Currency updateCurrency(Currency c);
    public void deleteCurrency(Long id);
    public Currency getCurrency(Long id);
    public List<Currency> listCurrencies();

}
