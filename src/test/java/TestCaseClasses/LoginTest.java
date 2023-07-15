package TestCaseClasses;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectClasses.Login;
import ObjectClasses.SetupDriver;

public class LoginTest extends SetupDriver{
    
    @Test(groups = {"login"}, dependsOnMethods = {"AdminLoginWithInValidDetails"})
    public void AdminLoginWithValidDetails() {
        Login login = new Login(driver);
        login.adminLogin();
        String title = driver.getTitle();
        
        Assert.assertEquals("Art Gallery Management System - Admin Dashboard", title);
    }
    
    @Test( groups = {"login"})
    public void AdminLoginWithInValidDetails() {
        Login login = new Login(driver);
        login.navigateToAdminLoginPage();
        login.adminLogin("abc", "xyz"); 
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();

        // login.navigateBackToHomePage();
        Assert.assertEquals("Invalid Details", alertMsg);
    }

}
