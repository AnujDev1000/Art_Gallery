package TestCaseClasses;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import ObjectClasses.SetupDriver;
import ObjectClasses.userEnquiry;

public class userEnquiryTest extends SetupDriver {
    @Test(priority = 35, groups = {"user"})
    public void dropdown()
    {
        userEnquiry uEnquiry = new userEnquiry(driver);

        int expectedenquirybuttons= uEnquiry.enquirybuttoncount();
        int actualenquirybuttons = uEnquiry.enquirybutton();

        assertEquals(expectedenquirybuttons, actualenquirybuttons);
    }
}
