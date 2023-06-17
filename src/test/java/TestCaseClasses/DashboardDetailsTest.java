package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.ArtProduct;
import ObjectClasses.ArtType;
import ObjectClasses.Artist;
import ObjectClasses.SetupDriver;

public class DashboardDetailsTest extends SetupDriver{
    
    @Test(priority = 0)
    public void artistDetails() {
        // login.adminLogin();
        Artist artist = new Artist(driver);

        List<List<WebElement>> data = artist.dashboardDetails();

        assertEquals(5, data.size());
    }

    @Test(priority = 1)
    public void artTypeDetails() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);

        List<List<WebElement>> data = artType.dashboardDetails();

        assertEquals(8, data.size());
    }

    @Test(priority = 2)
    public void artMediumDetails() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);

        List<List<WebElement>> data = artMedium.dashboardDetails();

        assertEquals(11, data.size());
    }

    @Test(priority = 3)
    public void artProductDetails() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        List<List<WebElement>> data = artProduct.dashboardDetails();

        assertEquals(4, data.size());
    }

    @AfterMethod
    public void driverNavigateBackward() {
        driver.navigate().back();
    }

}

