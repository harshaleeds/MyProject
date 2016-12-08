package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Featurefiles/GmailLogin.feature",
plugin={"pretty","html:target/cucumber-html"},
tags="@testGmail")

public class TestRunner1 extends AbstractTestNGCucumberTests {

}
