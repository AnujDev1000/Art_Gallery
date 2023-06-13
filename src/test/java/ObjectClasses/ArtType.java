package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtType {
    WebDriver driver;

    public ArtType(WebDriver driver){
        this.driver = driver;
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void navigateToArtTypeDetails() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div[1]/div/div[2]/a")).click();
    }

    public List<List<WebElement>> getTableData() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<WebElement>> data = new ArrayList<>();

        for(WebElement row:rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            List<WebElement> rowData = new ArrayList<>();
    
            for (WebElement col : cols) {
                rowData.add(col);
            }

            data.add(rowData);
        }

        System.out.println("\nArt Type Details :");
        for (List<WebElement> list : data) {
            List<String> cols = new ArrayList<>(); 
            for (WebElement col : list) {
                cols.add(col.getText());
            }

            System.out.println(cols);
        }
        
        return data;

    }

    public List<List<WebElement>> dashboardDetails() {
        navigateToArtTypeDetails();
        return getTableData();
    }







    // Add Arttype
    public void navigateToAddtoArtTypePage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/ul/li[1]/a")).click();
    }

    public void fillArtType(String artType) {
        driver.findElement(By.xpath("//*[@id='arttype']")).sendKeys(artType);
    }

    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > div:nth-child(2) > p > button")).click();
    }

    public void addArtType(String artType) {
        navigateToAddtoArtTypePage();
        fillArtType(artType);
        clickSubmitButton();
    }







    // Manage arttype
    public void navigateToManagetoArtTypePage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/ul/li[2]/a")).click();
    }




    // Update ArtType
    public void clickEditButton() {
        int dataSize = getTableData().size();
        scrollBy();
        String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a[1]";
        driver.findElement(By.xpath(path)).click();
    }

    public void editArtType(String artType) {
        driver.findElement(By.xpath("//*[@id='arttype']")).clear();
        fillArtType(artType);
    }

    public void clickUpdateButton() {
        System.out.println(driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).isEnabled());

        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).click();
    }

    public void updateArtType(String artType) {
        navigateToManagetoArtTypePage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            clickEditButton();
            editArtType(artType);
            clickUpdateButton();
        }
    }




    // Delete ArtType
    public void clickDeleteButton() {
        int dataSize = getTableData().size();
        scrollBy();
        if(dataSize > 0){
            String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[4]/a[2]";
            driver.findElement(By.xpath(path)).click();
        }
    }

    public void deleteArtType() {
        navigateToManagetoArtTypePage();
        clickDeleteButton();
    }
}
