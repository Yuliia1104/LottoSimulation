package pages;

import libs.TestData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartingPage extends ParentPage {
    @FindBy(xpath = ".//h1[contains(text(),'Free Lottery Simulation')]")
    private WebElement mainTitle;
    public StartingPage(WebDriver webDriver) {
        super(webDriver);
    }
    Logger logger = Logger.getLogger(getClass());
    public StartingPage openStartingPage() {
        try {
            webDriver.get(baseURL);
            logger.info("Website Lotto Simulation is open");
            logger.info(baseURL);
        } catch (Exception e) {
            logger.error("Fails open website");
            Assert.fail("Cannot open website"+e);
        }
        return this;
    }

    public StartingPage checkUrl(){
        Assert.assertEquals("URL does not match", baseURL, webDriver.getCurrentUrl());
        logger.info("URL is equal " + baseURL);
        return this;
    }

public StartingPage checkMailTitle(){
        Assert.assertTrue(mainTitle+" is not displayed", isElementDisplayed(mainTitle));
        forTextComparing(TestData.MAIN_TITLE, mainTitle);
        return this;
}
}
