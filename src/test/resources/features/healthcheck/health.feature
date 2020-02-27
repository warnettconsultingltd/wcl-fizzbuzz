Feature: User can make a call to the health facility of spring boot, receiving a successful response indicating that
         the api has been started and is running.

  Scenario: client makes call to GET /actuator/health
    When the client calls /actuator/health
  Then the client receives response status of up