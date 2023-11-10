package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

    @Step
    public AustrMondAndWednLottoPage checkIsRedirectedToAustrMondAndWednLotto(String title){
        checkURL();
        isElementDisplayed(mainTitleMondAndWedn);
        forTextComparing(title, mainTitleMondAndWedn);
        logger.info("----------");
        return this;
    }
}
