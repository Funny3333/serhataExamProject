package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin() {
        pageProvider.loginPage().openLoginPage();
        pageProvider.loginPage().clickOnButtonLoginAccount();
    }
}
