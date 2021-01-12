package com.saras.booking.service.booking;

import com.saras.booking.entity.Booking;
import com.saras.booking.entity.Hotel;
import com.saras.booking.entity.Room;
import com.saras.booking.model.BookModel;
import com.saras.booking.repository.BookingRepository;
import com.saras.booking.service.HotelService;
import com.saras.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by saraswathy
 * on 2021-01-11 19:05
 */

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public void bookRoom(BookModel bookModel){
        new Validation().validateBookModel(bookModel);
        //check availability
        boolean isAvailable = checkAvailability(bookModel);
        //block room in hotel
        //save user and hotel and room entity
    }


    private boolean checkAvailability(BookModel bookModel){
        Hotel hotel = getHotel(bookModel.getHotelId());
        Room room = getRoom(bookModel.getRoomId());

        isAvailable(bookModel);
        return true;
    }

    private boolean isAvailable(BookModel bookModel){
//        Booking booking = queryBooking(bookModel);

        return true;
    }

    private Hotel getHotel(String hotelId){
        Hotel hotel = new HotelService().getHotelById(hotelId);
         if(!Optional.ofNullable(hotel).isPresent())
             throw new IllegalArgumentException("Sorry hotel is not available::"+ hotelId);

         return hotel;

    }

    private Room getRoom(String roomId){
        Room room = new RoomService().getRoomById(roomId);
        if(!Optional.ofNullable(room).isPresent())
            throw new IllegalArgumentException("Sorry Room is not available::"+ roomId);
        return room;
    }

    private Booking queryBooking(){
        //check whetehr hote l rom is available with in time range
        return new Booking();
    }



    public Booking create(Booking booking) {
        return  repository.save(booking);

    }

    public Booking update(Booking entity) {
        Optional<Booking> booking = repository.findById(entity.getBookingId());
        if (!booking.isPresent())
            throw new IllegalArgumentException("Id doesnt not exists::" + entity.getBookingId());

            return repository.save(entity);

    }


    public boolean deleteBooking(String bookingId){
        Optional<Booking> booking = repository.findById(bookingId);
        if(!booking.isPresent())
            return false;
        repository.deleteById(bookingId);
        return true;

    }

}
