package com.saras.booking.service;

import com.saras.booking.entity.Room;
import com.saras.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by saraswathy
 * on 2020-11-12 22:06
 */

@Service
public class RoomService {

    @Autowired
    RoomRepository repository;


    public Room createOrUpdateHotel(Room entity) {
        System.out.println("repository::"+repository);
        Optional<Room> room = repository.findById(entity.getRoomId());
        if(room.isPresent()) {
            Room newEntity = room.get();
            newEntity.setHotelId(entity.getHotelId());
            newEntity.setCost(entity.getCost());
            newEntity.setRoomType(entity.getRoomType());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    public void deleteHotel(String id){
        Optional<Room> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);

        repository.deleteById(id);

    }


    public Room getHotelById(String id){
        Optional<Room> hotel = repository.findById(id);
        if(!hotel.isPresent())
            throw new IllegalArgumentException("hotel not found::"+id);

        return hotel.get();

    }

    public List<Room> getAllRooms() {
        List<Room> hotels = repository.findAll();

        if(hotels.size() > 0) {
            return hotels;
        } else {
            return new ArrayList<>();
        }
    }

}
