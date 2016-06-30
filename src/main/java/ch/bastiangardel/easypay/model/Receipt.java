package ch.bastiangardel.easypay.model;

import ch.bastiangardel.easypay.rest.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bastiangardel on 15.05.16.
 */

@Entity
@Table(name = "receipt")
public class Receipt {
    @JsonView(View.Summary.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    private String deviceToken;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Receipt(Double amount, User paiyedBy, boolean paid) {
        this.amount = amount;
        this.paiyedBy = paiyedBy;
        this.paid = paid;
    }



    public Receipt() {
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
}
