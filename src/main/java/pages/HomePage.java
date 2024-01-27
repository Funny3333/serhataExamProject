package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//input[@id='title-search-input']")
    private WebElement inputSearch;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        Assert.assertTrue("Invalid page - not Home Page", getHeader().isIconUserPresent());
        return this;
    }

    public HeaderElement getHeader() {
        return new HeaderElement(webDriver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage enterTextInToSearchField(String textForSearch) {
        logger.info("Enter text in to input Search - " + textForSearch);
        enterTextInToInput(inputSearch, textForSearch);
        return this;
    }

    public HomePage clickOnSearchField() {
        logger.info("Click on Search field");
        clickOnElement(inputSearch);
        return this;
    }
}
