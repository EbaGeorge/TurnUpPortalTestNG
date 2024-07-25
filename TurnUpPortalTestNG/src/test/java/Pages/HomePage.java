package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage
{
    private final By timeMaterialOptionLocator = By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a");
    private final By adminTabLocator=By.xpath("/html/body/div[3]/div/div/ul/li[5]/a");
    public void navigationToTimeAndMaterialPage(WebDriver driver)
    {
        try
        {
            // Navigate to Time and Material Page
            WebElement administartionTab = driver.findElement(adminTabLocator);
            administartionTab.click();
            Thread.sleep(2000);
            //WebDriverWait webDriverWait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
            //webDriverWait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(timeMaterialOptionLocator));

            //Click on Time and Material Page
            WebElement timeAndMaterialModule = driver.findElement(timeMaterialOptionLocator);
            timeAndMaterialModule.click();
        }
        catch (Exception ex)
        {
            Assert.fail("TurnUpPortal Time and Material Page is not loaded"+ ex.getMessage());
        }
    }
    public void userVerification(WebDriver driver)
    {
        //Check if the user has logged in successfully
        WebElement helloHari = driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));

       String actualCode=helloHari.getText();
       String expectedCode="Hello hari!";
       Assert.assertEquals(actualCode,expectedCode);
    }
    public void navigationToEmployeesPage(WebDriver driver)
    {
        //Navigate to Employees page
        WebElement administartionTabEmployee = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        administartionTabEmployee.click();

        //Click on Employees tab
        WebElement employeeTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
        employeeTab.click();

    }
}
