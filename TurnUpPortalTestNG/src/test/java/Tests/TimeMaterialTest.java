package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TimeMaterialTest
{
    WebDriver driver;
    @BeforeMethod
    public void setUpSteps()
    {
        driver=new ChromeDriver();
        //Login Page Object initialization and definition
        LoginPage loginPageObj = new LoginPage();
        loginPageObj.loginActions(driver);

        //Home Page Object initialization and definition
        HomePage homePageObj = new HomePage();
        homePageObj.userVerification(driver);
        homePageObj.navigationToTimeAndMaterialPage(driver);
    }
    @Test(priority=0)
    public void createTimeModule() throws InterruptedException {
        //Time and Material Page Object initialization and definition
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        //Create Time Record
        timeMaterialObj.createNewTimeRecord(driver);
    }
    @Test(priority=1)
    public void editTimeModule() throws InterruptedException {
        //Edit Time Record
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        timeMaterialObj.editTimeRecord(driver);
    }
    @Test(priority=2)
    public void deleteTimeModule() throws InterruptedException {
        //Delete Time Record
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        timeMaterialObj.deleteTimeRecord(driver);
    }
    @AfterMethod
    public void closeTestRun()
    {
        driver.quit();
    }
}
