package com.saras.booking.service.booking;

import com.saras.booking.entity.Booking;
import com.saras.booking.model.BookModel;
import com.saras.booking.repository.BookingRepository;
import com.saras.booking.service.date.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by saraswathy
 * on 2021-01-11 19:05
 */

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public void bookRoom(BookModel bookModel) throws  Exception{
        new Validation().validateBookModel(bookModel);
        //check availability
        boolean isAvailable = checkAvailability(bookModel);

        if(isAvailable){
            //block room in hotel
            blockRoomAtHotel(bookModel);
        }
        //save user and hotel and room entity
    }

    private void blockRoomAtHotel(BookModel bookModel){

        Booking booking = new Booking();
        booking.setBookingId(""); // random generate
        booking.setHotelId(bookModel.getHotelId());
        booking.setRoomId(bookModel.getRoomId());
        booking.setStartTime(DateUtils.getLongFromString(bookModel.getStartTime()));
        booking.setEndTime(DateUtils.getLongFromString(bookModel.getEndTime()));
        booking.setUserId(bookModel.getEmail());
        booking.setDeleted(false);
        create(booking);
    }



    private boolean checkAvailability(BookModel bookModel) throws  Exception{
        isAvailable(bookModel);
        return true;
    }

    private boolean isAvailable(BookModel bookModel) throws  Exception{
        List<Booking> booking = queryBooking(bookModel);
        return booking.isEmpty();
    }

    @Query
    private List<Booking> queryBooking(BookModel bookModel) throws  Exception{
        //check whetehr hotel rom is available with in time range

        return repository.getIntersectionBooking(bookModel.getRoomId(),
                DateUtils.getLongFromString(bookModel.getStartTime()),
                        DateUtils.getLongFromString(bookModel.getEndTime())).get().get();
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
