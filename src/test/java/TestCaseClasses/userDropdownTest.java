package TestCaseClasses;

import ObjectClasses.SetupDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import ObjectClasses.userDropdown;

public class userDropdownTest extends SetupDriver {

    @Test(priority = 34, groups = {"user", "regression"})
    public void dropdown()
    {
        userDropdown uDropdown = new userDropdown(driver);
        int expecteddropdownsize = uDropdown.dropdownsize();
        int actualdropdownsize =  uDropdown.dropdown();
        Assert.assertEquals(expecteddropdownsize , actualdropdownsize);
    }
}
