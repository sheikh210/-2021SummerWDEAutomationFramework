package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import testBase.TestBase;

public class TestHomepage extends TestBase {

    @Test (description = "TEST ID: 403947", enabled = true, priority = 0, groups = {"Regression", "Smoke", "Sanity"})
    public void testDoSearch() {
        Homepage homepage = getHomepage();

        String searchTerm = "Playstation 5";

        homepage.doSearch(searchTerm);

        String currentURL = webDriver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com/s?k=Playstation+5&ref=nb_sb_noss_2";

        Assert.assertEquals(currentURL, expectedURL, "URL DOES NOT MATCH");
    }

    @Test (groups = {"Smoke", "Sanity"}, priority = 1)
    public void testNavigateToLoginPage() {
        Homepage homepage = getHomepage();

        homepage.navigateToSignInPage();
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Amazon Sign-In";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

//    @Test (priority = 1)
//    public void testDoSomething() {
//
//    }
//
//    @Test (priority = 2)
//    public void testDoSomethingElse() {
//
//    }
}
