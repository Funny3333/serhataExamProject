package loginTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import static libs.TestData.EXIST_USER_EMAIL;
import static libs.TestData.EXIST_USER_PASSWORD;


public class LoginTest extends BaseTest {
    @Test
    public void validLogin() {
        pageProvider.loginPage().openLoginPage();
        pageProvider.loginPage().clickOnButtonLoginAccount();
        pageProvider.loginPage().enterTextInToInputEmail(EXIST_USER_EMAIL);
        pageProvider.loginPage().enterTextInToInputPassword(EXIST_USER_PASSWORD);
        pageProvider.loginPage().clickOnButtonLogIn();
        Assert.assertTrue("Icon User is not visible", pageProvider.homePage().getHeader().isIconUserPresent());
        Assert.assertTrue("User name olena test1 is not visible", pageProvider.homePage().getHeader().isUserNamePresent());
        pageProvider.loginPage().checkIsLoginAccountOptionIsNotVisible();
    }
}
