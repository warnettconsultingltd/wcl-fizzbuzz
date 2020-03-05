package com.wcl.fizzbuzz.integration.fizzbuzz;

import com.wcl.fizzbuzz.entity.FizzBuzzResult;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzStepDefinitions {
    private final String URL = "http://localhost:%d/fizzbuzz/v1";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<FizzBuzzResult> result;

    @When("the client calls \\/fizzbuzz with no parameters")
    public void whenTheClientCallsFizzbuzzAPIWithNoParameters() {
        try {
            performFizzBuzzAPICall();
        } catch (Exception e) {
            fail("Error accessing fizzbuzz endpoint :- "+ e.getMessage());
        }
    }

    @When("the client calls \\/fizzbuzz with non-numeric parameters")
    public void whenTheClientCallsFizzbuzzAPIWithNonNumericParameters() {
        try {
            performFizzBuzzAPICall();
        } catch (Exception e) {
            fail("Error accessing fizzbuzz endpoint :- "+ e.getMessage());
        }
    }

    @When("the client calls \\/fizzbuzz with end parameter less than start parameter")
    public void whenTheClientCallsFizzbuzzAPIWithEndParameterLessThanStartParameter() {
        try {
            performFizzBuzzAPICall();
        } catch (Exception e) {
            fail("Error accessing fizzbuzz endpoint :- "+ e.getMessage());
        }
    }

    @When("the client calls \\/fizzbuzz with end parameter same as start parameter")
    public void whenTheClientCallsFizzbuzzAPUWithEndParameterSameAsStartParameter() {
        try {
            performFizzBuzzAPICall();
        } catch (Exception e) {
            fail("Error accessing fizzbuzz endpoint :- "+ e.getMessage());
        }
    }

    @Then("the http status is 400 Bad Request")
    public void thenTheHTTPStatusIs400BadRequest() {
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Then("the http status is 200 OK")
    public void thenTheHTTPStatusIs200Ok() {
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @And("the client receives an error status of \"Both start and end values need to be provided\"")
    public void thenTheClientHasNotPassedStartAndEndValues() {
       assertEquals("Both start and end values need to be provided", result.getBody().getError());
       assertDataClear();
    }

    @And("the client receives an error status of \"The start number must be less than the end number\"")
    public void thenTheClientHasPassedNonNumalues() {
        assertEquals("The start number must be less than the end number", result.getBody().getError());
        assertDataClear();
    }

    private void performFizzBuzzAPICall() {
        result = restTemplate.getForObject(String.format(URL,port),  ResponseEntity.class);
    }

    private void assertDataClear() {
        assertNull(result.getBody().getRange());
        assertEquals(0, result.getBody().getFizz());
        assertEquals(0, result.getBody().getBuzz());
        assertEquals(0, result.getBody().getFizzBuzz());
        assertEquals(0, result.getBody().getInteger());
    }
}

@Data
class FizzBuzzError {
    Integer code;
    String error;
}
