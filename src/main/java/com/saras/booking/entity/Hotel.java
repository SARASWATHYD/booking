package com.saras.booking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by saraswathy
 * on 2020-09-19 20:38
 */
@Data
@Entity
@Table(name="TBL_HOTEL")

public class Hotel {

    @Column(name = "name")
    private String name;

    @Column(name = "phno")
    private String phno;

    @Id
    private String email;

    @Column(name = "address")
    private String address;

}
