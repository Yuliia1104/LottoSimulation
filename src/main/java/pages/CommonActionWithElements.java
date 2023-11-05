package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait15, webDriverWait30;

    public CommonActionWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait30 = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            String message;
            if (state) {
                message = getElementName(element) + " element is displayed";
            } else {
                message = getElementName(element) + " element is not displayed";
            }
            logger.info(message);
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    protected void forTextComparing(String expectedText, WebElement webElement) {
        Assert.assertEquals("Text does not mach", expectedText, webElement.getText());
        logger.info(expectedText + " found its match!");
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }
}
