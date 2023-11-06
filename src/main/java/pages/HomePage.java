package pages;

import libs.TestData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    Logger logger = Logger.getLogger(getClass());
    @FindBy(xpath = ".//h1[contains(text(),'Free Lottery Simulation')]")
    private WebElement mainTitle;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        try {
            webDriver.get(base_url + getRelativeUrl());
            logger.info("Website Lotto Simulation is open");
        } catch (Exception e) {
            logger.error("Fails open website");
            Assert.fail("Cannot open website" + e);
        }
        return this;
    }

    public HomePage checkUrl() {
        checkURL();
        logger.info("URL is equal " + base_url+getRelativeUrl());
        return this;
    }

    public HomePage checkMailTitle() {
        Assert.assertTrue(mainTitle + " is not displayed", isElementDisplayed(mainTitle));
        forTextComparing(TestData.MAIN_TITLE, mainTitle);
        return this;
    }
}
