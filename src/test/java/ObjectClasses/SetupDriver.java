package ObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
    static WebDriver driver;

    public static WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mypc/Desktop/Maven/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://artgallery.neohire.io/");
        
        return driver;
    }
}
