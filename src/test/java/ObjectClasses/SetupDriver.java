package ObjectClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import utils.ExtentManager;
import utils.MyTestListener;

@Listeners(MyTestListener.class)
public class SetupDriver {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://artgallery.neohire.io/");
        extent = ExtentManager.getInstance();
        System.out.println("\n\n || TESTSUITE STARTED ||");
        
    }

    // @BeforeMethod(alwaysRun = true)
    // public void beforeMethod(Method method) {
    //     // System.out.println(method.getName());
    //     test = ExtentManager.createTest(method.getName());
    // }

    // @AfterMethod(alwaysRun = true)
    // public void afterMethod(ITestResult result) {
    //     // System.out.println(result.getStatus());
    //     if (result.getStatus() == ITestResult.FAILURE) {
    //         test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
    //     } else if (result.getStatus() == ITestResult.SKIP) {
    //         test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    //     } else {
    //         test.log(Status.PASS, "Test Passed");
    //     }
    // }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("\n\n || TESTSUITE TERMINATED || \n\n");
        extent.flush();
        driver.quit();
    }
}
