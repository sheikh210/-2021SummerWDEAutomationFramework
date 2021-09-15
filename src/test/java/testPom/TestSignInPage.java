package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.SignInPage;
import testBase.TestBase;

public class TestSignInPage extends TestBase {

    @Test
    public void testNavigationToSignInPage() {
        Homepage homepage = getHomepage();
        homepage.navigateToSignInPage();

        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Amazon Sign-In";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testInvalidSignIn() {
        Homepage homepage = getHomepage();

        homepage.navigateToSignInPage().signIn("ss@gmail.com", "1234!@#$");

        boolean flag = false;

        if (new SignInPage().authWarningBox.isDisplayed()) {
            flag = true;
        }

        Assert.assertTrue(flag);
    }
}
