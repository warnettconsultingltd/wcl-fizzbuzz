package com.wcl.fizzbuzz.service;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {
    private int fizzCount;
    private int buzzCount;
    private int fizzBuzzCount;
    private int integerCount;
    private StringBuilder result;

    private final Predicate<Integer> FIZZ_PREDICATE = i -> i % 3 == 0;
    private final Predicate<Integer> BUZZ_PREDICATE = i -> i % 5 == 0;

    public FizzBuzzResult calculateFizzBuzzResult(final Integer start, final Integer end) {
        clearData();

        IntStream.rangeClosed(start, end).forEach(
                this::performCalculations
        );

        return new FizzBuzzResult(String.format("%d to %d",start, end), cleanText(result.toString().trim()),
                fizzCount, buzzCount, fizzBuzzCount, integerCount);
    }

    private void clearData() {
        fizzCount = 0;
        buzzCount = 0;
        fizzBuzzCount = 0;
        integerCount = 0;
        result = new StringBuilder();
    }
    private String cleanText(final String text) {
        return text.substring(0,text.lastIndexOf(","));
    }

    private void performCalculations(int i) {
        if (FIZZ_PREDICATE.test(i))  {
            if (BUZZ_PREDICATE.test(i)) {
                fizzBuzzCount++;
                result.append("fizzbuzz");
            }
            else {
                fizzCount++;
                result.append("fizz");
            }
        } else if (BUZZ_PREDICATE.test(i)) {
            buzzCount++;
            result.append("buzz");
        } else {
            integerCount++;
            result.append(i);
        }

        result.append(", ");
     }
}
