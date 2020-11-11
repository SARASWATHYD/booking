package com.saras.booking.service.hotelservice;

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
        System.out.println(entity.getId());
        Optional<Hotel> hotel = repository.findById(entity.getId());

        if(hotel.isPresent()) {
            Hotel newEntity = hotel.get();
            newEntity.setName(entity.getName());
            newEntity.setAddress(entity.getAddress());
            newEntity.setEmail(entity.getEmail());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    public void deleteHotel(long id){
        Optional<Hotel> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);

        repository.deleteById(id);

    }


    public Hotel getHotelById(long id){
        Optional<Hotel> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);

        return hotel.get();

    }

    public List<Hotel> getAllEmployees()
    {
        List<Hotel> hotels = repository.findAll();

        if(hotels.size() > 0) {
            return hotels;
        } else {
            return new ArrayList<>();
        }
    }



}
