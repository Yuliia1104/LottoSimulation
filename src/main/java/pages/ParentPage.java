package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends CommonActionWithElements {
    String baseURL = "https://lottosimulation.com/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

}
