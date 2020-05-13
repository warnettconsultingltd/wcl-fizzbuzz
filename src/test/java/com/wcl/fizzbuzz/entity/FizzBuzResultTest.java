package com.wcl.fizzbuzz.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This test is completely unnecessary.  Lombok wraps the data values so any test is merely a test of a third party
 * library - this is left to to show the inanity of some companies "demanding" 100% code coverage...
 *
 * POJOs should never imo be tested via unit tests, rather via splash testing from integration tests.  The only instance
 * here it makes sense is if you've written the POJOs by hand, manually putting in getters, setters etc.  Where several
 * attributes have the same type, there's a chance of a mistake... but who rolls POJOs by hand these days?
 *
 * These tests are included to show the absolute inanity of chasing 100% code coverage by writing contrived meaningless
 * tests rather then excluding the POJOs in question...
 */
public class FizzBuzResultTest {
    private FizzBuzzResult result;

    @Before
    public void setup() {
        result = new FizzBuzzResult("5 to 15", "buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz",
                                 3, 2, 1, 5);
    }

    @Test
    public void checkRangeReturnedCorrectly() {
        assertEquals("5 to 15", result.getRange());
    }

    @Test
    public void checkResultReturnedCorrectly() {
        assertEquals("buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz", result.getResult());
    }

    @Test
    public void checkFizzCorrectlyReturned() {
        assertEquals(Integer.valueOf(3), result.getFizz());
    }

    @Test
    public void checkBuzzCorrectlyReturned() {
        assertEquals(Integer.valueOf(2), result.getBuzz());
    }

    @Test
    public void checkFizzBuzzCorrectlyReturned() {
        assertEquals(Integer.valueOf(1), result.getFizzBuzz());
    }

    @Test
    public void checkIntegerCorrectlyReturned() {
        assertEquals(Integer.valueOf(5), result.getInteger());
    }
}
