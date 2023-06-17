package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ArtProduct {
    WebDriver driver;

    public ArtProduct(WebDriver driver) {
        this.driver = driver;
	}

    public void navigateToArtProductDetails() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[3]/div[3]/div/div[2]/a")).click();
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

        System.out.println("\nArt Product Details :");
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
        navigateToArtProductDetails();
        return getTableData();
    }





    
    // Add Arttype
    public void navigateToAddtoArtProductPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/ul/li[1]/a")).click();
    }

    public void fillTitle( String title) {
        driver.findElement(By.xpath("//*[@id='title']")).sendKeys(title);
    }

    public void fillFeaturedImage( String imgPath) {
        driver.findElement(By.xpath("//*[@id='images']")).sendKeys(imgPath);
    }
    
    public void fillImage01( String imgPath) {
        driver.findElement(By.xpath("//*[@id='image1']")).sendKeys(imgPath);
    }
    
    public void fillImage02( String imgPath) {
        driver.findElement(By.xpath("//*[@id='image2']")).sendKeys(imgPath);
    }
    
    public void fillImage03( String imgPath) {
        driver.findElement(By.xpath("//*[@id='image3']")).sendKeys(imgPath);
    }
    
    public void fillImage04( String imgPath) {
        driver.findElement(By.xpath("//*[@id='image4']")).sendKeys(imgPath);
    }
    
    public void fillDimensions( String dimension) {
        driver.findElement(By.cssSelector("#dimension")).sendKeys(dimension);
    }
    
    public void fillOrientation( String orientation) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='orientation']"));

        Select select = new Select(elm);
        select.selectByVisibleText(orientation);
    }
    
    public void fillSize( String size) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='size']"));

        Select select = new Select(elm);
        select.selectByVisibleText(size);
    }
    
    public void fillArtist( String artist) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='artist']"));

        Select select = new Select(elm);
        select.selectByVisibleText(artist);
    }
    
    public void fillArtType( String artType) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='arttype']"));

        Select select = new Select(elm);
        select.selectByVisibleText(artType);
    }
    
    public void fillArtMedium( String artMedium) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='artmed']"));

        Select select = new Select(elm);
        select.selectByVisibleText(artMedium);
    }
    
    public void fillSellingPrice( String sPrice) {
        driver.findElement(By.xpath("//*[@id='sprice']")).sendKeys(sPrice);
    }
    
    public void fillDiscription( String discription) {
        driver.findElement(By.xpath("//*[@id='description']")).sendKeys(discription);
    }

    public void clickSubmitButton() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/form/p/button")).click();
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void addArtProduct( String title, String imgPath, String dimension, String orientation, String size, String artist, String artType, String artMedium, String sPrice, String discription) {
        navigateToAddtoArtProductPage();
        fillTitle(title);
        fillFeaturedImage(imgPath);
        fillImage01(imgPath);
        fillImage02(imgPath);
        fillImage03(imgPath);
        fillImage04(imgPath);
        fillOrientation(orientation);
        fillSize(size);
        fillArtist(artist);
        fillArtType(artType);
        fillArtMedium(artMedium);
        fillSellingPrice(sPrice);
        scrollBy();
        fillDimensions(dimension);
        fillDiscription(discription);
        clickSubmitButton();
    }





    // Manage ArtProduct
    public void navigateToManagetoArtProductPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[5]/ul/li[2]/a")).click();
    }



        
    // Delete ArtProduct
    public void clickDeleteButton() {
        int dataSize = getTableData().size();
        scrollBy();
        if(dataSize > 0){
            String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a[2]";
            driver.findElement(By.xpath(path)).click();
        }
    }

    public void deleteArtProduct() {
        navigateToManagetoArtProductPage();
        clickDeleteButton();
    }
}
