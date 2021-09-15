package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

    public ContactUsPage() {
        PageFactory.initElements(webDriver, this);
    }
}
