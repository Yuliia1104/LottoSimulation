package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.TestData.AUSTRALIA_SATURDAY_LOTTO_TITLE;

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
    public AustraliaSaturdayLottoPage checkAUSaturdayLottoURL(){
        checkURL();
        return this;
    }

    @Step
    public  AustraliaSaturdayLottoPage isAUSatLottoMainTitleDisplayed(){
        isElementDisplayed(mainTitleAustrSaturdayLotto);
        return this;
    }

    @Step
    public AustraliaSaturdayLottoPage checkAUSatLottoTitleContent(String title){
        forTextComparing(title, mainTitleAustrSaturdayLotto);
        return this;
    }
    @Step
    public AustraliaSaturdayLottoPage checkIsRedirectedToAustrSaturdayLottoOption(String title){
        checkAUSaturdayLottoURL();
        isAUSatLottoMainTitleDisplayed();
        checkAUSatLottoTitleContent(title);
        logger.info("----------");
        return this;
    }
}
