package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeatersSofasPage extends ParentPage{

    @FindBy(xpath = ".//span[@class='check']")
    private WebElement checkBox;

    @FindBy(xpath = ".//div//h1[@class='h1']")
    private WebElement textSeatersSofas;

    @FindBy(xpath = ".//a[@rel='nofollow' and contains(text(),'Show')]")
    private WebElement filterShow;

    @FindBy(xpath = ".//a[@data-toggle='modal' and @data-id='71767']")
    private WebElement buttonBuyInOneClick;

    @FindBy(xpath = ".//form[@class='form-modal-preorder']")
    private WebElement modalBuyInOneClick;

    @FindBy(xpath = ".//form//div[@class='h4']")
    private WebElement textBuyInOneClickInModal;

    @FindBy(xpath = ".//form//p")
    private WebElement additionalTextInModal;

    @FindBy(xpath = ".//button[@value='Send']")
    private WebElement buttonSend;


    public SeatersSofasPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/category/divany-pryamye/";
    }

    public SeatersSofasPage checkIsRedirectToSeatersSofasPage() {
        checkUrl();
        Assert.assertTrue("Invalid page - not Home Page", isElementSeatersSofasDisplayed());
        checkTextInElement(textSeatersSofas, "2-3 seaters sofas 1");
        return this;
    }

    public boolean isElementSeatersSofasDisplayed() {
        logger.info("Is text 2-3 seaters sofas 1 is present: " + isElementDisplayed(textSeatersSofas));
        return isElementDisplayed(textSeatersSofas);
    }

    public SeatersSofasPage selectCheckboxUniqueState(String state) {
        setCheckboxState(checkBox,"Blest Home", state);
        return this;
    }

    public SeatersSofasPage clickOnFilterShow() {
        clickOnElement(filterShow);
        return this;
    }

    public SeatersSofasPage clickOnButtonBuyInOneClick() {
        logger.info("Click on button Buy in one click near model Santi ДЛ3 б/п П131 (2) + ДС");
        clickOnElement(buttonBuyInOneClick);
        return this;
    }
    public SeatersSofasPage checkIsModalBuyInOneClickDisplayed() {
        Assert.assertTrue("Buy in one click modal isn't displayed", isModalBuyInOneClickDisplayed());
        checkTextInElement(textBuyInOneClickInModal, "Buy in one click");
        checkTextInElement(additionalTextInModal, "Enter your contact phone number and we will call you back to clarify the details of the order");
        isElementDisplayed(buttonSend);
        return this;
    }

    private boolean isModalBuyInOneClickDisplayed() {
        logger.info("Is text Buy in one click is present: " + isElementDisplayed(modalBuyInOneClick));
        return isElementDisplayed(modalBuyInOneClick);
    }
}
