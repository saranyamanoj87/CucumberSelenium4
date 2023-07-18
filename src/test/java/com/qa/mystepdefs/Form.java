package com.qa.mystepdefs;

import MainPage.FormObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Form {
    static WebDriver driver;
    static FormObject object;
    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            // driver.quit();
        }
    }
    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Get the WebDriver instance from your step definition class
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture the screenshot as a byte array
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            // Embed the screenshot in the Cucumber report
            scenario.attach(screenshotBytes, "image/png", "Screenshot");
            System.out.println("Screenshot taken and attached to the Cucumber report");
        }
    }
    @Given("I opened website")
    public void iOpenedWebsite() {

        driver.get("https://demoqa.com/automation-practice-form");
       driver.manage().window().maximize();
    }

    @Then("I should see popup window saying Thanks")
    public void iShouldSeePopupWindowSayingThanks() {
    System.out.println("Testing workflow in githubactins");
    }

    @When("I fill the form with correct details")
    public void iFillTheFormWithCorrectDetails() {
         object = new FormObject(driver);
         object.inputFirstName("FirstName");
         object.inputLastName("Lastname");
         object.email("qa@mailinator.com");
         object.radioButton();
         object.userName("8907654321");
         object.subject("hi");
         object.checkBox();

    }
}
