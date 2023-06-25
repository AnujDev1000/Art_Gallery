package ObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userNavbar {
    WebDriver driver;

    public userNavbar(WebDriver driver)
    {
        this.driver=driver;
    }

    public void home() 
    {
        WebElement navHome = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[1]/a"));
        navHome.click();
    }

    public void about()
    {
       WebElement navAbout=driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/a"));
       navAbout.click();
    }

    public void arttype()
    {
       WebElement navArttype=driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]"));
       navArttype.click();
    }

    public void contactus()
    {
        WebElement navContactus=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
        navContactus.click();
    }

    public void admin()
    {
        WebElement navAdmin=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a"));
        navAdmin.click();
    }
    
    public void homepage()
    {
        driver.navigate().to("https://artgallery.neohire.io/");
    }
    
}
