package com.saras.booking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="email", nullable=false, length=200)
    private String email;


    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name +
                ", address=" + address + ", email=" + email   + "]";
    }
}
