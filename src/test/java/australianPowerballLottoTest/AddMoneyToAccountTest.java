package australianPowerballLottoTest;

import baseTest.BaseTest;
import org.junit.Test;
import static libs.TestData.*;

/*
Verify "Australia" Menu Options are Clickable and Redirect to the Chosen Option
1. Steps:
    1. Open the link: https://lottosimulation.com/.
    - The website loads the home page.
    - The URL is equal to https://lottosimulation.com/.
    - The "Free Lottery Simulation" header is displayed.
    2. Hover over the "Australia" tab and click on the "Powerball" option.
    - Expected Result:
      - The user is transferred to the Powerball page.
      - The header on the page is present and matches the text "Simulate playing the Australian Powerball.".
      - The URL is equal to https://lottosimulation.com/au/powerball.
    3. Verify that $100, $1k, $10k, $100K options are displayed on the screen. .//*[@class='add-buttons']//button
    - Expected Result:
       - buttons $100, $1k, $10k, $100K are displayed and readily available to the user.
    4. Verify that by clicking on each monetary option can add its value to the "Balance" meter. .//*[@class='table status']//tr//th[text()='Balance']
    - Expected Result:
       - Each click adds monetary value to the "Balance" meter.
       - End balance in the "Balance" meter is equal to the sum of all available monetary options.

 */
public class AddMoneyToAccountTest extends BaseTest {
    @Test
    public void addMoneyToBalanceVerification(){
        headerElements.openHomePage(MAIN_TITLE)
                .hoverOnAustralia_Element()
                .clickPowerballOption()
                .checkIsRedirectedToAustralianPowerballLotto(AUSTRALIA_POWERBALL_TITLE)
                .checkMonetaryOptions(MONETARY_OPTIONS)
                .checkSumOfAllMonetaryOptions(END_BALANCE);



    }
}