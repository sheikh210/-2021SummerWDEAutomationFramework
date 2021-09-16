package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class NHLHomepage extends BasePage {

    public NHLHomepage() {
        PageFactory.initElements(driver, this);
    }
}
