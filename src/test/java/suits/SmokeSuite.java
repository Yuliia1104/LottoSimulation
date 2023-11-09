package suits;

import australianLottoTest.AddMoneyToAccountTest;
import australianLottoTest.PowerballGameRulesTest;
import io.qameta.allure.Epic;
import lottoMenuTest.AustraliaOptionsAccessTest;
import lottoMenuTest.LottoMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import startingPageTest.LoadHomePageTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoadHomePageTest.class,
        LottoMenuTest.class,
        AustraliaOptionsAccessTest.class,
        PowerballGameRulesTest.class,
        AddMoneyToAccountTest.class
})
@Epic("User Experience Enhancement Epic")
public class SmokeSuite {
}
