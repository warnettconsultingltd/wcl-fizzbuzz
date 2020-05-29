package com.wcl.fizzbuzz.integration.fizzbuzz;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzStepDefinitions {
    private final String URL = "http://localhost:%d/fizzbuzz/v1?start=%d&end=%d";

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> result;

    @When("the client calls \\/fizzbuzz with end parameter less than start parameter")
    public void whenTheClientCallsFizzbuzzAPIWithEndParameterLessThanStartParameter() {
        performFizzBuzzAPICall(6,4);
    }

    @When("the client calls \\/fizzbuzz with negative start parameter")
    public void whenTheClientCallsFizzbuzzAPIWithNegativeStartParameter() {
        performFizzBuzzAPICall(-3,4);
    }

    @When("the client calls \\/fizzbuzz with start parameter zero")
    public void whenTheClientCallsFizzbuzzAPIWithStartParameterZero() {
        performFizzBuzzAPICall(0,4);
    }

    @When("the client calls \\/fizzbuzz with negative end parameter")
    public void whenTheClientCallsFizzbuzzAPIWithNegativeEndParameter() {
        performFizzBuzzAPICall(3,-4);
    }

    @When("the client calls \\/fizzbuzz with identical parameters")
    public void whenTheClientCallsFizzbuzzAPIWithIdenticalParameters() {
        performFizzBuzzAPICall(9,9);
    }

    @When("the client calls \\/fizzbuzz with valid parameters")
    public void whenTheClientCallsFizzbuzzAPIWithValidParameters() {
        performFizzBuzzAPICall(4, 24);
    }

    @And("a second invocation with valid parameters occurs")
    public void secondValidInvocationOccurs() { performFizzBuzzAPICall(25, 32); }

    @Then("the http status is {string}")
    public void thenTheHTTPStatusIsReturnedCorrectly(final String statusText) {
        final int code = Integer.parseInt(statusText.substring(0,statusText.indexOf(" ")));
        assertEquals(HttpStatus.valueOf(code), result.getStatusCode());
    }

    @And("the client receives an error message of {string}")
    public void thenTheClientErrorMessageIsReturnedCorrectly(final String message) throws JSONException {
        final JSONObject resultObject = convertToJSONObject();
        assertEquals(message, resultObject.getString("message"));
    }

    @Then("correct result returned")
    public void thenTheCorrectResultReturned() throws JSONException {
        final JSONObject resultObject = convertToJSONObject();

        assertEquals("4 to 24", resultObject.getString("range"));
        assertEquals("4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz, fizz, 22, 23, fizz",
                     resultObject.getString("result"));
        assertEquals(6, resultObject.getInt("fizz"));
        assertEquals(3, resultObject.getInt("buzz"));
        assertEquals(1, resultObject.getInt("fizzBuzz"));
        assertEquals(11, resultObject.getInt("integer"));
    }

    @And("only results for the second invocation are returned")
    public void onlyResultsForSecondInvocationReturned() throws JSONException {
        final JSONObject resultObject = convertToJSONObject();

        assertEquals("25 to 32", resultObject.getString("range"));
        assertEquals("buzz, 26, fizz, 28, 29, fizzbuzz, 31, 32",
                resultObject.getString("result"));
        assertEquals(1, resultObject.getInt("fizz"));
        assertEquals(1, resultObject.getInt("buzz"));
        assertEquals(1, resultObject.getInt("fizzBuzz"));
        assertEquals(5, resultObject.getInt("integer"));
    }

    private void performFizzBuzzAPICall(final Integer start, final Integer end) {
        try {
            result = restTemplate.getForEntity(String.format(URL, port, start, end) ,  String.class);
       } catch (Exception e) {
            fail("Error accessing fizzbuzz endpoint :- " + e.getMessage());
        }
    }

    private JSONObject convertToJSONObject() throws JSONException {
        assertNotNull(result);

        return new JSONObject(result.getBody());
    }
}


