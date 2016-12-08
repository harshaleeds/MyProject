package TestRunners;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@SuppressWarnings("deprecation")
public class StepDefinition1 {

	WebDriver driver;
	@Test
	@Before
	public void driverintialize()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Given("^I am on Gmail signin page$")
	public void signinpage()
	{
		driver.get("http://www.gmail.com");
	}
	
	@When("^I enter invalid email$")
	public void enterloginid()
	{
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("h@az.com");
	}
	
	@And("^click on Next button$")
	public void clicknext()
	{
		driver.findElement(By.xpath(".//*[@id='next']")).click();
	}
	
	@Then("^I get an error message$")
	public void errormsg()
	{
		WebDriverWait wd = new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='errormsg_0_Email']")));
		boolean val = driver.findElement(By.xpath("//span[@id='errormsg_0_Email']")).isDisplayed();
		Assert.assertFalse(val);
	}
	@After
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		}
		driver.close();
	}
}
