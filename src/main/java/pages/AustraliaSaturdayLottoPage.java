package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AustraliaSaturdayLottoPage extends ParentPage {
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
    public AustraliaSaturdayLottoPage checkSaturdayLottoURL() {
        checkURL();
        return this;
    }

    @Step
    public AustraliaSaturdayLottoPage checkSaturdayLottoTitleDisplayed() {
        isElementDisplayed(mainTitleAustrSaturdayLotto);
        return this;
    }

    @Step
    public AustraliaSaturdayLottoPage checkSaturdayLottoTitleContent(String title) {
        forTextComparing(title, mainTitleAustrSaturdayLotto);
        return this;
    }

    @Step
    public AustraliaSaturdayLottoPage checkIsRedirectedToAustrSaturdayLottoOption(String title) {
        checkSaturdayLottoURL();
        checkSaturdayLottoTitleDisplayed();
        checkSaturdayLottoTitleContent(title);
        logger.info("----------");
        return this;
    }
}
