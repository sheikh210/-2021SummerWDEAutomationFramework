package pom;

import baseAPI.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MLBHomepage extends BasePage {

    public MLBHomepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "li.sports.sub > span > a > span.link-text")
    public WebElement mlbLogoText;
}
