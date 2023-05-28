package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtMedium {
    WebDriver driver;

    public ArtMedium(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToArtMediumDetails() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div[2]/div/div[2]/a")).click();
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
        navigateToArtMediumDetails();
        return getTableData();
    }





    
    // Adding ArtMedium
    public void navigateToAddtoArtMediumPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/ul/li[1]/a")).click();
    }

    public void fillArtMedium(String artMedium) {
        driver.findElement(By.xpath("//*[@id='artmed']")).sendKeys(artMedium);
    }

    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > div > form > div:nth-child(2) > p > button")).click();
    }

    public void addArtMedium(String artMedium) {
        navigateToAddtoArtMediumPage();
        fillArtMedium(artMedium);
        clickSubmitButton();
    }





    
    // Manage artMedium
    public void navigateToManagetoArtMediumPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[4]/ul/li[2]/a")).click();
    }




    // Update ArtMedium
    public void navigateToUpdateArtMediumPage(List<List<WebElement>> data) {
        data.get(0).get(3).findElement(By.linkText("Edit")).click();
    }

    public void editArtMedium(String artMedium) {
        driver.findElement(By.xpath("//*[@id='artmed']")).clear();
        fillArtMedium(artMedium);
    }

    public void clickUpdateButton() {
        System.out.println(driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).isEnabled());

        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).click();
    }

    public void updateArtMedium(String artMedium) {
        navigateToManagetoArtMediumPage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            navigateToUpdateArtMediumPage(data);
            editArtMedium(artMedium);
            clickUpdateButton();
        }
    }





    
    // Delete ArtMedium
    public void deleteArtMedium() {
        navigateToManagetoArtMediumPage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            data.get(0).get(3).findElement(By.linkText("Delete")).click();
        }
    }
}
