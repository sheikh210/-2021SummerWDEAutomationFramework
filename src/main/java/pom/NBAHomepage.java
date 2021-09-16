package pom;

import baseAPI.BasePage;
import org.openqa.selenium.support.PageFactory;

public class NBAHomepage extends BasePage {

    public NBAHomepage() {
        PageFactory.initElements(driver, this);
    }
}
