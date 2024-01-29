package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends ParentPage {

    @FindBy(xpath = ".//div//h1[@class='h1']")
    private WebElement textFavorites;
    @FindBy(xpath = ".//div//a[@data-id='6101' and @class='h3 detail-info-prod']")
    private WebElement bedBeTogether;

    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/personal/favorites/";
    }

    public FavoritesPage checkIsRedirectToFavoritesPage() {
        checkUrl();
        Assert.assertTrue("Invalid page - not Home Page", isElementFavoritesDisplayed());
        checkTextInElement(textFavorites, "Favorites");
        return this;
    }

    public boolean isElementFavoritesDisplayed() {
        logger.info("Is text Favorites present: " + isElementDisplayed(textFavorites));
        return isElementDisplayed(textFavorites);
    }

    public FavoritesPage checkIsProductBeTogetherPresent() {
        Assert.assertTrue("Beds Be together isn't present", isBedBeTogetherDisplayed());
        checkTextInElement(bedBeTogether, "Be Together! L8Т (16)L");
        return this;
    }

    private boolean isBedBeTogetherDisplayed() {
        logger.info("Is bed Be together present: " + isElementDisplayed(bedBeTogether));
        return isElementDisplayed(bedBeTogether);
    }
}