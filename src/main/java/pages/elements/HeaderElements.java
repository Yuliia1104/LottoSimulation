package pages.elements;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.ParentPage;

import java.util.ArrayList;
import java.util.List;

import static libs.TestData.*;

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

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HeaderElements openHomePage() {
        homePage.openHomePage()
                .checkUrl()
                .checkMailTitle();
        return this;
    }

    public HeaderElements checkMainMenu() {
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : mainMenuItems) {
            actualList.add(webElement.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < MAIN_MENU_ITEMS.size(); i++) {
            softAssertions.assertThat(MAIN_MENU_ITEMS.get(i)).as(MAIN_MENU_ITEMS.get(i) + " does not find its match").isIn(actualList);
        }
        logger.info("Menu options are verified");
        logger.info("----------");
        softAssertions.assertAll();
        return this;
    }

    public HeaderElements checkSubMenuForAustaria() {
        hoverOverElement(australiaOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuAustralia));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuAustralia) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < SUB_MENU_AUSTRALIA.size(); i++) {
            softAssertions.assertThat(SUB_MENU_AUSTRALIA.get(i)).as(SUB_MENU_AUSTRALIA.get(i) + " does not find its match").isIn(actualList);
            logger.info(SUB_MENU_AUSTRALIA.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertions.assertAll();
        return this;
    }

    public HeaderElements checkSubMenuForUS() {
        hoverOverElement(unatedStatesOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuUS));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuUS) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < SUB_MENU_US.size(); i++) {
            softAssertions.assertThat(SUB_MENU_US.get(i)).as(SUB_MENU_US.get(i) + " does not find its match").isIn(actualList);
            logger.info(SUB_MENU_US.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertions.assertAll();
        return this;
    }

    public HeaderElements checkSubMenuForEU() {
        hoverOverElement(europeOption);
        webDriverWait30.until(ExpectedConditions.visibilityOfAllElements(subMenuEU));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement webElement : subMenuEU) {
            actualList.add(webElement.getText().trim());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < SUB_MENU_EU.size(); i++) {
            softAssertions.assertThat(SUB_MENU_EU.get(i)).as(SUB_MENU_EU.get(i) + " does not find its match").isIn(actualList);
            logger.info(SUB_MENU_EU.get(i)+" matches with "+actualList.get(i));
        }
        logger.info("----------");
        softAssertions.assertAll();
        return this;
    }
}
