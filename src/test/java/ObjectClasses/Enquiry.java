package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry {
    WebDriver driver;

    public Enquiry(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToEnquiryPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/a")).click();
    }
    
    public void submenuElements() {
        WebElement menu = driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/ul"));
        List<WebElement> elms = menu.findElements(By.tagName("a"));

        for(WebElement a:elms){
            System.out.println(a.getText());
        }
    }
    
    public void enquirySubmenu() {
        navigateToEnquiryPage();
        submenuElements();
    }
    
    public void navigateEnquirySearchPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[7]/a")).click();
    }
    
    public void fillSearchQuery(String search) {
        driver.findElement(By.xpath("//*[@id='searchdata']")).sendKeys(search);
    }

    public void clickSubmitButton() {
        System.out.println(driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > header > form > p > button")).isEnabled());

        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > header > form > p > button")).click();
    }

    public List<List<WebElement>> getTableData() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<WebElement>> data = new ArrayList<>();

        if(rows.size() > 0){
            for(WebElement row:rows){
                List<WebElement> cols = row.findElements(By.tagName("td"));
                List<WebElement> rowData = new ArrayList<>();
        
                for (WebElement col : cols) {
                    rowData.add(col);
                }
    
                data.add(rowData);
            }
    
            for (List<WebElement> list : data) {
                List<String> cols = new ArrayList<>(); 
                for (WebElement col : list) {
                    cols.add(col.getText());
                }
    
                System.out.println(cols);
            }
        }
        return data;
    }

    public List<List<WebElement>> enquirySearch(String search) {
        navigateEnquirySearchPage();
        fillSearchQuery(search);
        clickSubmitButton();
        return getTableData();
    }
}