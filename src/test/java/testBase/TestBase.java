package testBase;

import baseAPI.BasePage;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pom.*;

public class TestBase extends BasePage {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public MLBHomepage getMLBHomepage() {
        return new MLBHomepage();
    }

    public NBAHomepage getNBAHomepage() {
        return new NBAHomepage();
    }

    public NFLHomepage getNFLHomepage() {
        return new NFLHomepage();
    }

    public NHLHomepage getNHLHomepage() {
        return new NHLHomepage();
    }


    /*
    region ASSERTION HELPER METHODS
     */
    public boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed()) {
                flag = true;
            }
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
