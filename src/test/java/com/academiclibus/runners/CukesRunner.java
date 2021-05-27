package com.academiclibus.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "html:target/default-html-reports"},
        glue = "com/academiclibus/stepdefinitions",
        dryRun = false
)

public class CukesRunner {

}
