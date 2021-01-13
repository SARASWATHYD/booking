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
 * on 2020-11-13 18:55
 */

@Data
@Entity
@Table(name="TBL_BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String bookingId;

    @Column(name="startTime")
    private long startTime;

    @Column(name="endTime")
    private long endTime;

    @Column(name="userId")
    private String userId;

    @Column(name="roomId")
    private String roomId;

    @Column(name="hotelId")
    private String hotelId;

    @Column(name="amount")
    private float amount;

    @Column(name="isDeleted")
    private boolean isDeleted;

}
