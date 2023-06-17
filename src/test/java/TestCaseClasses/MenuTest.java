package TestCaseClasses;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;

public class MenuTest extends SetupDriver{

    @Test(priority = 0)
    public void artistMenu(){
        // login.adminLogin();   
        
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[2]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test(priority = 1)
    public void artTypeMenu(){
        // login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test(priority = 2)
    public void mediumOfArtMenu(){
        // login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a"));
        assertTrue( menu.isEnabled() );
    }

    @Test(priority = 3)
    public void artProductMenu(){
        // login.adminLogin();

        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/a"));
        assertTrue( menu.isEnabled() );
    }

}

