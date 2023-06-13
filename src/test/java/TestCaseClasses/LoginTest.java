package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class LoginTest {
    WebDriver driver;
    Login login;

    @BeforeClass
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
    }

    @Test
    public void AdminLoginWithValidDetails() {
        login.adminLogin();
        String title = driver.getTitle();

        assertEquals("Art Gallery Management System - Admin Dashboard", title);
    }

    @Test
    public void AdminLoginWithInValidDetails() {
        login.adminLogin("abc", "xyz"); 
        Alert alert = driver.switchTo().alert();
        
        assertEquals("Invalid Details", alert.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
