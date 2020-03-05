package com.wcl.fizzbuzz.integration.health;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, strict=true, features="src/test/resources/features/healthcheck")
@SpringBootTest
public final class HealthCheckIntegrationTest {
}