package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.TestData.AUSTRALIA_MON_AND_WEDN_LOTTO_TITLE;

public class AustrMondAndWednLottoPage extends ParentPage{

    @FindBy(xpath = ".//h1[contains(text(), 'Simulate playing Monday & Wednesday Lotto Australia')]")
    private WebElement mainTitleMondAndWedn;


    public AustrMondAndWednLottoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/au/lotto-mon-wed";
    }

    public AustrMondAndWednLottoPage checkIsRedirectedToAustrMondAndWednLotto(String title){
        checkURL();
        isElementDisplayed(mainTitleMondAndWedn);
        forTextComparing(title, mainTitleMondAndWedn);
        logger.info("----------");
        return this;
    }
}
