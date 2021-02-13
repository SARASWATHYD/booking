package com.saras.booking.controller;

import com.saras.booking.entity.Booking;
import com.saras.booking.model.BookModel;
import com.saras.booking.service.booking.BookingService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**Created by saraswathy
 *on 2020-08-30 13:39 */

@RestController
@RequestMapping("/book")
public class BasicController {

    @PutMapping
    public Booking updateBooking(@RequestBody BookModel bookModel) throws Exception{
        return  new BookingService().updateBooking(bookModel);
    }

    @GetMapping
    public Booking getBooking(@RequestParam("id") String id){
        return new BookingService().get(id);
    }


    @DeleteMapping
    public Boolean deleteBooking(@RequestParam("id") String id){
        return  new BookingService().deleteBooking(id);
    }

    @PostMapping
    public Booking bookRoom(@RequestBody BookModel bookModel) throws  Exception{
       return  new BookingService().bookRoom(bookModel);
    }
}
