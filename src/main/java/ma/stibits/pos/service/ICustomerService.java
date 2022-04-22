package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Command;
import ma.stibits.pos.model.bo.Coupon;
import ma.stibits.pos.model.bo.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public Customer saveCustomer(Customer c);
    public List<Customer> listCustomers();
    public void deleteCustomer(Long id);
    public Customer updateCustomer(Customer c);
    public Customer getCustomer(Long id);
    public Customer addPay(Long idC, Long cl);
    public Customer addReviews(Long idC, Long cl);
}
