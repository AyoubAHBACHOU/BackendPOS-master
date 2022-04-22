package ma.stibits.pos.model.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="merchant")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Merchant extends Person implements Serializable{
    private Double sold;
    @OneToOne
    private Account account;

    @OneToMany(mappedBy = "merchant")
    private Set<Review> reviews=new HashSet<>();

    @OneToMany(mappedBy = "merchantCreator")
    private Set<Account> accountsCreated=new HashSet<>();

    @OneToMany(mappedBy = "merchantCreatorCoupon")
    private Set<Coupon> coupons=new HashSet<>();

    @OneToMany(mappedBy = "merchant")
    private Set<Notification> notifications=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "merchants")
    private Set<Currency> currencies=new HashSet<>();

    @OneToMany(mappedBy = "merchant")
    private Set<Product> products=new HashSet<>();

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Account> getAccountsCreated() {
        return accountsCreated;
    }

    public void setAccountsCreated(Set<Account> accountsCreated) {
        this.accountsCreated = accountsCreated;
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
