package com.symund.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/symund/step_definitions",
        dryRun = false,
        tags = "", //  We have to add login as a precondition to EACH feature file and use login Method in LoginPage.
        publish = true //generating a report with public link
)
public class CukesRunner {}
