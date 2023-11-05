package startingPageTest;
/*
Verify starting webpage loads
1. Open the link: https://lottosimulation.com/
Expected Result:
The website loads the starting page.
The URL is equal to https://lottosimulation.com/.
“Free Lottery Simulation” header is displayed.
 */

import baseTest.BaseTest;
import org.junit.Test;

public class LoadStartingPageTest extends BaseTest {
@Test
    public  void loadStartPage(){
    startingPage.openStartingPage()
            .checkUrl()
            .checkMailTitle();
}
}
