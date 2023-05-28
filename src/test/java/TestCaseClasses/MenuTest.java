package TestCaseClasses;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class MenuTest {
    WebDriver driver;
    Login login;

    String username = "admin";
    String password = "Test@123";

    @BeforeMethod
    public void setupDriver() {
        driver = SetupDriver.setup();
        login = new Login(driver);
    }

    @Test
    public void artistMenu(){
        login.adminLogin();   
        
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test
    public void artTypeMenu(){
        login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test
    public void mediumOfArtMenu(){
        login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test
    public void artProductMenu(){
        login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/a"));
        assertTrue( menu.isEnabled() );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

