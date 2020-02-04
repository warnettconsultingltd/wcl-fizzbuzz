package com.wcl.fizzbuzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FizzBuzzController {
    @RequestMapping(method= RequestMethod.GET, value="/fizzbuzz/v1")
    public String generateFizzBuzz() {
        return "FizzBuzz";
    }
}
