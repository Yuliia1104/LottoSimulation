package lottoMenuTest;

import baseTest.BaseTest;
import org.junit.Test;

/*
Verify that "Australia" menu options are clickable and transfer user to the chosen option.
1. Open the link: https://lottosimulation.com/
c
The website loads the home page.
The URL is equal to https://lottosimulation.com/.
“Free Lottery Simulation” header is displayed.
2. Hover "Australia" tab and click on Powerball option.
Expected Result:
User is transferred to the Powerball page. The header is present on the page and is equal to “Simulate playing the Australian Powerball”.
The URL is equal to https://lottosimulation.com/au/powerball
3. Hover "Australia" tab and click on Oz Lotto option.
Expected Result:
User is transferred to the Oz Lotto page. The header is present on the page and is equal to “Simulate playing Oz Lotto Australia”.
The URL is equal to https://lottosimulation.com/au/oz-lotto
4. Hover "Australia" tab and click on Saturday Lotto option.
Expected Result:
User is transferred to the Saturday Lotto page. The header is present on the page and is equal to “Simulate playing Saturday Lotto Australia”.
The URL is equal to https://lottosimulation.com/au/lotto-sat
5. Hover "Australia" tab and click on Monday & Wednesday Lotto option.
Expected Result:
User is transferred to the Monday & Wednesday Lotto page. The header is present on the page and is equal to “Simulate playing Monday & Wednesday Lotto Australia”.
The URL is equal to https://lottosimulation.com/au/lotto-mon-wed
 */
public class AustraliaOptionsAccessTest extends BaseTest {
    @Test
    public void AustraliaSubMenuOptionAccessibility(){
        headerElements.openHomePage()
                .hoverOnAustralia_Element()
                .clickPowerballOption()
                .checkIsRedirectedToAustralianPowerballLotto();
        headerElements.hoverOnAustralia_Element()
                .clickOZLottoOption()
                .checkIsRedirectedToAustralianOzlLotto();
        headerElements.hoverOnAustralia_Element()
                .clickSaturdayLottoOption()
                .checkIsRedirectedToAustrSaturdayLottoOption();
        headerElements.hoverOnAustralia_Element()
                .clickMondAndWednLottoOption()
                .checkIsRedirectedToAustrMondAndWednLotto();
    }
}

