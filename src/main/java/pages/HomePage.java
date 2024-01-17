package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage{

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
}
