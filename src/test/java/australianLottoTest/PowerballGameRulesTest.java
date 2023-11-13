package australianLottoTest;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import libs.TestData;
import org.junit.Test;

import static libs.TestData.*;

/*
Verify Australian Powerball Lotto Game Rules and Current Jackpot Amount
1. Steps:
    1. Open the link: https://lottosimulation.com/
    - The website loads the starting page.
    - The URL is equal to https://lottosimulation.com/.
    - The "Free Lottery Simulation" header is displayed.
    2. Hover over the "Australia" tab and click on the "Powerball" option.
    - Expected Result:
      - The user is transferred to the Powerball page.
      - The header on the page is present and matches the text "Simulate playing the Australian Powerball."
      - The URL is equal to https://lottosimulation.com/au/powerball.
    3. Verify that "Details & Rules" link is present on the page.
    - Expected Result:
      - "Details & Rules" link is present on the page.
    4. Click on the "Details & Rules" link below the main header.
    - Expected Result:
      - The user is transferred to the section "Details & Rules."
      - The header of this section is equal to "Australia Powerball details & rules", .//*[@id='rules']//h2[text()='Australia Powerball details & rules']
      - The section contains game rules that equal the following:
        - "The main balls and the Powerball are drawn from 2 separate barrels.
        - The main barrel contains numbers from 1 to 35, and the Powerball barrel numbers from 1 to 20.
        - 7 numbers are drawn from the main barrel, and one Powerball is drawn from the Powerball barrel."
      - Current Jackpot (JP) amount is equal to 8M.
 */
@Feature("Australian Powerball Lotto Game Rules and Current Jackpot Amount")
public class PowerballGameRulesTest extends BaseTest {
    @Description("Verify the Australian Powerball lotto game rules exist and relevant to the game" +
                 " and providing real-time jackpot information for an informed user experience.")
    @Test
    public void powerballGameRulesJPValueVerification(){
        headerElements.openHomePage(MAIN_TITLE)
                      .hoverOnAustralia_Element()
                      .clickPowerballOption()
                      .checkIsRedirectedToAustralianPowerballLotto(AUSTRALIA_POWERBALL_TITLE)
                      .checkGameRulesLinkPresence(GAME_RULES_AND_DETAILS_TITLE)
                      .checkGameRulesAndJPContent(GAME_RULES_CONTENT, JP_AMOUNT);


    }
}
