package pages;


import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

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
        forTextComparing(content, gameRulesContent);
        return this;
    }

    public AustarliaPowerballPage checkJPAmount(String jpValue) {
        forTextComparing(jpValue, jpAmount);
        return this;
    }


    public AustarliaPowerballPage checkMonetaryOptions(ArrayList<String> expectedData) {
        scrollToElemnt(balanceMeter);
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

    public AustarliaPowerballPage canAddMoneyOptionToAccount(String oneHUnd, String oneThous, String tenThous, String oneHUndThous) {
        clickOnElement(oneHundrDollars);
        forTextComparing(oneHUnd, balanceMeter);
        userRefreshTab();
        clickOnElement(oneThousandDollars);
        forTextComparing(oneThous, balanceMeter);
        userRefreshTab();
        clickOnElement(tenThousandsDollars);
        forTextComparing(tenThous, balanceMeter);
        userRefreshTab();
        clickOnElement(oneHundrThousDollars);
        forTextComparing(oneHUndThous, balanceMeter);
        logger.info("----------");
        return this;
    }

    public AustarliaPowerballPage checkMoneyAditionFunctionality() {
        userRefreshTab();

        double oneHUnd = 0, oneThous = 0, tenTous = 0, oneHundThous = 0;
        for (WebElement value : monetaryButtons) {
            if (value.getText().equalsIgnoreCase("$100")) {
                clickOnElement(oneHundrDollars);
                oneHUnd = 100.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(oneHUnd,actualBalance, 0.00);
                logger.info(oneHUnd +" = "+ actualBalance);
            } else if (value.getText().equalsIgnoreCase("$1k")) {
                clickOnElement(oneThousandDollars);
                oneThous = 1000.00;
                double actualBalance =Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(1100.00,actualBalance, 0.00);
                logger.info(oneHUnd+"+"+oneThous+" = "+ actualBalance);
            } else if (value.getText().equalsIgnoreCase("$10k")) {
                clickOnElement(tenThousandsDollars);
                tenTous = 10000.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(11100.00,actualBalance, 0.00);
                logger.info(oneHUnd+"+"+oneThous+"+"+tenTous+" = "+actualBalance);
            } else if (value.getText().equalsIgnoreCase("$100k")) {
                clickOnElement(oneHundrThousDollars);
                oneHundThous = 100000.00;
                double actualBalance = Double.parseDouble(balanceMeter.getText().substring(1).replace(",", ""));
                Assert.assertEquals(111100.00,actualBalance, 0.00);
                logger.info(oneHUnd+"+"+oneThous+"+"+tenTous+"+"+oneHundThous+" = "+actualBalance);
            }
        }
        Assert.assertEquals("$111,100.00", balanceMeter.getText());
        return this;
    }

}
