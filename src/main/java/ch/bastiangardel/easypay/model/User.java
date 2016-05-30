package ch.bastiangardel.easypay.model;

import com.fasterxml.jackson.annotation.JsonView;
import ch.bastiangardel.easypay.rest.View;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @CreatedDate
    private Long created;


    @JsonView(View.Summary.class)
    private String email;
    @JsonView(View.Summary.class)
    private String name;
    private Boolean active;
    private String password;
    @JsonView(View.Summary.class)
    private Double  amount;

    @JsonView(View.Summary.class)
    @ManyToMany
    private List<Role> roles;


    @OneToMany
    private List<Receipt> receiptHistory;


    @OneToMany
    private List<CheckOut> checkoutInPossesion;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        if (roles == null) {
            this.roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Receipt> getReceiptHistory() {
        if (receiptHistory == null) {
            this.receiptHistory = new ArrayList<>();
        }
        return receiptHistory;
    }

    public void setReceiptHistory(List<Receipt> receiptHistory) {
        this.receiptHistory = receiptHistory;
    }

    public List<CheckOut> getCheckoutInPossesion() {
        if (checkoutInPossesion == null) {
            this.checkoutInPossesion = new ArrayList<>();
        }
        return checkoutInPossesion;
    }

    public void setCheckoutInPossesion(List<CheckOut> checkoutInPossesion) {
        this.checkoutInPossesion = checkoutInPossesion;
    }

    public User(Boolean active, Double amount, List<CheckOut> checkoutInPossesion, String email, String name, String password, List<Receipt> receiptHistory, List<Role> roles) {
        this.active = active;
        this.amount = amount;
        this.checkoutInPossesion = checkoutInPossesion;
        this.email = email;
        this.name = name;
        this.password = password;
        this.receiptHistory = receiptHistory;
        this.roles = roles;
    }

    public User() {
    }
}
