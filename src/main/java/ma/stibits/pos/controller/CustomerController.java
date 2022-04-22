package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Customer;
import ma.stibits.pos.service.Implementation.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        Customer ct=customerService.saveCustomer(c);
        return  new ResponseEntity<>(ct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c){
        Customer ct=customerService.updateCustomer(c);
        return new ResponseEntity<>(ct,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> lst=customerService.listCustomers();
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable("id") Long id){
        Customer ct=customerService.getCustomer(id);
        return new ResponseEntity<>(ct,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/***************************************************************************/

    @PostMapping("/addPayment")
    public Customer addPayment(@RequestBody FormAddTo f){
        return  customerService.addPay(f.idM,f.idO);
    }

    @PostMapping("/addReview")
    public Customer addReview(@RequestBody FormAddTo f){
        return  customerService.addReviews(f.idM,f.idO);
    }

}

