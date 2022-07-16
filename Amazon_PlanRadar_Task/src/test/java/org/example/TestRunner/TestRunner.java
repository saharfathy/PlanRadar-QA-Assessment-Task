package org.example.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\main\\resources\\Features",
        glue = "org/example",
        plugin = {
                    "pretty",
                   "html:target/cucumber.html",
                   "json:target/Cucumber.json",
                   "junit:target/cukes.xml",
                   "rerun:target/rerun.txt"},
        tags = "@AmazonTest"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
