package com.saras.booking.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by saraswathy
 * on 2020-11-12 14:39
 */

@Data
@Entity
@Table(name="TBL_USER")
public class User {

    @Id
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phno")
    private String phno;

    @Column(name = "address")
    private String address;

    @Column(name = "pswd")
    private String pswd;

    @Column(name = "loginType")
    private String loginType;
}

