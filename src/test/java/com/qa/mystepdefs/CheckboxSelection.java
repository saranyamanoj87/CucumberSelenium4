package com.qa.mystepdefs;

import MainPage.Checkbox;

import io.cucumber.java.After;
import io.cucumber.java.Before;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class CheckboxSelection {
    private WebDriver driver;
    private Checkbox checkBox;

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

    @Given("I opened primereact website")
    public void iOpenedPrimereactWebsite() {
        driver.get("https://www.primefaces.org/primereact-v5/#/datatable/selection");
        driver.manage().window().maximize();
        checkBox = new Checkbox(driver);
    }
    @When("I click on the checkbox against {string} checkbox")
    public void iClickOnTheCheckboxAgainstCheckbox(String arg0)  {
        checkBox.checkboxColumn(arg0);
        Assert.assertEquals(checkBox.highlightCheckbox().isDisplayed(),true);
    }
    @Then("I should see checkbox {string} get selected successfully")
    public void iShouldSeeCheckboxGetSelectedSuccessfully(String arg0) {
        Assert.assertEquals(checkBox.selectedCheckboxText(),arg0);
    }



}

