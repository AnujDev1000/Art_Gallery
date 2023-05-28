package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 {
    WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mypc/Desktop/Maven/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://artgallery.neohire.io/");
    }

    @Test
    public void AdminLoginWithValidDetails() {
        String title = driver.getTitle();
        WebElement navAdmin = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[5]/a"));
        navAdmin.click();
        WebElement usernameInput = driver.findElement(By.xpath("/html/body/div/form/div/div[1]/input"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/input"));
        passwordInput.sendKeys("Test@123");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/form/div/lable/button"));
        loginButton.click();

        assertEquals("Art Gallery Management System - Admin Dashboard", title);
    }

    
}
