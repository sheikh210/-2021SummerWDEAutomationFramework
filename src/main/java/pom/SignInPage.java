package pom;

import baseAPI.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

    public SignInPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (id = "ap_email")
    public WebElement emailAddressInputField;

    @FindBy (css = "input#continue")
    public WebElement continueButton;

    @FindBy (id = "ap_password")
    public WebElement passwordInputField;

    @FindBy (id = "signInSubmit")
    public WebElement signInButton;

    @FindBy (id = "auth-warning-message-box")
    public WebElement authWarningBox;

    void enterEmailAddress(String emailAddress) {
        sendKeysToElement(emailAddressInputField, emailAddress);
    }

    void clickContinueButton() {
        clickOnElement(continueButton);
    }

    void enterPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    void clickSignInButton() {
        clickOnElement(signInButton);
    }

    public void signIn(String email, String password) {
        enterEmailAddress(email);
        clickContinueButton();

        webDriverWait.until(ExpectedConditions.visibilityOf(passwordInputField));

        enterPassword(password);
        clickSignInButton();
    }



}
