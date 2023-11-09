package lottoMenuTest;
/*
Verify Lotto Menu and Sub-menu Options on Starting Page
- Steps:
    1. Open the link: https://lottosimulation.com/
- Expected Results:
    - The website loads the home page.
    - The URL is equal to https://lottosimulation.com/.
    - The "Free Lottery Simulation" header is displayed, and its content matches the expected text.
    2. Verify that the top menu contains the following options: Australia, United States, Europe.
       - Expected Result:
         - The top menu contains the options: Australia, United States, and Europe.
    3. For the Australia option, hover over it to check if it displays 4 sub-options: Powerball, Oz Lotto, Saturday Lotto, Monday & Wednesday Lotto.
       - Expected Result:
         - The Australia option displays 4 sub-options: Powerball, Oz Lotto, Saturday Lotto, and Monday & Wednesday Lotto when hovered over.
    4. For the United States option, hover over it to check if it displays 2 sub-options: Powerball and Mega Million.
       - Expected Result:
         - The United States option displays 2 sub-options: Powerball and Mega Million when hovered over.
    5. For the Europe option, hover over it to check if it displays 2 sub-options: Euro Millions and Euro Jackpot.
       - Expected Result:
         - The Europe option displays 2 sub-options: Euro Millions and Euro Jackpot when hovered over.
 */

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Test;


import static libs.TestData.*;


@Feature("Lotto Menu and Sub-menu Options on Starting Page.")
public class LottoMenuTest extends BaseTest {
    @Description("Verifying the Lotto menu and sub-menu options on the starting page are available to the user and named properly.")
    @Test
    public void menuOptionsVerification() {
        headerElements.openHomePage(MAIN_TITLE)
                .checkMainMenu(MAIN_MENU_ITEMS)
                .hoverOnAustralia_Element()
                .checkSubMenuForAustaria(SUB_MENU_AUSTRALIA)
                .hoverOnUS_Element()
                .checkSubMenuForUS(SUB_MENU_US)
                .hoverOnEU_Element()
                .checkSubMenuForEU(SUB_MENU_EU);
    }
}