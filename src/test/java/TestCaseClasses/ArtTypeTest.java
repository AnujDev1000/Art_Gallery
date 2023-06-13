package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtType;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class ArtTypeTest {
    WebDriver driver;
    Login login;
    ArtType artType;

    String username = "admin";
    String password = "Test@123";

    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        artType = new ArtType(driver);
    }
    
    @Test
    public void addArtTypeTest() {
        login.adminLogin();
        artType.addArtType("pottery");

        Alert alert = driver.switchTo().alert();
        // System.out.println(alert.getText());    
        
        assertEquals("Artist type has been added.", alert.getText()); 
    }

    @Test
    public void updateArtTypeTest() {
        login.adminLogin();
        artType.updateArtType("Sculpture");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Art type has been updated.", alert.getText()); 
    }

    @Test
    public void deleteArtTypeTest() {
        login.adminLogin();
        artType.deleteArtType();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Data deleted", alert.getText()); 
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
