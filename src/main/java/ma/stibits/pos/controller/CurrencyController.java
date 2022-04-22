package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Account;
import ma.stibits.pos.model.bo.Currency;
import ma.stibits.pos.service.Implementation.AccountService;
import ma.stibits.pos.service.Implementation.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currencies")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CurrencyController {
    @Autowired
    public CurrencyService currencyService;

    @PostMapping("/add")
    public ResponseEntity<Currency> addCurrency(@RequestBody Currency c){
        Currency cr=currencyService.saveCurrency(c);
        return  new ResponseEntity<>(cr, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Currency> updateCurrency(@RequestBody Currency c){
        Currency cr=currencyService.updateCurrency(c);
        return  new ResponseEntity<>(cr, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Currency>> getAllCurrencies(){
        List<Currency> lst=currencyService.listCurrencies();
        return  new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Currency> getOneCurrency(@PathVariable("id") Long id){
        Currency cr=currencyService.getCurrency(id);
        return  new ResponseEntity<>(cr, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurrency(@PathVariable("id") Long id){
        currencyService.deleteCurrency(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
