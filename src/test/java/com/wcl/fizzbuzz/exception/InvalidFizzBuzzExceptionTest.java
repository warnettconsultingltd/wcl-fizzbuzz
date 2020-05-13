package com.wcl.fizzbuzz.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Yet another utterly useless test class that provides nothing, after all it merely tests the exception inheritance
 * hierarchy works.
 *
 * Spoiler, if it didn't, vast swathes of Java code wouldn't work.
 *
 * Still, some companies want 100% coverage and don't want to exclude classes...
 */
public class InvalidFizzBuzzExceptionTest {

    @Test
    public void checkExceptionMessage() {
        final InvalidFizzBuzzParametersException exception = new InvalidFizzBuzzParametersException("test");
        assertEquals("test", exception.getMessage());
    }
}
