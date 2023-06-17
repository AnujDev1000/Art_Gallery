package ObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    WebDriver driver;
    String username = "admin";
    String password = "Test@123";

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToAdminLoginPage() {
        WebElement navAdmin = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[5]/a"));
        navAdmin.click();
    }   

    public void sendUsernameKey(String username) {
        WebElement usernameInput = driver.findElement(By.xpath("/html/body/div/form/div/div[1]/input"));
        usernameInput.sendKeys(username);
    }

    public void sendPasswordKey(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/input"));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/form/div/lable/button"));
        loginButton.click();
    }

    public void delay() throws InterruptedException  {
        Thread.sleep(10000);
    }

    public void adminLogin() {
        // try {
		// 	delay();
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
        navigateToAdminLoginPage();
        sendUsernameKey(username);
        sendPasswordKey(password);
        clickLoginButton();
    }

    public void navigateBackToHomePage() {
        WebElement homepage = driver.findElement(By.xpath("/html/body/div/form/div/lable/p/a"));
        homepage.click();
    }

    public void adminLogin(String username, String password) {
        navigateToAdminLoginPage();
        sendUsernameKey(username);
        sendPasswordKey(password);
        clickLoginButton();
    }




    public void navigateToAdminLogoutPage() {
        WebElement navAdmin = driver.findElement(By.xpath("/html/body/section/header/div[2]/ul/li[2]/a"));
        navAdmin.click();
    }   
    
    public void clickLogoutButton() {
        WebElement logout = driver.findElement(By.xpath("//*[@id='container']/header/div[2]/ul/li[2]/ul/li[3]/a"));
        logout.click();
    }

    public void adminLogout() {
        navigateToAdminLogoutPage();
        clickLogoutButton();
    }
}