package TestCaseClasses;


import org.testng.annotations.Test;
import org.testng.Assert;

import ObjectClasses.SetupDriver;
import ObjectClasses.userLinks;
import ObjectClasses.userNavbar;

public class userLinksTest extends SetupDriver{
    @Test(priority = 36, groups = {"user"})
    public void linkcheck()
    {
        userLinks uLinks = new userLinks(driver);

        String artgallerytitle = uLinks.linkArtgallery();
        Assert.assertEquals("Art Gallery Management System | Home Page",artgallerytitle);        
        uLinks.homepage();

        String readmoretitle = uLinks.linkreadmore();
        Assert.assertEquals("Art Gallery Management System | About Us Page",readmoretitle);
        uLinks.homepage();

        String arrowtitle = uLinks.linkarrow();
        Assert.assertEquals("Art Gallery Management System | Home Page",arrowtitle);
        uLinks.homepage();
    }
}
