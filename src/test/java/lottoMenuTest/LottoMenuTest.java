package lottoMenuTest;

import baseTest.BaseTest;
import org.junit.Test;

/*
Verify Lotto Menu options are present on starting page
Steps:
1. Open the link: https://lottosimulation.com/
Expected Result:
The website loads the home page.
The URL is equal to https://lottosimulation.com/.
“Free Lottery Simulation” header is displayed.
2. Verify that the top menu contains the following options: Australia, United States, Europe. .//li[@class = 'navSection primary']//a[@class='rootLink hasDropdown colorize']
Expected result:
The top menu contains options Australia, United States, and Europe.
3. For the Australia option, hover over it to check if it displays 4 sub-options: Powerball, Oz Lotto, Saturday Lotto, Monday & Wednesday Lotto.
Expected result: .//*[@class='dropdownRoot']//*[@data-dropdown='australia']//li
The Australia option displays 4 sub-options: Powerball, Oz Lotto, Saturday Lotto, and Monday & Wednesday Lotto when hovered over.
4. For the United States option, hover over it to check if it displays 2 sub-options: Powerball and Mega Million.
Expected result: .//*[@class='dropdownRoot']//*[@data-dropdown='us']//li
The United States option displays 2 sub-options: Powerball and Mega Million when hovered over.
5. For the Europe option, hover over it to check if it displays 2 sub-options: Euro Millions and Euro Jackpot.
Expected result: .//*[@class='dropdownRoot']//*[@data-dropdown='eu']//li
The Europe option displays 2 sub-options: Euro Millions and Euro Jackpot when hovered over.

 */
public class LottoMenuTest extends BaseTest {
    @Test
    public void menuOptionsVerification(){
        headerElements.openHomePage()
                      .checkMainMenu()
                      .checkSubMenuForAustaria()
                      .checkSubMenuForUS()
                      .checkSubMenuForEU();
    }
}
