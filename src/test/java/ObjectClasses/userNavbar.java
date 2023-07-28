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
        System.out.println("Home \n");
    }

    public void about()
    {
       WebElement navAbout=driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/a"));
       navAbout.click();
       System.out.println("About Us \n");
    }

    public void arttype()
    {
       WebElement navArttype=driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]"));
       navArttype.click();
       System.out.println("Art Type:- ");
    }

    public void contactus()
    {
        WebElement navContactus=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
        navContactus.click();
        System.out.println("\nContact Us\n");
    }

    public void admin()
    {
        WebElement navAdmin=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a"));
        navAdmin.click();
        System.out.println("Admin \n");
    }
    
    public void homepage()
    {
        driver.navigate().to("https://artgallery.neohire.io/");
    }
    
}
