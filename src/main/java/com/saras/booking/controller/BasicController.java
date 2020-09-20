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
@RequestMapping("/")
public class BasicController {

    @PostMapping
    public String hello(){
        return "Hello World!";
    }

    @GetMapping
    public String customMessage(@RequestParam("msg") String msg){
        return msg;
    }


}
