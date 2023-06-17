package ObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SetupDriver {
    public static WebDriver driver;

    public static WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mypc/Desktop/Maven/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://artgallery.neohire.io/");
        
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mypc/Desktop/Maven/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://artgallery.neohire.io/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
