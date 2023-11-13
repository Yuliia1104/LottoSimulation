package pages;

import io.qameta.allure.Step;
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

    @Step
    public  AustraliaOzLottoPage checkAUOZLottoURL(){
        checkURL();
        return this;
    }

    @Step
    public AustraliaOzLottoPage isOZLottoMainTitleDisplayed(){
        isElementDisplayed(mainTitleAustrOzLotto);
        return this;
    }

    @Step
    public AustraliaOzLottoPage checkAUOZLottoMainTitleContent(String title){
        forTextComparing(title, mainTitleAustrOzLotto);
        return this;
    }
    @Step
    public AustraliaOzLottoPage checkIsRedirectedToAustralianOzlLotto(String title){
        checkAUOZLottoURL();
        isOZLottoMainTitleDisplayed();
        checkAUOZLottoMainTitleContent(title);
        logger.info("----------");
        return this;
    }
}