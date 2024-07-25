package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TimeMaterialPage
{
    private final By createNewButtonLocator = By.xpath("//*[@id='container']/p/a");
    WebElement createNewButton;
    private final By typeCodeButtonLocator = By.xpath("//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span");
    WebElement typeCodeButton;
    private final By timeOptionLocator = By.xpath("//*[@id='TypeCode_listbox']/li[2]");
    WebElement timeOption;
    private final By codeTextboxLocator = By.id("Code");
    WebElement codeTextbox;
    private final By descriptionTextboxLocator = By.id("Description");
    WebElement descriptionTextbox;
    private final By overlapTextboxLocator = By.xpath("//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]");
    WebElement overlapTextbox;
    private final By priceTextboxLocator = By.id("Price");
    WebElement priceTextbox;
    private final By fileInputLocator = By.id("files");
    WebElement fileInput;
    private final By saveButtonLocator = By.id("SaveButton");
    WebElement saveButton;
    private final By goToLastPageLocator = By.xpath("//*[@id='tmsGrid']/div[4]/a[4]/span");
    WebElement goToLastPage;
    private final By lastCodeLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]");
    WebElement lastCode;
    private final By editButtonLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]");
    WebElement editButton;
    private final By materialOptionLocator = By.xpath("//*[@id='TypeCode_listbox']/li[1]");
    WebElement materialOption;
    private final By deleteButtonLocator = By.xpath("//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[2]");
    WebElement deleteButton;

    //Method To Create Time Record
    public void createNewTimeRecord(WebDriver driver) throws InterruptedException {
        try
        {
            Thread.sleep(2000);
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='container']/p/a",6);
            // Click on Create Button
            createNewButton = driver.findElement(createNewButtonLocator);
            createNewButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Create New Button is not selectable" + ex.getMessage());
        }

        //Select Time from the TypeCode dropdown
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span", 6);
        Thread.sleep(2000);
        typeCodeButton = driver.findElement(typeCodeButtonLocator);
        typeCodeButton.click();
        Thread.sleep(2000);
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='TypeCode_listbox']/li[2]", 6);
        timeOption = driver.findElement(timeOptionLocator);
        timeOption.click();

        //Enter Code into Code text box
        codeTextbox = driver.findElement(codeTextboxLocator);
        codeTextbox.sendKeys("TimeModule");

        //Enter Description into Description text box
        descriptionTextbox = driver.findElement(descriptionTextboxLocator);
        descriptionTextbox.sendKeys("New Time Module");

        //Enter Price per unit into Price text box
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]", 6);
        Thread.sleep(2000);
        //Identify overlapping element
        overlapTextbox = driver.findElement(overlapTextboxLocator);
        overlapTextbox.click();

        //Identifying the price web element
        priceTextbox = driver.findElement(priceTextboxLocator);
        priceTextbox.sendKeys("100");

        //File Upload
        fileInput = driver.findElement(fileInputLocator);
        fileInput.sendKeys("D:/Eba/Industry Connect/DemoImage.jpg");

        //Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
        //wait.Until(ExpectedConditions.ElementIsVisible(saveButtonLocator));
        Thread.sleep(2000);

        //Click on the Save button
        saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
       // Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]", 6);
        Thread.sleep(1000);
        //Click on Go to last Page button
        try
        {
            Thread.sleep(2000);
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
        String actualCode=getCode(driver);
        String expectedCode="TimeModule";
        Assert.assertEquals(actualCode,expectedCode);
    }

    public String getCode(WebDriver driver)
    {
        WebElement newTimeModule = driver.findElement(lastCodeLocator);
        return newTimeModule.getText();
    }

    //Method To Edit Time Record
    public void editTimeRecord(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]", 6);
        try
        {
            //Go To Last Page Button
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            Thread.sleep(3000);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
        Thread.sleep(2000);
        //Click on Edit Button
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[5]/a[1]", 5);
        editButton = driver.findElement(editButtonLocator);
        editButton.click();

        //Edit the TypeCode
        //Wait.WaitToBeClickable(driver, "XPath", "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span", 7);
        Thread.sleep(2000);
        typeCodeButton = driver.findElement(typeCodeButtonLocator);
        typeCodeButton.click();
        Thread.sleep(2000);
        //Wait.WaitToBeClickable(driver, "XPath", "//*[@id='TypeCode_listbox']/li[1]", 7);
        materialOption = driver.findElement(materialOptionLocator);
        materialOption.click();

        //Edit the Code
        codeTextbox = driver.findElement(codeTextboxLocator);
        codeTextbox.clear();
        codeTextbox.sendKeys("EditedTimeModule");

        //Edit Description
        descriptionTextbox = driver.findElement(descriptionTextboxLocator);
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys("Time Module is edited");
        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]", 5);
        Thread.sleep(3000);
        //Edit Price
        try
        {
            overlapTextbox = driver.findElement(overlapTextboxLocator);
            overlapTextbox.click();
            Thread.sleep(3000);
           // Wait.WaitToBeVisible(driver, "Id", "Price", 5);
            priceTextbox = driver.findElement(priceTextboxLocator);
            priceTextbox.clear();
            overlapTextbox.click();
            priceTextbox.sendKeys("200");
        }
        catch (Exception ex)
        {
            Assert.fail("Price textbox is not interactable" + ex.getMessage());
        }

        //File Upload
        fileInput = driver.findElement(fileInputLocator);
        fileInput.sendKeys("D:/Eba/Industry Connect/Demo2.jpg");

        //Wait.WaitToBeVisible(driver, "Id", "SaveButton", 5);
        Thread.sleep(2000);
        //Click on the Save button
        saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Thread.sleep(1000);
        // Wait.WaitToBeVisible(driver, "XPath", "//*[@id=\"tmsGrid\"]/div[4]", 6);
        try
        {
            //Go To Last Page
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            Thread.sleep(2000);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }
        String actualCode=getCode(driver);
        String expectedCode="EditedTimeModule";
        Assert.assertEquals(actualCode,expectedCode);
    }

    //Method To Delete Time Record
    public void deleteTimeRecord(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //Delete newly created time module
        try
        {
            //Go To Last Page Button
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            Thread.sleep(2000);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPage Button is not selectable" + ex.getMessage());
        }

        //Click on the delete button
        deleteButton = driver.findElement(deleteButtonLocator);
        deleteButton.click();

        //Handle pop up dialog box
        driver.switchTo().alert().accept();
        driver.navigate().refresh();

        try
        {
            Thread.sleep(2000);
            //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[4]/a[4]/span", 6);
            goToLastPage = driver.findElement(goToLastPageLocator);
            goToLastPage.click();
        }
        catch (Exception ex)
        {
            Assert.fail("GoToLastPageButton is not selectable" + ex.getMessage());
        }

        //Wait.WaitToBeVisible(driver, "XPath", "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[1]", 5);
        Thread.sleep(2000);
        //Check if the time module is deleted
        String actualCode=getCode(driver);
        String expectedCode="EditedTimeModule";
        Assert.assertNotEquals(actualCode,expectedCode);
    }
}
