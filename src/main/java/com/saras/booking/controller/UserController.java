package com.saras.booking.controller;

import com.saras.booking.entity.User;
import com.saras.booking.service.UserService;
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
 * on 2020-11-12 14:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserService service;

        @PostMapping
        public ResponseEntity<User> addOrUpdateHotel(@RequestBody User user) {
            User updated = service.createOrUpdateUser(user);
            return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getHotelById(@PathVariable("id") String id) throws Exception {
            User entity = service.getUserByEmail(id);
            return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<User>> getAllHotels() {
            List<User> list = service.getAll();
            return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public HttpStatus deleteEmployeeById(@PathVariable("id") String id) throws Exception {
            service.deleteUserById(id);
            return HttpStatus.FORBIDDEN;
        }


    }
