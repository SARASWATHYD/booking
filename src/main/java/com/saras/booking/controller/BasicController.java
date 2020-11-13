package com.saras.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**Created by saraswathy
 *
on 2020-08-30 13:39 */

@RestController
@RequestMapping("/book")
public class BasicController {

    @PostMapping
    public String hello(){
        return "Hello World!";
    }

    @GetMapping
    public String customMessage(@RequestParam("msg") String msg){
        return msg;
    }


    @PostMapping
    public String bookRoom(){
        //if new user write it in user table with type as customer.
        //else
        // step 1 : write data in booking table.
        // step 2 : write content in
        return "Hello World!";
    }
}
