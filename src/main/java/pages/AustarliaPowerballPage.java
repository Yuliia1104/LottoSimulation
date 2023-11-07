package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static libs.TestData.*;

public class AustarliaPowerballPage extends ParentPage {

    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing the Australian Powerball')]")
    private WebElement mainTitleAustrPowerball;
    @FindBy(xpath = ".//*[@class='rules']//a[@class='smooth-scroll']")
    private WebElement gameRulesLink;
    @FindBy(xpath = ".//*[@id='rules']//h2[text()='Australia Powerball details & rules']")
    private WebElement gameRulesTitle;
    @FindBy(xpath = ".//*[@id='rules']//p[3]")
    private WebElement gameRulesContent;
    @FindBy(xpath = " .//*[@id='rules']//p[contains(., 'A$8M.')]")
    private WebElement jpAmount;

    public AustarliaPowerballPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/powerball";
    }

    public AustarliaPowerballPage checkIsRedirectedToAustralianPowerballLotto(String title) {
        checkURL();
        isElementDisplayed(mainTitleAustrPowerball);
        forTextComparing(title, mainTitleAustrPowerball);
        logger.info("----------");
        return this;
    }

    public AustarliaPowerballPage checkGameRulesLinkPresence(String title) {
        isElementDisplayed(gameRulesLink);
        forTextComparing(title, gameRulesLink);
        return this;
    }

    public AustarliaPowerballPage checkGameRulesContent(String content) {
        clickOnElement(gameRulesLink);
        scrollToElemnt(gameRulesTitle);
        waitABit(1);
        forTextComparing(content,gameRulesContent);
        return this;
    }

    public AustarliaPowerballPage checkJPAmount(String jpValue){
        forTextComparing(jpValue, jpAmount);
        return this;
    }

}