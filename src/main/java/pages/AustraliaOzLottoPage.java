package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.TestData.*;

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

    public AustraliaOzLottoPage checkIsRedirectedToAustralianOzlLotto(){
        checkURL();
        isElementDisplayed(mainTitleAustrOzLotto);
        forTextComparing(AUSTRALIA_OZ_LOTTO_TITLE, mainTitleAustrOzLotto);
        logger.info("----------");
        return this;
    }
}