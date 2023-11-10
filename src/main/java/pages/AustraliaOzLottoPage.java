package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AustraliaOzLottoPage extends ParentPage{

    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing Oz Lotto Australia')]")
    private WebElement mainTitleAustrOzLotto;

    public AustraliaOzLottoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/oz-lotto";
    }

    @Step
    public AustraliaOzLottoPage checkIsRedirectedToAustralianOzlLotto(String title){
        checkURL();
        isElementDisplayed(mainTitleAustrOzLotto);
        forTextComparing(title, mainTitleAustrOzLotto);
        logger.info("----------");
        return this;
    }
}