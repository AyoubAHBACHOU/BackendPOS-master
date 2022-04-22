package ma.stibits.pos.model.bo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false,unique = true)
    private String email;
    @Column(length = 10,nullable = false)
    private String password;
    @Column(length = 20,nullable = false)
    private String username;
    @Column(length = 2)
    private char type;
    @OneToMany(mappedBy = "account")
    private Set<Command> commands;
    @ManyToOne
    private Merchant merchantCreator;
    @OneToOne(mappedBy = "account")
    @JsonIgnore
    @JsonSetter
    private Merchant merchantOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Set<Command> getCommands() {
        return commands;
    }

    public void setCommands(Set<Command> commands) {
        this.commands = commands;
    }

    public Merchant getMerchantCreator() {
        return merchantCreator;
    }

    public void setMerchantCreator(Merchant merchantCreator) {
        this.merchantCreator = merchantCreator;
    }

    public Merchant getMerchantOwner() {
        return merchantOwner;
    }

    public void setMerchantOwner(Merchant merchantOwner) {
        this.merchantOwner = merchantOwner;
    }
}
