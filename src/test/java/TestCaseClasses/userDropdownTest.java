package TestCaseClasses;

import static org.junit.Assert.assertEquals;
import ObjectClasses.SetupDriver;
import org.testng.annotations.Test;
import ObjectClasses.userDropdown;

public class userDropdownTest extends SetupDriver {

    @Test(priority = 33, groups = {"user", "regression"})
    public void dropdown()
    {
        userDropdown uDropdown = new userDropdown(driver);
        int expecteddropdownsize = uDropdown.dropdownsize();
        int actualdropdownsize =  uDropdown.dropdown();
        assertEquals(expecteddropdownsize , actualdropdownsize);
    }
}
