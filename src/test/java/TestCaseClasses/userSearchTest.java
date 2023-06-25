package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;
import ObjectClasses.SetupDriver;
import ObjectClasses.userSearch;

public class userSearchTest extends SetupDriver {

    @Test(priority = 0)
    public void search()
    {
        userSearch uSearch = new userSearch(driver);
        uSearch.search("A");
    }
    
}
