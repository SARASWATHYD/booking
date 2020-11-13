package com.saras.booking.service;

import com.saras.booking.entity.Hotel;
import com.saras.booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by saraswathy
 * on 2020-09-19 20:44
 */

@Service
public class HotelService {

    @Autowired
    HotelRepository repository;


    public Hotel createOrUpdateHotel(Hotel entity) {
        Optional<Hotel> hotel = repository.findById(entity.getEmail());
        if(hotel.isPresent()) {
            Hotel newEntity = hotel.get();
            newEntity.setName(entity.getName());
            newEntity.setPhno(entity.getPhno());
            newEntity = repository.save(newEntity);
            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    public void deleteHotel(String id){
        Optional<Hotel> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);
        repository.deleteById(id);

    }


    public Hotel getHotelById(String id){
        Optional<Hotel> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);
        return hotel.get();

    }

    public List<Hotel> getAllEmployees() {
        List<Hotel> hotels = repository.findAll();
        return hotels.size() > 0 ? hotels : new ArrayList<>();
    }

}
