package ObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enquiry {
    WebDriver driver;

    public Enquiry(WebDriver driver){
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
        int numCols = table.get(1).size();
        
        // Calculate the maximum width of each column
        int[] colWidths = new int[numCols];
        for (List<String> row : table) {
            if(row.size()>0){
                for (int i = 0; i < numCols; i++) {
                    int width = row.get(i).length();
                    if (width > colWidths[i]) {
                        colWidths[i] = width;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < colWidths.length; i++) {
            sum += colWidths[i];
        }
        

        // Print the table
        for (int i=1;i<table.size();i++) {
            for (int j = 0; j < numCols; j++) {
                String cell = table.get(i).get(j);
                int padding = colWidths[j] - cell.length();
                System.out.print(cell + " ".repeat(padding + 2));
            }
            if(i==1){
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



    // Dashboard Details
    public void navigateToAnsweredEnquiryDetails() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[3]/div/div[2]/a")).click();
    }

    public List<List<WebElement>> AnsweredEnquiryDetails() {
        navigateToAnsweredEnquiryDetails();
        return getTableData();
    }

    public void navigateToUnansweredEnquiryDetails() {
        driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[2]/div/div[2]/a")).click();
    }

    public List<List<WebElement>> UnansweredEnquiryDetails() {
        navigateToUnansweredEnquiryDetails();
        return getTableData();
    }


    





    public void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void closeNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    


    public void navigateToEnquiryPageinUser() {
        driver.get("https://artgallery.neohire.io/");
        driver.findElement(By.xpath("//*[@id='navbarDropdown1']")).click();
        WebDriverWait wait = new WebDriverWait(driver,  10);
		WebElement nav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/div/a[4]")));
        nav.click();
        
        WebElement enquiryBtn = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/h4/button"));
        scrollToWebElement(enquiryBtn);
        enquiryBtn.click();
    }
    
    public void fillName(String name) {
        driver.findElement(By.xpath("/html/body/section/div/div/form/div/div[1]/input")).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(By.xpath("/html/body/section/div/div/form/div/div[2]/input")).sendKeys(email);
    }

    public void fillNumber(String number) {
        driver.findElement(By.xpath("/html/body/section/div/div/form/div/div[3]/input")).sendKeys(number);
    }

    public void fillMessage(String msg) {
        driver.findElement(By.xpath("/html/body/section/div/div/form/div/div[4]/textarea")).sendKeys(msg);
    }
    
    public void clickSend() {
        driver.findElement(By.xpath("/html/body/section/div/div/form/div/button")).click();
    }

    public void addEnquiry(String name, String email, String number, String msg) {
        navigateToEnquiryPageinUser();
        scrollBy();
        fillName(name);
        fillEmail(email);
        fillNumber(number);
        fillMessage(msg);
        clickSend();
    }






    public void navigateToManageUnansweredEnquiryPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/a")).click();
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/ul/li[1]/a")).click();
    }

    public void clickViewDetailsButton() {
        int dataSize = getTableData().size();
        String path = "//*[@id=\"main-content\"]/section/div[2]/div/section/table/tbody/tr[" + dataSize + "]/td[6]/a";
        driver.findElement(By.xpath(path)).click();
    }

    public void fillRemarks(String remark) {
        driver.findElement(By.name("remark")).sendKeys(remark);
    }

    public void clickUpdateButton() {
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div/section/table/tbody/tr[7]/td/button")).click();
    }
    
    public String getRemarkDate() {
        return driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[7]/td")).getText();
    }

    public void printEnquiryDetails() {
        WebElement tableBody = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        for(WebElement row:rows){
            List<WebElement> th = row.findElements(By.tagName("th"));
            List<WebElement> td = row.findElements(By.tagName("td"));

            for(int i=0;i<th.size();i++){
                System.out.println(th.get(i).getText() + " : " + td.get(i).getText());
            }
        }
    }

    public void unansweredEnquiry() {
        navigateToManageUnansweredEnquiryPage();
        scrollBy();
        clickViewDetailsButton();
        System.out.println("\nUnanswered Enquiry Details \n");
        printEnquiryDetails();
        fillRemarks("Successfully Answered!");
        clickUpdateButton();
    }


    public String getEnquiryNumber() {
        return driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[1]/td")).getText();
    }

    public void navigateToManageAnsweredEnquiryPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[6]/ul/li[2]/a")).click();
    }

    public void answeredEnquiry() {
        navigateToManageAnsweredEnquiryPage();
        scrollBy();
        clickViewDetailsButton();
    }






    // Search Enquiry
    public String fetchSearchData() {
        navigateToManageAnsweredEnquiryPage();
        int dataSize = getTableData().size();
        scrollBy();
        String searchData = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div/section/table/tbody/tr[" + dataSize + " ]")).getText();
        return searchData;
    }

    public void navigateEnquirySearchPage() {
        driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[7]/a")).click();
    }
    
    public void fillSearchQuery(String search) {
        driver.findElement(By.xpath("//*[@id='searchdata']")).sendKeys(search);
    }

    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("#main-content > section > div:nth-child(2) > div > section > header > form > p > button")).click();
    }

    public List<List<WebElement>> enquirySearch(String search) {
        navigateEnquirySearchPage();
        fillSearchQuery(search);
        clickSubmitButton();
        return getTableData();
    }
}