package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


abstract public class ParentPage extends CommonActionsWithElements {

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected abstract String getRelativeUrl();

    final String baseUrl = "https://blest.ua/en";

    protected void checkUrl() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl()
        );
    }

    protected void checkUrlWithPattern() {
        Assert.assertTrue("Invalid page \n"
                + "Expected url: " + baseUrl + getRelativeUrl() + "\n"
                + "Actual url: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl())
        );
    }
}
