package com.wcl.fizzbuzz.controller;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FizzBuzzController {
    @RequestMapping(method= RequestMethod.GET, value="/fizzbuzz/v1")
    public ResponseEntity<FizzBuzzResult> generateFizzBuzz() {
        return ResponseEntity.status(HttpStatus.OK).body(FizzBuzzResult.builder().build());
    }
}
