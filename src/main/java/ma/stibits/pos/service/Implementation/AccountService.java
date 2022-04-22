package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.model.dao.AccountRepository;
import ma.stibits.pos.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }
}