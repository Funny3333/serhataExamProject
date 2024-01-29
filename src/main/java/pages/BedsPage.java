package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BedsPage extends ParentPage {
    @FindBy(xpath = ".//div//h1[@class='h1']")
    private WebElement textBeds;
    @FindBy(xpath = ".//div//button[@aria-label='add to favorite' and @data-item='6101']")
    private WebElement buttonFavouriteForModelBeTogether;
    @FindBy(xpath = ".//div//span[@id='block_fav_color']")
    private WebElement iconFavorite;
    public BedsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/category/krovati/";
    }

    public BedsPage checkIsRedirectToBedsPage() {
        checkUrl();
        Assert.assertTrue("Invalid page - not Home Page", isElementBedsDisplayed());
        checkTextInElement(textBeds, "Beds");
        return this;
    }

    public boolean isElementBedsDisplayed() {
        logger.info("Is text Beds present: " + isElementDisplayed(textBeds));
        return isElementDisplayed(textBeds);
    }

    private BedsPage clickByVisibleProductLineText(String text) {
        try {
            WebElement element = webDriver.findElement(By.xpath(".//div//a[@class='text-label' and contains(text(), '" + text + "')]"));
            element.click();
            logger.info("Clicked on the element with text: " + text);
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
        return this;
    }

    public BedsPage clickOnProductLineGroup(String groupName) {
        clickByVisibleProductLineText(groupName);
        return this;
    }

    public BedsPage addToFavouriteBeTogetherBed() {
        clickOnElement(buttonFavouriteForModelBeTogether);
        return this;
    }

    public void clickOnIconFavorite() {
        logger.info("Click on icon favorite " + iconFavorite);
        clickOnElement(iconFavorite);
    }
}
