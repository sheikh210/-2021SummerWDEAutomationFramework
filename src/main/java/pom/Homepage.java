package pom;

import baseAPI.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    public Homepage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (id = "nav-hamburger-menu")
    public WebElement allHamburgerMenuButton;

    @FindBy (id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy (id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy (id = "nav-link-accountList")
    public WebElement signInButton;

    void sendKeysToSearchBar(String value) {
        sendKeysToElement(searchBar, value);
    }

    void clickSearchButton() {
        clickOnElement(searchButton);
    }

    public void doSearch(String value) {
        sendKeysToSearchBar(value);
        clickSearchButton();
    }

    public SignInPage navigateToSignInPage() {
        clickOnElement(signInButton);

        return new SignInPage();
    }

}
