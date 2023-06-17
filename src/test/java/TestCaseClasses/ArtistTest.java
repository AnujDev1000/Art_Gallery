package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import ObjectClasses.Artist;
import ObjectClasses.SetupDriver;

public class ArtistTest extends SetupDriver{
    
    @Test(priority = 0)
    public void addArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);
        artist.addArtist("Rock", "1234567890", "rock@gmail.com", "exampleEducation", "exampleEducation", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg");

        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Artist details has been added.", alertMsg); 
    }

    @Test(priority = 1)
    public void updateArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);
        artist.updateArtist("john", "1234567890", "john@gmail.com", "exampleEducation", "exampleEducation", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg");

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Artist details has been updated.", alertMsg); 
    }

    @Test(priority = 2)
    public void deleteArtistTest() {
        // login.adminLogin();
        Artist artist = new Artist(driver);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        artist.deleteArtist();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    
        
        assertEquals("Data deleted", alertMsg); 
        
    }
}
