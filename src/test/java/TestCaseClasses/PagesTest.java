package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import ObjectClasses.Pages;
import ObjectClasses.SetupDriver;

public class PagesTest extends SetupDriver{
    
    // @Test
    // public void enquiryMenuTest() {
    //     // login.adminLogin();
    //     Pages pages = new Pages(driver);
    //     pages.pageSubmenu();
    // }

    @Test(priority = 0)
    public void updateAboutUsPageTest() {
        // login.adminLogin();
        Pages pages = new Pages(driver);
        pages.updateAboutUsPage("About Us", "<span style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>An art gallery is </span><b style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>an exhibition space to display and sell artworks</b><span style='color: rgb(32, 33, 36); font-family: arial, sans-serif; font-size: 16px;'>. As a result, the art gallery is a commercial enterprise working with a portfolio of artists. The gallery acts as the dealer representing, supporting, and distributing the artworks by the artists in question.</span><br>");

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();

        assertEquals("Something went wrong.", alertMsg);
    }
    
}
