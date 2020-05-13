package com.wcl.fizzbuzz.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CustomExceptionHandlerTest {
    private CustomExceptionHandler testSubject;

    @Before
    public void setup() {
        testSubject = new CustomExceptionHandler();
    }

    @Test
    public void checkHandleInvalidParametersReturnsCorrectException() {
        final InvalidFizzBuzzParametersException exception = new InvalidFizzBuzzParametersException("test");
        assertEquals(exception, testSubject.handleInvalidParameters(exception));
    }

    @Test
    public void checkHandleExceptionReturnsCorrectException() {
        final IllegalArgumentException exception = new IllegalArgumentException("test");
        assertEquals(exception, testSubject.handleException(exception));
    }
}
