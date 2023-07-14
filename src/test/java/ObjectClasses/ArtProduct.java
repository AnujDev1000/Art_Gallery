package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtProduct {
    WebDriver driver;

    public ArtProduct(WebDriver driver) {
        this.driver = driver;
	}

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
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
        
        return data;

    }

    
    public void printTable() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table"));
        
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<List<String>> table = new ArrayList<>();
        
        for(WebElement row:rows){
            scrollToWebElement(row);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if(cols.size()<1){
                cols = row.findElements(By.tagName("th"));
            }
            
            List<String> data = new ArrayList<>();
            for(int col=0;col<cols.size()-1;col++){
                data.add(cols.get(col).getText());
            }

            table.add(data);
        }
        
        int numCols = table.get(0).size();
        
        // Calculate the maximum width of each column
        int[] colWidths = new int[numCols];
        for (List<String> row : table) {
            for (int i = 0; i < numCols; i++) {
                int width = row.get(i).length();
                if (width > colWidths[i]) {
                    colWidths[i] = width;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < colWidths.length; i++) {
            sum += colWidths[i];
        }
        

        // Print the table
        for (int i=0;i<table.size();i++) {
            for (int j = 0; j < numCols; j++) {
                String cell = table.get(i).get(j);
                int padding = colWidths[j] - cell.length();
                System.out.print(cell + " ".repeat(padding + 2));
            }
            if(i==0){
                System.out.println();
                for(int k=0;k<sum;k++){
                    System.out.print("-");;
                }
                System.out.println();
            }
            else{
                System.out.println();
            }
        }
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





    // Update Artist
    public void clickEditButton() {
        int dataSize = getTableData().size();
        scrollBy();
        String path = "//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a[1]";
        driver.findElement(By.xpath(path)).click();
    }

    public void editTitle( String title) {
        driver.findElement(By.xpath("//*[@id='title']")).clear();
        fillTitle(title);
    }

    public void editDimensions( String dimension) {
        driver.findElement(By.cssSelector("#dimension")).clear();
        fillDimensions(dimension);
    }
    
    public void editSellingPrice( String sPrice) {
        WebElement elm = driver.findElement(By.xpath("//*[@id='sprice']"));
        elm.clear();
        fillSellingPrice(sPrice);
        scrollToWebElement(elm);
    }
    
    public void editDiscription( String discription) {
        driver.findElement(By.xpath("//*[@id='description']")).clear();
        fillDiscription(discription);
    }
    
    public void navigateToEditImage(String path) {
        driver.findElement(By.xpath(path)).click();
    }
    
    public void editImage(String image) {
        driver.findElement(By.xpath("//*[@id='images']")).sendKeys(image);
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/div/form/p/button")).click();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.navigate().back();
        driver.navigate().back();
    }
    
    public void clickUpdateButton() {
        WebDriverWait wait = new WebDriverWait(driver,  10);
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > section > div:nth-child(2) > form > p > button")));

        elm.click();
    }


    public void updateArtProduct(String title, String imgPath, String dimension, String orientation, String size, String artist, String artType, String artMedium, String sPrice, String discription) {
        navigateToManagetoArtProductPage();
        List<List<WebElement>> data = getTableData();
        
        if(data.size() > 0){
            clickEditButton();
            editTitle(title);

            // image01
            navigateToEditImage("//*[@id='main-content']/section/div[2]/form/div[1]/section/div/div[2]/div/a");
            editImage(imgPath);

            // image02
            navigateToEditImage("//*[@id='main-content']/section/div[2]/form/div[1]/section/div/div[3]/div/a");
            editImage(imgPath);
            
            fillOrientation(orientation);
            fillSize(size);
            fillArtist(artist);
            fillArtType(artType);
            fillArtMedium(artMedium);

            editSellingPrice(sPrice);
            
            // image03
            navigateToEditImage("//*[@id='main-content']/section/div[2]/form/div[1]/section/div/div[4]/div/a");
            editImage(imgPath);
            
            editDiscription(discription);
            scrollBy();
            
            // image04
            navigateToEditImage("//*[@id='main-content']/section/div[2]/form/div[1]/section/div/div[5]/div/a");
            editImage(imgPath);
            
            // image05
            navigateToEditImage("//*[@id='main-content']/section/div[2]/form/div[1]/section/div/div[6]/div/a");
            editImage(imgPath);

            editDimensions(dimension);
            clickUpdateButton();
        }
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
