package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.SetupDriver;

public class ArtMediumTest extends SetupDriver {
    
    @Test(priority = 0)
    public void addArtMediumTest() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.addArtMedium("Gold");
        

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        assertEquals("Art medium has been added.", alertMsg); 
    }
    
    @Test(priority = 1)
    public void updateArtMediumTest() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.updateArtMedium("Wood and Bronze");
        

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        assertEquals("Art medium has been updated.", alertMsg); 
    }
    
    @Test(priority = 2)
    public void deleteArtMediumTest() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.deleteArtMedium();


        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        assertEquals("Data deleted", alertMsg); 
    }

}
