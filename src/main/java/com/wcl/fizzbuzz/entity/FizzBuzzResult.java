package com.wcl.fizzbuzz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzzResult {
    String range;
    String result;
    Integer fizz;
    Integer buzz;
    Integer fizzBuzz;
    Integer integer;
}
