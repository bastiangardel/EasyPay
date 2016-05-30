package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.pires.example.rest.View;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.orient.commons.repository.annotation.FetchPlan;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by bastiangardel on 15.05.16.
 */
//@JsonIgnoreProperties(value = {"handler"})

public class Receipt {
    @JsonView(View.Summary.class)
    @Id
    private String id;

    @Version
    private Long version;

    @JsonView(View.Summary.class)
    @CreatedDate
    private Date created;

    @JsonView(View.Summary.class)
    private Double amount;
    @JsonView(View.Summary.class)
    private boolean paid;

    @JsonView(View.Summary.class)
    @OneToOne
    private User paiyedBy;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public User getPaiyedBy() {
        return paiyedBy;
    }

    public void setPaiyedBy(User paiyedBy) {
        this.paiyedBy = paiyedBy;
    }
}
