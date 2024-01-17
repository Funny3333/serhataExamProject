package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//span[@id='popup_auth_user']")
    private WebElement loginAccount;
    @FindBy(xpath = ".//input[@class='form-control' and @name='USER_LOGIN' and not (@id)]")
    private WebElement inputEmail;
    @FindBy(xpath = ".//input[@class='form-control' and @name='USER_PASSWORD' and not (@id)]")
    private WebElement inputPassword;
    @FindBy(xpath = ".//button[@name='Login']")
    private WebElement buttonLogIn;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() { return "/"; }

    public void openLoginPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened " + baseUrl);
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void clickOnButtonLoginAccount() {
        logger.info("Click on button Login Account");
        clickOnElement(loginAccount);
    }

    public void enterTextInToInputEmail(String existUserEmail) {
        logger.info("Enter text in to input Email");
        enterTextInToInput(inputEmail, existUserEmail);
    }

    public void enterTextInToInputPassword(String existUserPassword) {
        logger.info("Enter text in to input Password");
        enterTextInToInput(inputPassword, existUserPassword);
    }

    public void clickOnButtonLogIn() {
        logger.info("Click on button " + buttonLogIn);
        clickOnElement(buttonLogIn);
    }

    public void checkIsLoginAccountOptionIsNotVisible() {
        checkIsElementNotVisible(loginAccount);
        logger.info("Login account option is not visible");
    }
}
