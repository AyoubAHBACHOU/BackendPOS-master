package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Account;

import java.util.Collection;
import java.util.Optional;

public interface IAccountService {
    public Account saveAccount(Account a);
    public Account updateAccount(Account a);
    public void deleteAccount(Long id);
    public Account getAccount(Long id);
    public Collection<Account> listAccounts();
}
