package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.pires.example.rest.View;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bastiangardel on 15.05.16.
 */
@JsonIgnoreProperties(value = {"handler"})
public class CheckOut {
    @Id
    private String id;

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

/*    @PrePersist
    protected void onCreate() {
        created = new Date();
    }*/
}
