package pages.elements;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class HeaderElements extends ParentPage {
    HomePage homePage = new HomePage(webDriver);
    Logger logger = Logger.getLogger(getClass());
    @FindBy(xpath = ".//h1[contains(text(),'Free Lottery Simulation')]")
    private WebElement mainTitle;
    @FindBy(xpath = ".//li[@class = 'navSection primary']//a[@class='rootLink hasDropdown colorize']")
    private List<WebElement> mainMenuItems;
    @FindBy(xpath = ".//*[@class='dropdownRoot']//*[@data-dropdown='australia']//li//a")
    private List<WebElement> subMenuAustralia;
    @FindBy(xpath = ".//*[@class='dropdownRoot']//*[@data-dropdown='us']//li//a")
    private List<WebElement> subMenuUS;
    @FindBy(xpath = ".//*[@class='dropdownRoot']//*[@data-dropdown='eu']//li//a")
    private List<WebElement> subMenuEU;
    @FindBy(xpath = ".//a[@data-dropdown = 'australia']")
    private WebElement australiaOption;
    @FindBy(xpath = ".//a[@data-dropdown = 'us']")
    private WebElement unatedStatesOption;
    @FindBy(xpath = ".//a[@data-dropdown = 'eu']")
    private WebElement europeOption;
    @FindBy(xpath = ".//*[@data-dropdown = 'australia']//*[@class ='dropdownContent']//a[@href='/au/powerball']")
    private WebElement australianPowerball;
    @FindBy(xpath = ".//*[@data-dropdown = 'australia']//*[@class ='dropdownContent']//a[contains(text(), 'Oz Lotto')]")
    private WebElement australianOzLotto;
    @FindBy(xpath = ".//*[@data-dropdown = 'australia']//*[@class ='dropdownContent']//a[contains(text(), 'Saturday Lotto')]")
    private WebElement australianSaturdayLotto;
    @FindBy(xpath = ".//*[@data-dropdown = 'australia']//*[@class ='dropdownContent']//a[contains(text(), 'Monday & Wednesday Lotto')]")
    private WebElement australianMondayWednesdayLotto;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public HeaderElements openHomePage(String text) {
        homePage.openHomePage()
                .checkUrl()
                .checkMailTitle(text);
        return this;
    }

    @Step
    public HeaderElements checkMainMenu(ArrayList<String> expevtedData) {
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : mainMenuItems) {
            actualList.add(webElement.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expevtedData.size(); i++) {
            softAssertions.assertThat(expevtedData.get(i)).as(expevtedData.get(i) + " does not find its match").isIn(actualList);
        }
        logger.info("Menu options are verified");
        logger.info("----------");
        softAssertions.assertAll();
        return this;
    }

    @Step
    public HeaderElements hoverOnAustralia_Element(){
        hoverOverElement(australiaOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(australianPowerball));
        return this;
    }

    @Step
    public HeaderElements checkSubMenuForAustaria(ArrayList<String> expevtedData) {
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuAustralia) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertion = new SoftAssertions();
        for (int i = 0; i < expevtedData.size(); i++) {
            softAssertion.assertThat(expevtedData.get(i)).as(expevtedData.get(i) + " does not find its match").isIn(actualList);
            logger.info(expevtedData.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertion.assertAll();
        return this;
    }

    @Step
    public HeaderElements hoverOnUS_Element(){
        hoverOverElement(unatedStatesOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuUS));
        return this;
    }

    @Step
    public HeaderElements checkSubMenuForUS(ArrayList<String> expevtedData) {
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuUS) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertion = new SoftAssertions();
        for (int i = 0; i < expevtedData.size(); i++) {
            softAssertion.assertThat(expevtedData.get(i)).as(expevtedData.get(i) + " does not find its match").isIn(actualList);
            logger.info(expevtedData.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertion.assertAll();
        return this;
    }

    @Step
    public HeaderElements hoverOnEU_Element(){
        hoverOverElement(europeOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuEU));
        return this;
    }

    @Step
    public HeaderElements checkSubMenuForEU(ArrayList<String> expevtedData) {
        hoverOverElement(europeOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuEU));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuEU) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertion = new SoftAssertions();
        for (int i = 0; i < expevtedData.size(); i++) {
            softAssertion.assertThat(expevtedData.get(i)).as(expevtedData.get(i) + " does not find its match").isIn(actualList);
            logger.info(expevtedData.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertion.assertAll();
        return this;
    }

    @Step
    public AustarliaPowerballPage clickPowerballOption(){
        webDriverWait30.until(ExpectedConditions.visibilityOf(australianPowerball));
        waitABit(1);
        clickOnElement(australianPowerball);
        return new AustarliaPowerballPage(webDriver);
    }

    @Step
    public AustraliaOzLottoPage clickOZLottoOption(){
        webDriverWait30.until(ExpectedConditions.elementToBeClickable(australianOzLotto));
        clickOnElement(australianOzLotto);
        return new AustraliaOzLottoPage(webDriver);
    }

    @Step
    public AustraliaSaturdayLottoPage clickSaturdayLottoOption(){
        webDriverWait30.until(ExpectedConditions.elementToBeClickable(australianSaturdayLotto));
        clickOnElement(australianSaturdayLotto);
        return new AustraliaSaturdayLottoPage(webDriver);
    }

    @Step
    public AustrMondAndWednLottoPage clickMondAndWednLottoOption(){
        webDriverWait30.until(ExpectedConditions.elementToBeClickable(australianMondayWednesdayLotto));
        clickOnElement(australianMondayWednesdayLotto);
        return new AustrMondAndWednLottoPage(webDriver);
    }
}


