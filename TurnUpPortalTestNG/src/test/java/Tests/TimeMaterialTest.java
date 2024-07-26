package Tests;

import Pages.*;
import Utilities.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TimeMaterialTest extends CommonDriver
{
    @BeforeMethod
    public void setUpSteps()
    {
        driver=new ChromeDriver();
        LoginPage loginPageObj = new LoginPage();
        loginPageObj.loginActions(driver);
        HomePage homePageObj = new HomePage();
        homePageObj.userVerification(driver);
        homePageObj.navigationToTimeAndMaterialPage(driver);
    }
    @Test(priority=0,description = "This test is to create Time module")
    public void createTimeModule() throws InterruptedException
    {
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        timeMaterialObj.createNewTimeRecord(driver);
    }
    @Test(priority=1,description = "This test is to edit Time module")
    public void editTimeModule() throws InterruptedException
    {
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        timeMaterialObj.editTimeRecord(driver);
    }
    @Test(priority=2,description = "This test is to delete Time Module")
    public void deleteTimeModule() throws InterruptedException
    {
        TimeMaterialPage timeMaterialObj = new TimeMaterialPage();
        timeMaterialObj.deleteTimeRecord(driver);
    }
    @AfterMethod
    public void closeTestRun()
    {
        driver.quit();
    }
}
