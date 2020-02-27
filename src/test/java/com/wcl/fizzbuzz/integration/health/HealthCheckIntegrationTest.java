package com.wcl.fizzbuzz.integration.health;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, strict=true, features="src/test/resources/features/")
public final class HealthCheckIntegrationTest {
}