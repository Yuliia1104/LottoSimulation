package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.TestData.*;

public class AustarliaPowerballPage extends ParentPage{

    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing the Australian Powerball')]")
    private WebElement mainTitleAustrPowerball;
    public AustarliaPowerballPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/powerball";
    }
    public AustarliaPowerballPage checkIsRedirectedToAustralianPowerballLotto(){
        checkURL();
        isElementDisplayed(mainTitleAustrPowerball);
        forTextComparing(AUSTRALIA_POWERBALL_TITLE, mainTitleAustrPowerball);
        logger.info("----------");
        return this;
    }

}