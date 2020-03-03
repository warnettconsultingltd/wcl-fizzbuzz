package com.wcl.fizzbuzz.controller;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public final class FizzBuzzController {
    @RequestMapping(method= RequestMethod.GET, value="/fizzbuzz/v1")
    public Optional<FizzBuzzResult> generateFizzBuzz() {
        return Optional.empty();
    }
}
