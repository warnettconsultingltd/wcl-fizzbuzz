package com.wcl.fizzbuzz.service;

import com.wcl.fizzbuzz.exception.InvalidFizzBuzzParametersException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Whilst there is a valid test for the case where the start parameter is zero, cannot produce one for the end
 * parameter being zero. Why not?  Simply because to produce a test requires the start parameter to be less than the
 * end parameter in order to provide a valid test.  That would thus mean the start parameter being less than zero which
 * isn't a valid case.
 */
public class ParameterValidationServiceTest {
    private ParameterValidationService testSubject;

    @Before
    public void setup() {
        testSubject = new ParameterValidationService();
    }

    @Test
    public void checkThatCorrectExceptionThrownWhenStartParameterNegative() {
        final Exception exception = assertThrows(InvalidFizzBuzzParametersException.class,
                                                 () -> testSubject.validateParameters(-1,1));
        assertEquals("The start and end values must both be positive values and greater than zero",
                      exception.getMessage());
    }

    @Test
    public void checkThatCorrectExceptionThrownWhenStartParameterZero() {
        final Exception exception = assertThrows(InvalidFizzBuzzParametersException.class,
                () -> testSubject.validateParameters(0,1));
        assertEquals("The start and end values must both be positive values and greater than zero",
                exception.getMessage());
    }

    @Test
    public void checkThatCorrectExceptionThrownWhenEndParameterNegative() {
        final Exception exception = assertThrows(InvalidFizzBuzzParametersException.class,
                                                 () -> testSubject.validateParameters(1,-1));

        assertEquals("The start and end values must both be positive values and greater than zero",
                exception.getMessage());
    }

    @Test
    public void checkThatCorrectExceptionThrownWhenStartParameterGreaterThanEndParameter() {
        final Exception exception = assertThrows(InvalidFizzBuzzParametersException.class,
                                                 () -> testSubject.validateParameters(12,6));

        assertEquals("The start number must be less than the end number",
                exception.getMessage());
    }

    @Test
    public void checkThatCorrectExceptionThrownWhenStartAndEndParameterIdentical() {
        final Exception exception = assertThrows(InvalidFizzBuzzParametersException.class,
                                                 () -> testSubject.validateParameters(7, 7));

        assertEquals("The start number must be less than the end number",
                exception.getMessage());
    }

    @Test
    public void testNoExceptionThrownWhenValidParameters() {
        try {
            testSubject.validateParameters(54, 67);
        } catch (InvalidFizzBuzzParametersException e) {
            fail(e.getMessage());
        }
    }
}
