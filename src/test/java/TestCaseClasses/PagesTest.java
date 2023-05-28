package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.Pages;
import ObjectClasses.SetupDriver;

public class PagesTest {
    WebDriver driver;
    Login login;
    Pages pages;

    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
    }

    @Test
    public void enquiryMenuTest() {
        login.adminLogin();
        pages.pageSubmenu();
    }

    @Test
    public void updateAboutUsPageTest() {
        login.adminLogin();
        pages.updateAboutUsPage("About Us", "<span style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>An art gallery is </span><b style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>an exhibition space to display and sell artworks</b><span style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>. As a result, the art gallery is a commercial enterprise working with a portfolio of artists. The gallery acts as the dealer representing, supporting, and distributing the artworks by the artists in question.</span><br>");

        Alert alert = driver.switchTo().alert();
        assertEquals("About Us has been updated.", alert.getText());
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
