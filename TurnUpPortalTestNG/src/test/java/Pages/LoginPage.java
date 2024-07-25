package Pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class LoginPage
{
    //Functions that allow user to log in to TurnUp portal
    public void loginActions(WebDriver driver)
    {
        //Login Functionality in TurnUp portal
        //Launch TurnUp portal
        driver.navigate().to("http://horse.industryconnect.io/");

        //Fit the chrome according to the screen resolution
        driver.manage().window().maximize();

        //Identify the Username textbox and enter the username
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys("hari");

        //Identify the Password textbox and enter the password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");
        try
        {
            //Identify the Login button and click on it
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
            loginButton.click();
        }
        catch(ElementNotInteractableException ex)
        {
            Assert.fail("Login Button is not clickable" + ex.getMessage());
        }
    }
}
