package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import ObjectClasses.ArtProduct;
import ObjectClasses.SetupDriver;

public class ArtProductTest extends SetupDriver{
    
    @Test(priority = 0)
    public void addArtProductTest() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        artProduct.addArtProduct("Marvel", "C:/Users/Mypc/Desktop/MernProject/Fleet/public/images/placeholder.jpg", "1000", "Potrait", "Medium", "Maddy", "Painting", "Oil on Canvas", "7000", "ARTISTIC PAINTINGS... ");

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();     
        
        assertEquals("Art product details has been submitted.", alertMsg); 
    }

    // @Test
    // public void updateArtProductTest() {
    //     // login.adminLogin();
    //     ArtProduct artProduct = new ArtProduct(driver);
    //     artProduct.updateArtProduct("Wood and Bronze");

    //     Alert alert = driver.switchTo().alert();
    //     String alertMsg = alert.getText();
    //     alert.accept();     
        
    //     assertEquals("Art Product has been updated.", alertMsg); 
    // }

    @Test(priority = 1)
    public void deleteArtProductTest() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        artProduct.deleteArtProduct();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();     
        
        assertEquals("Data deleted", alertMsg); 
    }

}
