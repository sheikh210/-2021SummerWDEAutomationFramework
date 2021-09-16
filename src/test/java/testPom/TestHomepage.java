package testPom;

import baseAPI.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.Homepage;
import pom.MLBHomepage;
import testBase.TestBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHomepage extends TestBase {

    @Test (enabled = false)
    public void testNavigateToMLBHomepage() {
        Homepage homepage = getHomepage();

        MLBHomepage mlbHomepage = homepage.navigateToMLBHomepage();
        waitForElementToContainText(mlbHomepage.mlbLogoText, "MLB");

        String actualTitle = driver.getTitle();
        String expTitle = "MLB - Major League Baseball Teams, Scores, Stats, News, Standings, Rumors - ESPN";

        Assert.assertEquals(actualTitle, expTitle);
    }

    @Test
    public void testNFLDropdownMenuListItems() throws IOException {
        Homepage homepage = getHomepage();
        dataReader = new DataReader();

        clickOnElement(homepage.navBarNFLDropdown);

        List<WebElement> webElementsList = getListOfElements(By.xpath(homepage.locatorNFLDropdownMenuItems));
        List<String> actualTextWebElementList = new ArrayList<>();

        for (WebElement element : webElementsList) {
            actualTextWebElementList.add(element.getText());
        }

        String relPath = "/src/test/resources/testData/HomepageTestData.xlsx";
        String sheetName = "testNFLDropdownMenuItems";

        String[] expectedText = dataReader.fileReaderStringXSSF(ABSOLUTE_PATH + relPath, sheetName);
        SoftAssert softAssert = new SoftAssert();

        int length = actualTextWebElementList.size();

        for (int i = 0; i < length; i++) {
            System.out.println("EXPECTED: " + expectedText[i] + "\nACTUAL: " + actualTextWebElementList.get(i));
            softAssert.assertEquals(actualTextWebElementList.get(i), expectedText[i]);
        }
        softAssert.assertAll();
    }


}
