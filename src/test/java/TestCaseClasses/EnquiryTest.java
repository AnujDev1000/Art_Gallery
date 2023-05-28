package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.Enquiry;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class EnquiryTest {
    WebDriver driver;
    Login login;
    Enquiry enquiry;

    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        enquiry = new Enquiry(driver);
    }
    
    @Test
    public void enquiryMenuTest() {
        login.adminLogin();
        enquiry.enquirySubmenu();
    }

    @Test
    public void enquirySearchByNameTest() {
        login.adminLogin();
        List<List<WebElement>> data = enquiry.enquirySearch("Anuj");

        assertEquals("Anuj kumar", data.get(0).get(2).getText());
    }

    @Test
    public void enquirySearchByEnquiryNumberTest() {
        login.adminLogin();
        List<List<WebElement>> data = enquiry.enquirySearch("230873611");

        assertEquals("230873611", data.get(0).get(1).getText());
    }

    @Test
    public void enquirySearchByMobileNumberTest() {
        login.adminLogin();
        List<List<WebElement>> data = enquiry.enquirySearch("1234567890");

        assertEquals("1234567890", data.get(0).get(1).getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
