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
    @FindBy(xpath = ".//span[contains(text(),'Register now')]")
    private WebElement buttonRegisterNow;
    @FindBy(xpath = ".//input[@aria-label = 'Name']")
    private WebElement inputName;
    @FindBy(xpath = ".//input[@aria-label = 'Last name']")
    private WebElement inputLastName;
    @FindBy(xpath = ".//input[@aria-label = 'Phone']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = ".//input[@name = 'REGISTER[EMAIL]']")
    private WebElement inputRegistrationEmail;
    @FindBy(xpath = ".//input[@name = 'REGISTER[PASSWORD]']")
    private WebElement inputRegistrationPassword;
   @FindBy(xpath = ".//input[@name = 'REGISTER[CONFIRM_PASSWORD]' and @type='password']")
    private WebElement inputConfirmRegistrationPassword;
    @FindBy(xpath = ".//button[@name = 'register_submit_button']")
   private WebElement buttonRegister;
    @FindBy(xpath = ".//div[@id='comp_fda733c5257f5d7745e29d26d4b8189d']//div[@class='confirmed-modal']")
    private WebElement confirmedModal;


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

    public void clickOnButtonRegisterNow() {
        logger.info("Click on button " + buttonRegisterNow);
        clickOnElement(buttonRegisterNow);
    }

    public void enterTextIntoInputName(String newUserName) {
        logger.info("Enter text in to input Name " + newUserName);
        enterTextInToInput(inputName, newUserName);
    }

    public void enterTextIntoInputLastName(String newLastName) {
        logger.info("Enter text in to input Last Name " + newLastName);
        enterTextInToInput(inputLastName, newLastName);
    }

    public void enterTextIntoInputPhone(String number) {
        logger.info("Enter text in to input Phone " + number);
        enterTextInToInput(inputPhoneNumber, number);
    }

    public void enterTextIntoInputRegistrationEmail(String newEmail) {
        logger.info("Enter text in to input Registration Email " + newEmail);
        enterTextInToInput(inputRegistrationEmail, newEmail);
    }

    public void enterTextIntoInputPassword(String password) {
        logger.info("Enter text in to input Password " + password);
        enterTextInToInput(inputRegistrationPassword, password);
    }

    public void enterTextIntoInputPasswordConfirmation(String confirmPassword) {
        logger.info("Enter text in to input Password Confirmation " + confirmPassword);
        enterTextInToInput(inputConfirmRegistrationPassword, confirmPassword);
    }

    public void clickOnButtonRegister() {
        logger.info("Click on button Register");
        clickOnElement(buttonRegister);
    }

    public boolean isConfirmedModalPresent() {
        logger.info("Is confirmed modal present: " + isElementDisplayed(confirmedModal));
        return isElementDisplayed(confirmedModal);
    }
}
