package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    public AccountPage() {
        PageFactory.initElements(webDriver, this);
    }
}
