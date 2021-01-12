package com.saras.booking.service.booking;

import com.saras.booking.model.BookModel;
import com.saras.booking.service.date.DateUtils;

import java.util.Optional;

/**
 * Created by saraswathy
 * on 2021-01-12 10:18
 */
public class Validation {

    public void validateBookModel(BookModel bookModel){

        if(!Optional.ofNullable(bookModel).isPresent())
            throw new IllegalArgumentException("BookModel can't be null");

        stringValidation(bookModel.getEmail(),"BookModel");

        stringValidation(bookModel.getAddress(),"Address");

        stringValidation(bookModel.getHotelId(),"HotelId");

        stringValidation(bookModel.getRoomId(),"RoomId");

        stringValidation(bookModel.getStartTime(),"StartTime");

        stringValidation(bookModel.getUsername(),"UserName");

        String endTime  = !Optional.ofNullable(bookModel.getEndTime()).isPresent()?
                DateUtils.getDefaultEndTime(bookModel.getStartTime()) : bookModel.getEndTime();
        bookModel.setEndTime(endTime);


    }


    private void stringValidation(String property, String propertyName){
        if(!Optional.ofNullable(property).isPresent())
            throw new IllegalArgumentException(String.join("::",propertyName,
                    " can't be null"));
    }


}
