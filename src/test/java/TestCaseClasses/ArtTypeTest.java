package TestCaseClasses;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtType;
import ObjectClasses.SetupDriver;

public class ArtTypeTest extends SetupDriver{

    @BeforeClass(alwaysRun=true)
    public void artType() {
        System.out.println("\n\n|| ARTTYPE ||");
    }
    
    @Test(priority = 9, groups = {"admin", "arttype"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void addArtTypeTest() {

        test.assignCategory("Art Type");
        ArtType artType = new ArtType(driver);
        artType.addArtType("pottery");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept(); 
        
        Assert.assertEquals("Artist type has been added.", alertMsg); 
        System.out.println("\nArtType Added SuccessFully!");
        artType.printTable();
    }
    
    @Test(priority = 10, groups = {"admin", "arttype"}, dependsOnMethods = "addArtTypeTest")
    public void updateArtTypeTest() {
        test.assignCategory("Art Type");
        ArtType artType = new ArtType(driver);
        artType.updateArtType("Sculpture");
        
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    

        Assert.assertEquals("Art type has been updated.", alertMsg); 
        System.out.println("\nArtType Updated Successfully!");
        artType.navigateToManagetoArtTypePage();
        artType.printTable();
    }
    
    @Test(priority = 11, groups = {"admin", "arttype"}, dependsOnMethods = "addArtTypeTest")
    public void deleteArtTypeTest() {
        test.assignCategory("Art Type");
        ArtType artType = new ArtType(driver);
        artType.deleteArtType();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();    

        Assert.assertEquals("Data deleted", alertMsg); 
        System.out.println("\nArtType Deleted Successfully!");
        artType.printTable();
    }
}
