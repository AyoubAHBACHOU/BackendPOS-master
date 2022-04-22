package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.*;
import ma.stibits.pos.model.dao.CustomerRepository;
import ma.stibits.pos.model.dao.PaymentRepository;
import ma.stibits.pos.model.dao.ReviewRepository;
import ma.stibits.pos.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override

    public Customer saveCustomer(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addPay(Long idC, Long idCl) {
        Customer c=customerRepository.findById(idC).get();
        Payment cl=paymentRepository.findById(idCl).get();
        c.getPayments().add( cl);
        return c;
    }

    @Override
    public Customer addReviews(Long idC, Long idCl) {
        Customer c=customerRepository.findById(idC).get();
        Review cl=reviewRepository.findById(idCl).get();
        c.getReviews().add(cl);
        return c;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer updateCustomer(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }
}
