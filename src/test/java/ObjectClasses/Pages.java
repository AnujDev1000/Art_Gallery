package ObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pages {
    WebDriver driver;

    public Pages(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToPages() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/a")).click();
    }
    
    public void submenuElements() {
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/ul"));
        List<WebElement> elms = menu.findElements(By.tagName("a"));

        for(WebElement a:elms){
            System.out.println(a.getText());
        }
    }

    public void pageSubmenu() {
        navigateToPages();
        submenuElements();
    }
    
    public void navigateToAboutUsPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[8]/ul/li[1]/a")).click();
    }
    
    public void fillPageTitle(String title) {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div/section/div/div/form/div[1]/div/input")).sendKeys(title);
    }

    public void fillPageDescription(String description) {
        driver.findElement(By.xpath("//*[@id='pagedes']")).sendKeys(description);
    }
    
    public void clickUpdateButton() {
        System.out.println(driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div/section/div/div/form/div[3]/div/button")).isEnabled());
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div/section/div/div/form/div[3]/div/button")).click();
    }

    public void updateAboutUsPage(String title, String description) {
        navigateToPages();
        navigateToAboutUsPage();
        fillPageTitle(title);
        fillPageDescription(description);
        clickUpdateButton();
    }
}