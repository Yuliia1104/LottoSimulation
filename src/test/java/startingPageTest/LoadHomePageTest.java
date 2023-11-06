package startingPageTest;
/*
Verify that home webpage loads
1. Open the link: https://lottosimulation.com/
Expected Result:
The website loads the starting page.
The URL is equal to https://lottosimulation.com/.
“Free Lottery Simulation” header is displayed.
 */

import baseTest.BaseTest;
import org.junit.Test;

public class LoadHomePageTest extends BaseTest {
@Test
    public  void loadStartPage(){
    homePage.openHomePage()
            .checkUrl()
            .checkMailTitle();
}
}
