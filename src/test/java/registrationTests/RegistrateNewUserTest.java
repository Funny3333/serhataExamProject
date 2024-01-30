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
        pageProvider.loginPage().clickByYesButton();
        pageProvider.loginPage().clickOnButtonLoginAccount();
        pageProvider.loginPage().clickOnButtonRegisterNow();
        pageProvider.loginPage().enterTextIntoInputName(NEW_USER_NAME);
        pageProvider.loginPage().enterTextIntoInputLastName(NEW_LAST_NAME);
        pageProvider.loginPage().enterTextIntoInputPhone(pageProvider.loginPage().generatePhoneNumber(), Long.valueOf("200"));
        pageProvider.loginPage().enterTextIntoInputRegistrationEmail("test" + Util.getDateAndTimeFormattedOnlyNumbers() + "@test.com",Long.valueOf("200"));
        pageProvider.loginPage().enterTextIntoInputPassword(REGISTRATION_PASSWORD, Long.valueOf("200"));
        pageProvider.loginPage().enterTextIntoInputPasswordConfirmation(REGISTRATION_PASSWORD, Long.valueOf("200"));
        pageProvider.loginPage().clickOnButtonRegister();
        Assert.assertTrue("Confirmed modal is not visible", pageProvider.loginPage().isConfirmedModalPresent());
    }
}


