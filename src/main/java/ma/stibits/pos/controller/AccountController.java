package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.service.Implementation.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class AccountController {
    @Autowired
    public AccountService accountService;



    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account newAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account a){
    Account updatedAccount=accountService.updateAccount(a);
    return new ResponseEntity<>(updatedAccount,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccounts () {
        List<Account> accounts = accountService.listAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @GetMapping("/getOne/{id}")
    public ResponseEntity<Account> getOneAccount(@PathVariable("id") Long id){
        Account a=accountService.getAccount(id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
