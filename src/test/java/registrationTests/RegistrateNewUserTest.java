package registrationTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Assert;
import org.junit.Test;

public class RegistrateNewUserTest extends BaseTest {
    final String NEW_USER_NAME = "test" + Util.getDateAndTimeFormatted();
    final String NEW_LAST_NAME = "last" + Util.getDateAndTimeFormattedOnlyNumbers();
    final String REGISTRATION_PASSWORD = Util.getDateAndTimeFormattedOnlyNumbers();
    @Test
    public void registrationNewUser() {
        pageProvider.loginPage().openLoginPage();
        pageProvider.loginPage().clickOnButtonLoginAccount();
        pageProvider.loginPage().clickOnButtonRegisterNow();
        pageProvider.loginPage().enterTextIntoInputName(NEW_USER_NAME);
        pageProvider.loginPage().enterTextIntoInputLastName(NEW_LAST_NAME);
        pageProvider.loginPage().enterTextIntoInputPhone("+380001112233");
        pageProvider.loginPage().enterTextIntoInputRegistrationEmail("test" + Util.getDateAndTimeFormattedOnlyNumbers() + "@test.com");
        pageProvider.loginPage().enterTextIntoInputPassword(REGISTRATION_PASSWORD);
        pageProvider.loginPage().enterTextIntoInputPasswordConfirmation(REGISTRATION_PASSWORD);
        pageProvider.loginPage().clickOnButtonRegister();
        Assert.assertTrue("Confirmed modal is not visible", pageProvider.loginPage().isConfirmedModalPresent());
    }
}
