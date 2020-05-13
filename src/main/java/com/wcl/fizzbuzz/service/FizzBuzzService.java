package com.wcl.fizzbuzz.service;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {
    private int fizz;
    private int buzz;
    private int fizzBuzz;
    private int integer;
    private final StringBuilder result = new StringBuilder();

    private final Predicate<Integer> FIZZ_PREDICATE = i -> i % 3 == 0;
    private final Predicate<Integer> BUZZ_PREDICATE = i -> i % 5 == 0;

    public FizzBuzzResult calculateFizzBuzzResult(final Integer start, final Integer end) {
        IntStream.rangeClosed(start, end).forEach(
                this::performCalculations
        );

        return new FizzBuzzResult(String.format("%d to %d",start, end), cleanText(result.toString().trim()),
                                  fizz, buzz, fizzBuzz, integer);
    }

    private String cleanText(final String text) {
        return text.substring(0,text.lastIndexOf(","));
    }

    private void performCalculations(int i) {
        if (FIZZ_PREDICATE.test(i))  {
            if (BUZZ_PREDICATE.test(i)) {
                fizzBuzz ++;
                result.append("fizzbuzz");
            }
            else {
                fizz++;
                result.append("fizz");
            }
        } else if (BUZZ_PREDICATE.test(i)) {
            buzz++;
            result.append("buzz");
        } else {
            integer++;
            result.append(i);
        }

        result.append(", ");
     }
}
