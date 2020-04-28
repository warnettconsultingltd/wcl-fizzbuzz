Feature: User can make a call to the FizzBuzz api

   Scenario: client makes call to GET /fizzbuzz with end parameter less then start parameter
     When the client calls /fizzbuzz with end parameter less than start parameter
     Then the http status is "400 Bad Request"
      And the client receives an error message of "The start number must be less than the end number"

  Scenario: client makes call to GET /fizzbuzz with negative parameters
    When the client calls /fizzbuzz with negative parameters
    Then the http status is "400 Bad Request"
     And the client receives an error message of "The start and end values must both be positive values and greater than zero"

  Scenario: client makes call to GET /fizzbuzz with negative start parameter
    When the client calls /fizzbuzz with negative start parameter
    Then the http status is "400 Bad Request"
    And the client receives an error message of "The start and end values must both be positive values and greater than zero"

  Scenario: client makes call to GET /fizzbuzz with negative end parameter
    When the client calls /fizzbuzz with negative end parameter
    Then the http status is "400 Bad Request"
    And the client receives an error message of "The start and end values must both be positive values and greater than zero"

  Scenario: client makes call to GET /fizzbuzz with identical parameters
    When the client calls /fizzbuzz with identical parameters
    Then the http status is "400 Bad Request"
     And  the client receives an error message of "The start number must be less than the end number"

  Scenario: client makes call to GET /fizzbuzz with valid parameters
    When the client calls /fizzbuzz with valid parameters
    Then the http status is "200 OK"
     And correct result returned