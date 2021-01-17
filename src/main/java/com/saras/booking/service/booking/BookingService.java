package com.saras.booking.service.booking;

import com.saras.booking.entity.Booking;
import com.saras.booking.model.BookModel;
import com.saras.booking.repository.BookingRepository;
import com.saras.booking.service.date.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
        isAvailable(bookModel);
        return true;
    }

    private boolean isAvailable(BookModel bookModel){
//        Booking booking = queryBooking(bookModel);

        return true;
    }

    @Query
    private Booking queryBooking(BookModel bookModel) throws  Exception{
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
