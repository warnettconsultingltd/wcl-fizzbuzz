package com.wcl.fizzbuzz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidFizzBuzzParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidFizzBuzzParametersException handleInvalidParameters(InvalidFizzBuzzParametersException exception)  {
        return exception;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Exception handleException(Exception e) {
        return e;
    }
}
