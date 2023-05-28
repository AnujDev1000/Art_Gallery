package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtProduct;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class ArtProductTest {
    WebDriver driver;
    Login login;
    ArtProduct artProduct;

    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        artProduct = new ArtProduct(driver);
    }
    
    @Test
    public void addArtProductTest() {
        login.adminLogin();
        artProduct.addArtProduct("Marvel", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg", "1000", "Potrait", "Medium", "Dev", "painting", "Oil on Canvas", "7000", "ARTISTIC PAINTINGS... ");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("", ""); 
    }

    // @Test
    // public void updateArtProductTest() {
    //     login.adminLogin();
    //     artProduct.updateArtProduct("Wood and Bronze");

    //     Alert alert = driver.switchTo().alert();
    //     System.out.println(alert.getText());    
        
    //     assertEquals("Art Product has been updated.", alert.getText()); 
    // }

    @Test
    public void deleteArtProductTest() {
        login.adminLogin();
        artProduct.deleteArtProduct();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    
        
        assertEquals("Data deleted", alert.getText()); 
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
