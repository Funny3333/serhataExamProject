package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = "//span[@class='icon-user']")
    private WebElement IconUser;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isIconUserPresent() {
        logger.info("Is icon user present: " + isElementDisplayed(IconUser));
        return isElementDisplayed(IconUser);
    }
}
