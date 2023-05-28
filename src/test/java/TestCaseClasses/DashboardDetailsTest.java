package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.ArtMedium;
import ObjectClasses.ArtProduct;
import ObjectClasses.ArtType;
import ObjectClasses.Artist;
import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class DashboardDetailsTest {
    WebDriver driver;
    Login login;

    @BeforeClass
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
        login.adminLogin();
    }
    
    @Test
    public void artistDetails() {
        // login.adminLogin();
        Artist artist = new Artist(driver);

        List<List<WebElement>> data = artist.dashboardDetails();

        assertEquals(9, data.size());
    }

    @Test
    public void artTypeDetails() {
        // login.adminLogin();
        ArtType artType = new ArtType(driver);

        List<List<WebElement>> data = artType.dashboardDetails();

        assertEquals(9, data.size());
    }

    @Test
    public void artMediumDetails() {
        // login.adminLogin();
        ArtMedium artMedium = new ArtMedium(driver);

        List<List<WebElement>> data = artMedium.dashboardDetails();

        assertEquals(12, data.size());
    }

    @Test
    public void artProductDetails() {
        // login.adminLogin();
        ArtProduct artProduct = new ArtProduct(driver);
        List<List<WebElement>> data = artProduct.dashboardDetails();

        assertEquals(5, data.size());
    }

    @AfterMethod
    public void driverNavigateBackward() {
        driver.navigate().back();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

