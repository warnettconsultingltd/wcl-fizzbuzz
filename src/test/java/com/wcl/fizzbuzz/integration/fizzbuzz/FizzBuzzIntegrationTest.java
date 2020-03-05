package com.wcl.fizzbuzz.integration.fizzbuzz;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, strict=true, features="src/test/resources/features/fizzbuzz")
@SpringBootTest
public class FizzBuzzIntegrationTest {
}
