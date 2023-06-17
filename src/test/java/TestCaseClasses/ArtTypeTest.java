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

public class ArtTypeTest extends SetupDriver{
    
    @Test(priority = 0)
    public void addArtTypeTest() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);
        artType.addArtType("pottery");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Artist type has been added.", alertMsg); 
    }
    
    @Test(priority = 1)
    public void updateArtTypeTest() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);
        artType.updateArtType("Sculpture");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Art type has been updated.", alertMsg); 
    }
    
    @Test(priority = 2)
    public void deleteArtTypeTest() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);
        artType.deleteArtType();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Data deleted", alertMsg); 
    }

}
