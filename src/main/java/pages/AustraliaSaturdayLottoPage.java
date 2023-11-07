package pages;

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

    public AustraliaSaturdayLottoPage checkIsRedirectedToAustrSaturdayLottoOption(){
        checkURL();
        isElementDisplayed(mainTitleAustrSaturdayLotto);
        forTextComparing(AUSTRALIA_SATURDAY_LOTTO_TITLE, mainTitleAustrSaturdayLotto);
        logger.info("----------");
        return this;
    }
}
