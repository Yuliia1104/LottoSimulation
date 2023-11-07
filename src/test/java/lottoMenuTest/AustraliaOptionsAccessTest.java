package lottoMenuTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

import static libs.TestData.*;

/*
Verify "Australia" Menu Options are Clickable and Redirect to the Chosen Option
1. Steps:
    1. Open the link: https://lottosimulation.com/
    - The website loads the home page.
    - The URL is equal to https://lottosimulation.com/.
    - The "Free Lottery Simulation" header is displayed.
    2. Hover over the "Australia" tab and click on the "Powerball" option.
    - Expected Result:
      - The user is transferred to the Powerball page.
      - The header on the page is present and matches the text "Simulate playing the Australian Powerball."
      - The URL is equal to https://lottosimulation.com/au/powerball.
    3. Hover over the "Australia" tab and click on the "Oz Lotto" option.
    - Expected Result:
      - The user is transferred to the Oz Lotto page.
      - The header on the page is present and matches the text "Simulate playing Oz Lotto Australia."
      - The URL is equal to https://lottosimulation.com/au/oz-lotto.
    4. Hover over the "Australia" tab and click on the "Saturday Lotto" option.
    - Expected Result:
      - The user is transferred to the Saturday Lotto page.
      - The header on the page is present and matches the text "Simulate playing Saturday Lotto Australia."
      - The URL is equal to https://lottosimulation.com/au/lotto-sat.
    5. Hover over the "Australia" tab and click on the "Monday & Wednesday Lotto" option.
    - Expected Result:
      - The user is transferred to the Monday & Wednesday Lotto page.
      - The header on the page is present and matches the text "Simulate playing Monday & Wednesday Lotto Australia."
      - The URL is equal to https://lottosimulation.com/au/lotto-mon-wed.
 */
public class AustraliaOptionsAccessTest extends BaseTest {
    @Test
    public void AustraliaSubMenuOptionAccessibility(){
        headerElements.openHomePage(MAIN_TITLE)
                .hoverOnAustralia_Element()
                .clickPowerballOption()
                .checkIsRedirectedToAustralianPowerballLotto(AUSTRALIA_POWERBALL_TITLE);
        headerElements.hoverOnAustralia_Element()
                .clickOZLottoOption()
                .checkIsRedirectedToAustralianOzlLotto(AUSTRALIA_OZ_LOTTO_TITLE);
        headerElements.hoverOnAustralia_Element()
                .clickSaturdayLottoOption()
                .checkIsRedirectedToAustrSaturdayLottoOption(AUSTRALIA_SATURDAY_LOTTO_TITLE);
        headerElements.hoverOnAustralia_Element()
                .clickMondAndWednLottoOption()
                .checkIsRedirectedToAustrMondAndWednLotto(AUSTRALIA_MON_AND_WEDN_LOTTO_TITLE);
    }
}

