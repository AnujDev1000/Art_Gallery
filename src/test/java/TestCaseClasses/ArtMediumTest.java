package TestCaseClasses;


import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.SetupDriver;

public class ArtMediumTest extends SetupDriver {
    
    @BeforeClass(alwaysRun=true)
    public void artMedium() {
        System.out.println("\n\n|| ART MEDIUM ||");
    }

    @Test(priority = 12, groups = {"admin", "artMedium", "smoketest"}, dependsOnMethods = {"AdminLoginWithValidDetails"})
    public void addArtMediumTest() {
        test.assignCategory("Art Medium");
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.addArtMedium("Gold");
        

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        Assert.assertEquals("Art medium has been added.", alertMsg); 
        System.out.println("\nArt Medium Added SuccessFully!");
        artMedium.printTable();
    }
    
    @Test(priority = 13, groups = {"admin", "artMedium"}, dependsOnMethods = "addArtMediumTest")
    public void updateArtMediumTest() {
        test.assignCategory("Art Medium");
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.updateArtMedium("Wood and Bronze");
        

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        Assert.assertEquals("Art medium has been updated.", alertMsg); 
        System.out.println("\nArt Medium Updated SuccessFully!");
        artMedium.navigateToManagetoArtMediumPage();
        artMedium.printTable();
    }
    
    @Test(priority = 14, groups = {"admin", "artMedium", "smoketest"}, dependsOnMethods = "addArtMediumTest")
    public void deleteArtMediumTest() {
        test.assignCategory("Art Medium");
        ArtMedium artMedium = new ArtMedium(driver);
        artMedium.deleteArtMedium();


        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();   
        
        Assert.assertEquals("Data deleted", alertMsg); 
        System.out.println("\nArt Medium Deleted SuccessFully!");
        artMedium.printTable();
    }

}
