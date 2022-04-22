package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Merchant;
import ma.stibits.pos.service.Implementation.CurrencyService;
import ma.stibits.pos.service.Implementation.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merchants")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class MerchantController {
    @Autowired
    MerchantService merchantService;
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/add")
    public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant m){
        Merchant mt=merchantService.saveMerchant(m);
        return new ResponseEntity<>(mt,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Merchant> updateMerchant(@RequestBody Merchant m){
        Merchant mt=merchantService.updateMerchant(m);
        return new ResponseEntity<>(mt,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Merchant>> getAllMerchants(){
        List<Merchant> lst=merchantService.listMerchants();
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Merchant> getOneMerchant(@PathVariable("id") Long id){
        Merchant m=merchantService.getMerchant(id);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMerchant(@PathVariable("id") Long id){
        merchantService.deleteMerchant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /********************************************************************/
    @PostMapping("/addAccount")
    public Merchant addAccount(@RequestBody FormAddTo form){
       return merchantService.addAccount(form.idM,form.idO);
    }

    @PostMapping("/addCurrency")
    public Merchant addCurrency(@RequestBody FormAddTo form){
        return merchantService.addCurrency(form.idM,form.idO);
    }
    @PostMapping("/removeCurrency")
    public Merchant removeCurrency(@RequestBody FormAddTo form){
        return merchantService.removeCurrency(form.idM,form.idO);
    }
}

