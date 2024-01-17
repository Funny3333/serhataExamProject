package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = "//span[@class='icon-user']")
    private WebElement iconUser;
    @FindBy(xpath = "//div[text()='Hello,']")
    private WebElement textHello;
    @FindBy(xpath = "//div[text()='olena test1']")
    private WebElement userName;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isIconUserPresent() {
        logger.info("Is icon user present: " + isElementDisplayed(iconUser));
        return isElementDisplayed(iconUser);
    }

    public boolean isUserNamePresent() {
        return isElementDisplayed(userName);
    }
}
