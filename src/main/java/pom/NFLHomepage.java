package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class NFLHomepage extends BasePage {

    public NFLHomepage() {
        PageFactory.initElements(driver, this);
    }
}
