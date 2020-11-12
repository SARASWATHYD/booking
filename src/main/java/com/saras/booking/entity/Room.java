package com.saras.booking.entity;

/**
 * Created by saraswathy
 * on 2020-11-12 22:01
 */

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
@Table(name="TBL_ROOM")
public class Room {

    @Id
    private String roomId;

    @Column(name = "roomType")
    private String roomType;

    @Column(name = "hotelId")
    private String hotelId;

    @Column(name = "cost")
    private float cost;

}
