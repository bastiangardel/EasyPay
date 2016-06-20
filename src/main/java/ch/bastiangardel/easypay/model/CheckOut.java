package ch.bastiangardel.easypay.model;

import ch.bastiangardel.easypay.rest.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bastiangardel on 15.05.16.
 */

@Entity
@Table(name = "checkout")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @CreatedDate
    private Date created;

    @JsonView(View.Summary.class)
    private String uuid;
    @JsonView(View.Summary.class)
    private String name;

    @JsonView(View.Summary.class)
    @OneToOne
    private User owner;


    @OneToMany
    private List<Receipt> receiptsHistory;


    @OneToOne
    private Receipt lastReceipt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Receipt> getReceiptsHistory() {
        if (receiptsHistory == null) {
            this.receiptsHistory = new ArrayList<>();
        }
        return receiptsHistory;
    }

    public void setReceiptsHistory(List<Receipt> receiptsHistory) {
        this.receiptsHistory = receiptsHistory;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Receipt getLastReceipt() {
        return lastReceipt;
    }

    public void setLastReceipt(Receipt lastReceipt) {
        this.lastReceipt = lastReceipt;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }


    public CheckOut(Date created, String uuid, List<Receipt> receiptsHistory, User owner, String name, Receipt lastReceipt) {
        this.created = created;
        this.uuid = uuid;
        this.receiptsHistory = receiptsHistory;
        this.owner = owner;
        this.name = name;
        this.lastReceipt = lastReceipt;
    }

    public CheckOut() {
    }


}
