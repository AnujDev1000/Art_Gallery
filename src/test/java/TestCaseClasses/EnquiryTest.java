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

public class EnquiryTest extends SetupDriver{
    
    @Test(priority = 0)
    public void enquiryMenuTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        enquiry.enquirySubmenu();
    }
    
    @Test(priority = 1)
    public void enquirySearchByNameTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch("Anuj");
        
        assertEquals("Anuj kumar", data.get(0).get(2).getText());
    }
    
    @Test(priority = 2)
    public void enquirySearchByEnquiryNumberTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch("230873611");
        
        assertEquals("230873611", data.get(0).get(1).getText());
    }
    
    @Test(priority = 3)
    public void enquirySearchByMobileNumberTest() {
        // login.adminLogin();
        Enquiry enquiry = new Enquiry(driver);
        List<List<WebElement>> data = enquiry.enquirySearch("1234567890");

        assertEquals("1234567890", data.get(0).get(3).getText());
    }

}
