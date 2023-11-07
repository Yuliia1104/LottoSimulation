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
import libs.TestData;
import org.junit.Test;

public class LoadHomePageTest extends BaseTest {
@Test
    public  void loadStartPage(){
    homePage.openHomePage()
            .checkUrl()
            .checkMailTitle(TestData.MAIN_TITLE);
}
}
