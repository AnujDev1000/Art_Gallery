package TestCaseClasses;

import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userSearch;
import ObjectClasses.userViewDetails;

public class userViewDetatilsTest extends SetupDriver {

    @Test(priority = 37, groups = {"user", "regression"})
    public void search()
    {
        userViewDetails uDetails = new userViewDetails(driver);
        uDetails.viewDetails();
    }
}
