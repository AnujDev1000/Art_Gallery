package TestCaseClasses;

import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userSearch;
import ObjectClasses.userViewDetails;

public class userViewDetatilsTest extends SetupDriver {

    @Test(priority = 0)
    public void search()
    {
        userViewDetails uDetails = new userViewDetails(driver);
        uDetails.viewDetails();
    }
}
