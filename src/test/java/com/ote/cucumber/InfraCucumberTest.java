package com.ote.cucumber;

import cucumber.api.CucumberOptions;
import junit5.cucumber.CucumberExtension;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.Stream;

@Tag("cucumber")
@CucumberOptions(
        format = {"pretty"},
        features = "src/test/resources/features",
        tags = {"~@Ignore"},
        glue = "com.ote.cucumber")
public class InfraCucumberTest {

    @ExtendWith(CucumberExtension.class)
    @TestFactory
    public Stream<DynamicTest> runCukes(Stream<DynamicTest> scenarios) {
        return scenarios;
    }
}