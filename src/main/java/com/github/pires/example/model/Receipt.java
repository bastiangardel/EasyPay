package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by bastiangardel on 15.05.16.
 */
@JsonIgnoreProperties(value = {"handler"})
public class Receipt {
    @Id
    private String id;

    @Version
    private Long version;

    @CreatedDate
    private Date created;

    private long amount;
    private boolean ispaid;

    @OneToOne
    private User paiyedBy;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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

    public boolean ispaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
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
