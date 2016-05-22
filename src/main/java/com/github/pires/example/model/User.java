package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.pires.example.rest.View;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class User {

    @Id
    private String id;

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
    private long  amount;

    @JsonView(View.Summary.class)
    @OneToMany
    private List<Role> roles;


    @OneToMany
    private List<Receipt> receiptHistory;


    @OneToMany
    private List<CheckOut> checkoutInPossesion;



    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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
}
