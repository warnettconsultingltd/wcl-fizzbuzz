package com.wcl.fizzbuzz.controller;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import com.wcl.fizzbuzz.service.FizzBuzzService;
import com.wcl.fizzbuzz.service.ParameterValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FizzBuzzController {

    @Autowired
    ParameterValidationService validatorService;

    @Autowired
    FizzBuzzService fizzBuzzService;

    @GetMapping(path="/fizzbuzz/v1")
    public FizzBuzzResult generateFizzBuzz(@RequestParam("start") Integer start, @RequestParam("end") Integer end) {
        validatorService.validateParameters(start, end);
        return fizzBuzzService.calculateFizzBuzzResult(start, end);
    }
}
