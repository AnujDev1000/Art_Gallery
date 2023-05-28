package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.Artist;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class ArtistTest {
    WebDriver driver;
    Login login;
    Artist artist;


    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        artist = new Artist(driver);
    }
    
    @Test
    public void addArtistTest() throws InterruptedException {
        login.adminLogin();
        artist.addArtist("Rock", "1234567890", "rock@gmail.com", "exampleEducation", "exampleEducation", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg");

        
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Artist details has been added.", alert.getText()); 
    }

    @Test
    public void updateArtistTest() {
        login.adminLogin();
        artist.updateArtist("john", "1234567890", "john@gmail.com", "exampleEducation", "exampleEducation", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Artist details has been updated.", alert.getText()); 
    }

    @Test
    public void deleteArtistTest() {
        login.adminLogin();
        artist.deleteArtist();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Data deleted", alert.getText()); 
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
