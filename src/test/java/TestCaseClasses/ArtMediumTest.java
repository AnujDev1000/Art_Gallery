package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class ArtMediumTest {
    WebDriver driver;
    Login login;
    ArtMedium artMedium;


    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        artMedium = new ArtMedium(driver);
    }
    
    @Test
    public void addArtMediumTest() {
        login.adminLogin();
        artMedium.addArtMedium("Gold");

        Alert alert = driver.switchTo().alert();
        // System.out.println(alert.getText());    
        
        assertEquals("Art Medium has been added.", alert.getText()); 
    }

    @Test
    public void updateArtMediumTest() {
        login.adminLogin();
        artMedium.updateArtMedium("Wood and Bronze");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Art medium has been updated.", alert.getText()); 
    }

    @Test
    public void deleteArtMediumTest() {
        login.adminLogin();
        artMedium.deleteArtMedium();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Data deleted", alert.getText()); 
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
