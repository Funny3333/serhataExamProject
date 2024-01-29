package searchTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class CheckSearchFieldTest extends BaseTest {
    @Test
    public void checkSearchField() {
    pageProvider.loginPage()
            .openLoginPageAndClickOnSearchField("Viveyro 2NR-ANL");
    pageProvider.loginPage().clickOnButtonSubmit();
    Assert.assertTrue("Search Result is not visible", pageProvider.loginPage().isSearchResultDisplayed());
    pageProvider.loginPage().checkTextInSuccessMessage("***Search Result: Viveyro 2NR-ANL***");
    }

    @Test
    public void checkSearchFieldForRegisteredUser() {
    pageProvider.loginPage()
            .openLoginPageAndFillLoginFormWithValidCred()
            .checkIsRedirectToHomePage()
            .clickOnSearchField()
            .enterTextInToSearchField("BL 104 БMR/1TM-TTML");
        pageProvider.loginPage().clickOnButtonSubmit();
        Assert.assertTrue("Search Result is not visible", pageProvider.loginPage().isSearchResultDisplayed());
        pageProvider.loginPage().checkTextInSuccessMessage("***Search Result: BL 104 БMR/1TM-TTML***");

    }
}