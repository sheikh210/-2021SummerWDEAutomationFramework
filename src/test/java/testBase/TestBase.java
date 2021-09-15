package testBase;

import baseAPI.BasePage;
import pom.AccountPage;
import pom.ContactUsPage;
import pom.Homepage;
import pom.LoginPage;

public class TestBase extends BasePage {

    public Homepage getHomepage() {
        return new Homepage();
    }



    public LoginPage loginPage;
    public AccountPage accountPage;
    public ContactUsPage contactUsPage;

}
