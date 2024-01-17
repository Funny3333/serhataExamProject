package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//все загальне для сторінок
abstract public class ParentPage extends CommonActionsWithElements {
    //все загальне для сторінок
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    // метод для отримання частини URL
    protected abstract String getRelativeUrl();

    final String baseUrl = "https://blest.ua/en/";

    // метод для перевірки чи відкрита потрібна сторінка
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
