package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AustraliaSaturdayLottoPage extends ParentPage{
    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing Saturday Lotto Australia')]")
    private WebElement mainTitleAustrSaturdayLotto;

    public AustraliaSaturdayLottoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/lotto-sat";
    }

    @Step
    public AustraliaSaturdayLottoPage checkIsRedirectedToAustrSaturdayLottoOption(String title){
        checkURL();
        isElementDisplayed(mainTitleAustrSaturdayLotto);
        forTextComparing(title, mainTitleAustrSaturdayLotto);
        logger.info("----------");
        return this;
    }
}
