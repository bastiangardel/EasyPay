package com.github.pires.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

/**
 * Created by bastiangardel on 15.05.16.
 */
@JsonIgnoreProperties(value = {"handler"})
public class Receipt {
    @Id
    private String id;

    @JsonIgnore
    private long amount;
    private boolean ispaid;
}
