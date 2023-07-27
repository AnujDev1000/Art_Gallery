package TestCaseClasses;


import org.testng.annotations.Test;
import org.testng.Assert;

import ObjectClasses.SetupDriver;
import ObjectClasses.userEnquiry;

public class userEnquiryTest extends SetupDriver {
    @Test(priority = 35, groups = {"user"})
    public void dropdown()
    {
        test.assignCategory("User");
        userEnquiry uEnquiry = new userEnquiry(driver);

        int expectedenquirybuttons= uEnquiry.enquirybuttoncount();
        int actualenquirybuttons = uEnquiry.enquirybutton();

        Assert.assertEquals(expectedenquirybuttons, actualenquirybuttons);
    }
}
