package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    private List<Receipt> Receipts;
}
