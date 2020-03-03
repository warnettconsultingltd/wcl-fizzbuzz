package com.wcl.fizzbuzz.integration.health;

        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import lombok.Data;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.boot.web.server.LocalServerPort;
        import org.springframework.test.context.ContextConfiguration;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration
public class HealthCheckStepDefinitions {
    private final String URL = "http://localhost:%d/actuator/health";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private HealthStatus result;

    @When("the client calls \\/actuator\\/health")
    public void whenTheClientCallsActuatorHealth() {
        try {
            result = restTemplate.getForObject(String.format(URL,port),  HealthStatus.class);
        } catch (Exception e) {
            fail("Error accessing health actuator");
        }
    }

    @Then("the client receives response status of up")
    public void thenTheClientReceivesResponseStatusOfUp() {
        assertEquals("UP", result.getStatus());
    }
}

@Data
class HealthStatus {
    String status;
}