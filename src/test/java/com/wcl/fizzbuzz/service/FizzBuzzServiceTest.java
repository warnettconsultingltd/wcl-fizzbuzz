package com.wcl.fizzbuzz.service;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FizzBuzzServiceTest {
    private FizzBuzzService testSubject;

    @Before
    public void setup() {
        testSubject = new FizzBuzzService();
    }

    @Test
    public void checkRangeCorrectlyDetermined() {
        final FizzBuzzResult result = testSubject.calculateFizzBuzzResult(76,87);
        assertEquals("76 to 87", result.getRange());
    }

    @Test
    public void checkAFizzIsCorrectlyDetermined() {
        final FizzBuzzResult result = testSubject.calculateFizzBuzzResult(3,4);

        assertEquals("fizz, 4", result.getResult());
    }

    @Test
    public void checkABuzzIsCorrectlyDetermined() {
        final FizzBuzzResult result = testSubject.calculateFizzBuzzResult(5,6);
        assertEquals("buzz, fizz", result.getResult());
    }

    @Test
    public void checkAFizzBuzzIsCorrectlyDetermined() {
        final FizzBuzzResult result = testSubject.calculateFizzBuzzResult(15,16);
        assertEquals("fizzbuzz, 16", result.getResult());
    }

    @Test
    public void checkAnIntegerIsCorrectlyDetermined() {
        final FizzBuzzResult result = testSubject.calculateFizzBuzzResult(1,2);
        assertEquals("1, 2", result.getResult());
    }
}
