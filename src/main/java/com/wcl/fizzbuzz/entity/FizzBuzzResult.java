package com.wcl.fizzbuzz.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FizzBuzzResult {
    String range;
    Integer fizz;
    Integer buzz;
    Integer fizzBuzz;
    Integer integer;
    String error;
}
