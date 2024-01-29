package favoritesTests;

import baseTest.BaseTest;
import org.junit.Test;

public class FavoritesTest extends BaseTest {
    @Test
    public void addProductToFavorites() {
        pageProvider.loginPage()
               .openLoginPage();
       pageProvider.loginPage()
            .clickByYesButton()
               .clickOnDropDownSelectValue("Beds");
       pageProvider.bedsPage().checkIsRedirectToBedsPage()
               .clickOnProductLineGroup("Blest Kids")
               .addToFavouriteBeTogetherBed()
               .clickOnIconFavorite();
       pageProvider.favoritesPage()
               .checkIsRedirectToFavoritesPage()
               .checkIsProductBeTogetherPresent();
    }
}