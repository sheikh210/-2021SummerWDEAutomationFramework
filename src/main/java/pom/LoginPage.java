package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }
}
