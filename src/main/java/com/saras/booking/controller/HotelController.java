package com.saras.booking.controller;

import com.saras.booking.entity.Hotel;
import com.saras.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by saraswathy
 * on 2020-09-19 21:06
 */

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService service;
    @PostMapping
    public ResponseEntity<Hotel> addOrUpdateHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(service.createOrUpdateHotel(hotel), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String id) {
        Hotel entity = service.getHotelById(id);
        return new ResponseEntity<Hotel>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return new ResponseEntity<List<Hotel>>(service.getAllEmployees(), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") String id) {
        service.deleteHotel(id);
        return HttpStatus.FORBIDDEN;
    }

}
