package startingPageTest;
/*
 Verify Homepage Loads
- Steps:
    1. Open the link: https://lottosimulation.com/
- Expected Result:
    - The website loads the starting page.
    - The URL is equal to https://lottosimulation.com/.
    - The "Free Lottery Simulation" header is displayed and its content matches the expected text.

 */

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import libs.TestData;
import org.junit.Test;

@Feature("Home Page Load")
public class LoadHomePageTest extends BaseTest {
@Test
@Description("Verify a seamless loading experience for the homepage," +
             " setting the foundation for subsequent interactions.")
    public  void loadStartPage(){
    homePage.openHomePage()
            .checkUrl()
            .checkMailTitle(TestData.MAIN_TITLE);
}
}
