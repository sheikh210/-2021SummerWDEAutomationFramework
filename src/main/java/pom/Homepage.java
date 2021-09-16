package pom;

import baseAPI.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#global-nav > ul li.sports.menu-nfl > a")
    public WebElement navBarNFLDropdown;

    @FindBy (css = "#global-nav > ul li[class='sports menu-nfl hover'] > div > ul:nth-child(1) > li:nth-child(1) a")
    public WebElement nflHomeButton;

    @FindBy (css = "#global-nav > ul li[class='sports menu-nba'] > a")
    public WebElement navBarNBADropdown;

    @FindBy (css = "#global-nav > ul li[class='sports menu-nba hover'] > div > ul:nth-child(1) > li:nth-child(1) a")
    public WebElement nbaHomeButton;

    @FindBy (css = "#global-nav > ul li[class='sports menu-mlb'] > a")
    public WebElement navBarMLBDropdown;

    @FindBy (css = "#global-nav > ul li[class='sports menu-mlb hover'] > div > ul:nth-child(1) > li:nth-child(1) a")
    public WebElement mlbHomeButton;

    @FindBy (css = "#global-nav > ul li[class='sports menu-nhl'] > a")
    public WebElement navBarNHLDropdown;

    @FindBy (css = "#global-nav > ul li[class='sports menu-nhl hover'] > div > ul:nth-child(1) > li:nth-child(1) a")
    public WebElement nhlHomeButton;

    public String locatorNFLDropdownMenuItems = "//li[@class=\"sports menu-nfl hover\"]/div/ul[1]/li[not(@style)]/a/span/span[1]";

    public MLBHomepage navigateToMLBHomepage() {
        clickOnElement(navBarMLBDropdown);
        clickOnElement(mlbHomeButton);

        return new MLBHomepage();
    }

    public NBAHomepage navigateToNBAHomepage() {
        clickOnElement(navBarNBADropdown);
        clickOnElement(nbaHomeButton);

        return new NBAHomepage();
    }

    public NFLHomepage navigateToNFLHomepage() {
        clickOnElement(navBarNFLDropdown);
        clickOnElement(nflHomeButton);

        return new NFLHomepage();
    }

    public NHLHomepage navigateToNHLHomepage() {
        clickOnElement(navBarNHLDropdown);
        clickOnElement(nhlHomeButton);

        return new NHLHomepage();
    }


}
