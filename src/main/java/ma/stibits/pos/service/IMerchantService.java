package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Currency;
import ma.stibits.pos.model.bo.Merchant;
import ma.stibits.pos.model.bo.Review;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IMerchantService {
    public Merchant saveMerchant(Merchant merchant);
    public Merchant updateMerchant(Merchant merchant);
    public void deleteMerchant(Long id);
    public Merchant getMerchant(Long id);
    public List<Merchant> listMerchants();
    public Merchant addCurrency(Long idM,Long idC);
    public Merchant removeCurrency(Long idM,Long idC);
    public Merchant addAccount(Long idM,Long idA);
  /*  public Merchant addProduct(Long idM,Long idP);
    public Merchant removeProduct(Long idM,Long idP);
    public Merchant addReview(Long idM, Long idR);
    public Merchant removeReview(Long idM,Long idR);

   */

}
