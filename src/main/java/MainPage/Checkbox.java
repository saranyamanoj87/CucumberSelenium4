package MainPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class Checkbox {
    private WebDriver driver;
    // Locators
    private By checkbxSelctStLocator = By.cssSelector("div.p-checkbox-box.p-component.p-clickable.p-highlight > span");
    private By selectedCheckboxTextLocator = By.cssSelector("tr.p-highlight > td:nth-child(3)");

    // Constructor
    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
//Getting web element when row gets highlighted after checkbox selected
    public WebElement highlightCheckbox() {
        WebElement selectedCheckbox;
        selectedCheckbox = driver.findElement(checkbxSelctStLocator);
        return selectedCheckbox;
    }

    //Getting the Name column of selected checkbox
    public String selectedCheckboxText() {
        WebElement text = driver.findElement(selectedCheckboxTextLocator);
        String textband = text.getText();
        System.out.println(textband);
        return textband;
    }


    public void checkboxColumn(String searchName) {
        //find table where checkbox is. it is a single weblement(webtable)
        WebElement table = driver.findElement(By.cssSelector("div:nth-child(6) > div > div > table > tbody"));
        // Get all rows
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        // Traverse each row
        for (WebElement row : allRows) {
            // Within each row, get the columns
            List<WebElement> allColumns = row.findElements(By.cssSelector("td"));
            // Check the third column's text
            if (allColumns.get(2).getText().equals(searchName)) {
                // allcolumn have matching condition, then asking to click on checkbox of that column
                allColumns.get(0).click();
                break;
            }
        }

    }
public String singlerow(String SearchName){
    WebElement table = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > table > tbody"));
    // Get all rows
    List<WebElement> allRows = table.findElements(By.tagName("tr"));
    // Traverse each row
    for (WebElement row : allRows) {
        // Within each row, get the columns
        List<WebElement> allColumns = row.findElements(By.cssSelector("td"));
        // Check the third column's text
        if (allColumns.get(1).getText().equals(SearchName)) {
            row.click();
            return allColumns.get(1).getText();
            //WebElement namecolumn = row.findElement(By.cssSelector("div:nth-child(2) > div > div > table > tbody > tr > td:nth-child(2)"));

            //return namecolumn.getText();
        }

    }
    return null;
}
public boolean highlightedrow(){
 driver.findElement(By.cssSelector("tr.p-highlight.p-selectable-row")).isDisplayed();
    return true;
}


    public String multiplerow(String SearchName){
        int num_rows_to_select =3;
        WebElement table = driver.findElement(By.cssSelector("tbody.p-datatable-tbody[xpath=\"2\"]"));
        // Get all rows
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        // Traverse each row
        for (WebElement row : allRows) {
            // Within each row, get the columns
            List<WebElement> allColumns = row.findElements(By.cssSelector("td"));
            // Check the third column's text
            if (allColumns.get(1).getText().equals(SearchName)) {
                row.click();
                Actions actions = new Actions(driver);
                //actions.moveToElement(row);
                actions.keyDown(Keys.META);
                for(WebElement allrow : allRows.subList(0, num_rows_to_select)) {
                    actions.click(allrow);
                }
                actions.keyUp(Keys.META);

                // Perform the action
                actions.build().perform();
                return allColumns.get(1).getText();
            }

        }
        return null;
    }
    public void multiplerowwithmetakey(String SearchName){
        int num_rows_to_select =3;
        WebElement table = driver.findElement(By.cssSelector("tbody.p-datatable-tbody[xpath=\"2\"]"));
        // Get all rows
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        // Traverse each row
        for (WebElement row : allRows) {
            // Within each row, get the columns
            List<WebElement> allColumns = row.findElements(By.cssSelector("td"));
            // Check the third column's text
            if (allColumns.get(1).getText().equals(SearchName)) {
                Actions actions = new Actions(driver);
                actions.keyDown(Keys.META);
                for(WebElement allrow : allRows.subList(0, num_rows_to_select)) {
                    actions.click(allrow);
                }
                actions.keyUp(Keys.META);

                // Perform the action
                actions.build().perform();
                //row.click();
                //return null;
            }

        }
       // return null;
    }
}