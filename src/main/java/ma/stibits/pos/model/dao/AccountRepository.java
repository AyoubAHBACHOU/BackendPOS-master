package ma.stibits.pos.model.dao;

import ma.stibits.pos.model.bo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface AccountRepository extends JpaRepository<Account,Long> {
    public Account findAccountById(Long id);
}
