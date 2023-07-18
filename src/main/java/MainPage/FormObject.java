package MainPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormObject{
    static WebDriver driver;

    public FormObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String firstName){
        driver.findElement(By.id("firstName")).sendKeys(firstName);}
    public void inputLastName(String lastName){
        driver.findElement(By.id("lastName")).sendKeys(lastName);}
    public void email(String email){
        driver.findElement(By.id("userEmail")).sendKeys(email);}
    public void radioButton() {
        WebElement radioButton = driver.findElement(By.cssSelector("input#gender-radio-2.custom-control-input"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioButton);
    }
    public void checkBox() {
        WebElement checkBox = driver.findElement(By.id("hobbies-checkbox-2"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkBox);
    }

    public void userName(String userNumber){
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);}
    public void subject(String subjectsInput){
        driver.findElement(By.id("subjectsInput")).sendKeys(subjectsInput);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.RETURN);
    }


    }
