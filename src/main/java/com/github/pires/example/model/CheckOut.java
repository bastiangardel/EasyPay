package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastiangardel on 15.05.16.
 */
@JsonIgnoreProperties(value = {"handler"})
public class CheckOut {
    @Id
    private String id;

    @JsonIgnore
    private Long version;
    private Long created;
    private String UUID;
    private String name;

    @OneToOne
    private User Owner;

    @OneToMany
    private List<Receipt> ReceiptsHistory;

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
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
        return Owner;
    }

    public void setOwner(User owner) {
        Owner = owner;
    }

    public List<Receipt> getReceiptsHistory() {
        if (ReceiptsHistory == null) {
            this.ReceiptsHistory = new ArrayList<>();
        }
        return ReceiptsHistory;
    }

    public void setReceiptsHistory(List<Receipt> receiptsHistory) {
        ReceiptsHistory = receiptsHistory;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
