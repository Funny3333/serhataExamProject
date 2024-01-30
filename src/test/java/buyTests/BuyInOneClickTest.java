package buyTests;

import baseTest.BaseTest;
import org.junit.Test;

public class BuyInOneClickTest extends BaseTest {
    @Test
            public void buyInOneClickTest() {
        pageProvider.loginPage()
                .openLoginPage();
        pageProvider.loginPage()
                .clickByYesButton()
                .clickOnDropDownSelectValue("2-3 seaters sofas 1")
                .selectCheckboxUniqueState("check");
    }
}
