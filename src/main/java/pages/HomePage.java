package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//h1[contains(text(),'Free Lottery Simulation')]")
    private WebElement mainTitle;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
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

    @Step
    public HomePage checkUrl() {
        checkURL();
        return this;
    }

    @Step
    public HomePage checkMailTitle(String text) {
        Assert.assertTrue(mainTitle + " is not displayed", isElementDisplayed(mainTitle));
        forTextComparing(text, mainTitle);
        return this;
    }
}
