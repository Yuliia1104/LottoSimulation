package pages;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

import static libs.TestData.JP_NUMERIC_VALEUE;

public class AustarliaPowerballPage extends ParentPage {

    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing the Australian Powerball')]")
    private WebElement mainTitleAustrPowerball;
    @FindBy(xpath = ".//*[@class='rules']//a[@class='smooth-scroll']")
    private WebElement gameRulesLink;
    @FindBy(xpath = ".//*[@id='rules']//h2[text()='Australia Powerball details & rules']")
    private WebElement gameRulesTitle;
    @FindBy(xpath = ".//*[@id='rules']//p[3]")
    private WebElement gameRulesContent;
    @FindBy(xpath = " .//*[@id='rules']//p[contains(., 'A$20M.')]")
    private WebElement jpAmount;
    @FindBy(xpath = ".//*[@class='add-buttons']//button")
    private List<WebElement> monetaryButtons;
    @FindBy(xpath = ".//*[@class='table status']//tr//th[text()='Balance']/following-sibling::td[1]")
    private WebElement balanceMeter;
    @FindBy(xpath = ".//*[@class = 'step']//span[@class ='step-number' and contains(text(), '4')]")
    private WebElement monetorySection;
    @FindBy(xpath = ".//*[@class='add-buttons']//button[text()='$100']")
    private WebElement oneHundrDollars;
    @FindBy(xpath = ".//*[@class='add-buttons']//button[text()='$1k']")
    private WebElement oneThousandDollars;
    @FindBy(xpath = ".//*[@class='add-buttons']//button[text()='$10k']")
    private WebElement tenThousandsDollars;
    @FindBy(xpath = ".//*[@class='add-buttons']//button[text()='$100k']")
    private WebElement oneHundrThousDollars;

    private String jpAmountLocator = ".//*[@id='rules']//p[contains(., 'A$%sM.')]";

    public AustarliaPowerballPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/powerball";
    }

    @Step
    public AustarliaPowerballPage checkPowerbalLottoURL() {
        checkURL();
        return this;
    }

    @Step
    public AustarliaPowerballPage checkPowerbalLottoTitleDisplayed() {
        isElementDisplayed(mainTitleAustrPowerball);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkPowerbalLottoTitleContent(String title) {
        forTextComparing(title, mainTitleAustrPowerball);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkIsRedirectedToAustralianPowerballLotto(String title) {
        checkPowerbalLottoURL();
        checkPowerbalLottoTitleDisplayed();
        checkPowerbalLottoTitleContent(title);
        logger.info("----------");
        return this;
    }

    @Step
    public AustarliaPowerballPage isGameRulesAndDetailsLinkDisplayed() {
        isElementDisplayed(gameRulesLink);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkGameRulesLinkContent(String link) {
        forTextComparing(link, gameRulesLink);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkGameRulesLinkPresence(String link) {
        isGameRulesAndDetailsLinkDisplayed();
        checkGameRulesLinkContent(link);
        return this;
    }

    @Step
    public AustarliaPowerballPage clickGameRulesLink() {
        clickOnElement(gameRulesLink);
        return this;
    }

    @Step
    public AustarliaPowerballPage scrollDownToGameRulesAndDetails() {
        scrollToElemnt(gameRulesTitle);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkGameRulesContent(String content) {
        forTextComparing(content, gameRulesContent);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkJPAmount(String jpValue) {
        forTextComparing(jpValue, (String.format(jpAmountLocator, JP_NUMERIC_VALEUE)));
        return this;
    }

    @Step
    public AustarliaPowerballPage checkGameRulesAndJPContent(String content, String jpValue) {
        clickGameRulesLink();
        scrollDownToGameRulesAndDetails();
        waitABit(1);
        checkGameRulesContent(content);
        checkJPAmount(jpValue);
        return this;
    }

    @Step
    public AustarliaPowerballPage scrollDownToMonitoryOption() {
        scrollToElemnt(balanceMeter);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkMonetaryOptions(ArrayList<String> expectedData) {
        ArrayList<String> actualOptionValues = new ArrayList<>();
        for (int i = 0; i < monetaryButtons.size(); i++) {
            actualOptionValues.add(monetaryButtons.get(i).getText());
        }

        SoftAssertions softAssertion = new SoftAssertions();
        for (int i = 0; i < expectedData.size(); i++) {
            softAssertion.assertThat(expectedData.get(i)).as(expectedData.get(i) + " amount does not find its match")
                    .isIn(actualOptionValues);
            logger.info(expectedData.get(i) + " equals to " + actualOptionValues.get(i));
        }
        logger.info("----------");
        softAssertion.assertAll();
        return this;
    }

    @Step
    public AustarliaPowerballPage refreshAUPowerballLottoPage() {
        userRefreshTab();
        return this;
    }

    @Step
    public AustarliaPowerballPage clickOnOneHundButton() {
        clickOnElement(oneHundrDollars);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkOneHundOnBalanceMeter(String oneHUnd) {
        forTextComparing(oneHUnd, balanceMeter);
        return this;
    }

    @Step
    public AustarliaPowerballPage clickOnOneThousandButton() {
        clickOnElement(oneThousandDollars);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkOneThousandOnBalanceMeter(String oneThous) {
        forTextComparing(oneThous, balanceMeter);
        return this;
    }

    @Step
    public AustarliaPowerballPage clickOnTenThousandButton() {
        clickOnElement(tenThousandsDollars);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkTenThousandOnBalanceMeter(String tenThous) {
        forTextComparing(tenThous, balanceMeter);
        return this;
    }

    @Step
    public AustarliaPowerballPage clickOnOneHundThousandButton() {
        clickOnElement(oneHundrThousDollars);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkOneHundThousandOnBalanceMeter(String oneHUndThous) {
        forTextComparing(oneHUndThous, balanceMeter);
        return this;
    }

    @Step
    public AustarliaPowerballPage checkAddingEachMoneyOptionToAccount(String oneHUnd, String oneThous, String tenThous, String oneHUndThous) {
        clickOnOneHundButton();
        checkOneHundOnBalanceMeter(oneHUnd);
        refreshAUPowerballLottoPage();
        clickOnOneThousandButton();
        checkOneThousandOnBalanceMeter(oneThous);
        refreshAUPowerballLottoPage();
        clickOnTenThousandButton();
        checkTenThousandOnBalanceMeter(tenThous);
        refreshAUPowerballLottoPage();
        clickOnOneHundThousandButton();
        checkOneHundThousandOnBalanceMeter(oneHUndThous);
        logger.info("----------");
        return this;
    }

    @Step
    public AustarliaPowerballPage checkSumOfAllMonetaryOptions(String endBalance) {
        double oneHUnd = 0, oneThous = 0, tenTous = 0, oneHundThous = 0;
        for (WebElement value : monetaryButtons) {
            if (value.getText().equalsIgnoreCase("$100")) {
                clickOnElement(oneHundrDollars);
                oneHUnd = 100.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(oneHUnd, actualBalance, 0.00);
                logger.info(oneHUnd + " = " + actualBalance);
            } else if (value.getText().equalsIgnoreCase("$1k")) {
                clickOnElement(oneThousandDollars);
                oneThous = 1000.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(1100.00, actualBalance, 0.00);
                logger.info(oneHUnd + "+" + oneThous + " = " + actualBalance);
            } else if (value.getText().equalsIgnoreCase("$10k")) {
                clickOnElement(tenThousandsDollars);
                tenTous = 10000.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(11100.00, actualBalance, 0.00);
                logger.info(oneHUnd + "+" + oneThous + "+" + tenTous + " = " + actualBalance);
            } else if (value.getText().equalsIgnoreCase("$100k")) {
                clickOnElement(oneHundrThousDollars);
                oneHundThous = 100000.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(111100.00, actualBalance, 0.00);
                logger.info(oneHUnd + "+" + oneThous + "+" + tenTous + "+" + oneHundThous + " = " + actualBalance);
            }
        }
        Assert.assertEquals(endBalance, balanceMeter.getText());
        return this;
    }

}
