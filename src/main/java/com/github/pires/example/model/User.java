package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnore
    private Long version;
    private Long created;
    private String email;
    private String name;
    private Boolean active;
    private String password;
    private long  amount;

    @OneToMany
    private List<Role> roles;



    @OneToMany
    private List<Receipt> ReceiptHistory;


    @OneToMany
    private List<CheckOut> CheckoutInPossesion;



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
        if (ReceiptHistory == null) {
            this.ReceiptHistory = new ArrayList<>();
        }
        return ReceiptHistory;
    }

    public void setReceiptHistory(List<Receipt> receiptHistory) {
        ReceiptHistory = receiptHistory;
    }

    public List<CheckOut> getCheckoutInPossesion() {
        if (CheckoutInPossesion == null) {
            this.CheckoutInPossesion = new ArrayList<>();
        }
        return CheckoutInPossesion;
    }

    public void setCheckoutInPossesion(List<CheckOut> checkoutInPossesion) {
        CheckoutInPossesion = checkoutInPossesion;
    }
}
