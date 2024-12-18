package com.JorgeRosas.SB1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsRestController {

    @GetMapping("/greetings/{name}")
    public String greetings(@PathVariable String name){
        return "Hi, " + name;
    }

}
