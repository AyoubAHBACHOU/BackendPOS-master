package ma.stibits.pos.model.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="currency")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String currencyName;
    private Double percentageToDollar;
    @OneToMany(mappedBy = "currency")
    private Set<Payment> payments=new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "supported_currency",
            joinColumns = { @JoinColumn(name = "currency_id") },
            inverseJoinColumns = { @JoinColumn(name = "merchant_id") }
    )
    private Set<Merchant> merchants=new HashSet<>();

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getCurrencyName() {
         return currencyName;
     }

     public void setCurrencyName(String currencyName) {
         this.currencyName = currencyName;
     }

     public Double getPercentageToDollar() {
         return percentageToDollar;
     }

     public void setPercentageToDollar(Double percentageToDollar) {
         this.percentageToDollar = percentageToDollar;
     }

     public Set<Payment> getPayments() {
         return payments;
     }

     public void setPayments(Set<Payment> payments) {
         this.payments = payments;
     }

     public Set<Merchant> getMerchants() {
         return merchants;
     }

     public void setMerchants(Set<Merchant> merchants) {
         this.merchants = merchants;
     }
 }
