package com.wcl.fizzbuzz.service;

import com.wcl.fizzbuzz.exception.InvalidFizzBuzzParametersException;
import org.springframework.stereotype.Service;

@Service
public class ParameterValidationService {
    public void validateParameters(final Integer startValue, final Integer endValue) throws InvalidFizzBuzzParametersException {
        if (startValue <= 0 || endValue <= 0) {
            throw new InvalidFizzBuzzParametersException("The start and end values must both be positive values and greater than zero");
        }

        if (startValue >= endValue) {
            throw new InvalidFizzBuzzParametersException("The start number must be less than the end number");
        }
    }
}