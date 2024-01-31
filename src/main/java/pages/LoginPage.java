package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

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
    @FindBy(xpath = ".//button[@name = 'register_submit_button' and @value='Register']")
   private WebElement buttonRegister;
    @FindBy(xpath = ".//div[@id='comp_fda733c5257f5d7745e29d26d4b8189d']//div[@class='confirmed-modal']")
    private WebElement confirmedModal;
    @FindBy(xpath = ".//input[@id='title-search-input']")
    private WebElement inputSearch;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = ".//div[@class='search-settings d-md-flex align-items-md-end justify-content-md-between']")
    private WebElement searchResultField;
    @FindBy(xpath = ".//div//h1")
    private WebElement searchResultMessage;
    @FindBy(xpath = ".//div//a[@class='btn btn-agree']")
    private WebElement buttonYes;


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

    public void clickIntoInputLastName() {
        logger.info("Click on input Last Name");
        clickOnElement(inputLastName);
    }

    public void enterTextIntoInputPhone(String number, Long milliseconds) {
        logger.info("Enter text in to input Phone " + number);
        enterTextIntoInputWithTimeDelay(number, milliseconds, inputPhoneNumber);
    }

    public void enterTextIntoInputRegistrationEmail(String newEmail, Long milliseconds) {
        logger.info("Enter text in to input Registration Email " + newEmail);
        enterTextIntoInputWithTimeDelay(newEmail,milliseconds,inputRegistrationEmail);
    }

    public void enterTextIntoInputPassword(String password, Long milliseconds) {
        logger.info("Enter text in to input Password " + password);
        enterTextIntoInputWithTimeDelay(password, milliseconds, inputRegistrationPassword);
    }

    public void enterTextIntoInputPasswordConfirmation(String confirmPassword, Long milliseconds) {
        logger.info("Enter text in to input Password Confirmation " + confirmPassword);
        enterTextIntoInputWithTimeDelay(confirmPassword,milliseconds, inputConfirmRegistrationPassword);
    }

    public void clickOnButtonRegister() {
        logger.info("Click on button Register");
        clickOnElement(buttonRegister);
    }

    public boolean isConfirmedModalPresent() {
        logger.info("Is confirmed modal present: " + isElementDisplayed(confirmedModal));
        return isElementDisplayed(confirmedModal);
    }

    public HomePage openLoginPageAndFillLoginFormWithValidCred() {
        openLoginPage();
        clickOnButtonLoginAccount();
        enterTextInToInputEmail(TestData.EXIST_USER_EMAIL);
        enterTextInToInputPassword(TestData.EXIST_USER_PASSWORD);
        clickOnButtonLogIn();
        return new HomePage(webDriver);
    }

    public String generatePhoneNumber() {
        Random random = new Random();
        int secondPart = 100 + random.nextInt(900); // to ensure 3 digits
        int thirdPart = 10 + random.nextInt(900); // to ensure 2 digits
        int fourthPart = 10 + random.nextInt(90); // to ensure 2 digits
        return String.format("+38 (063) -%03d- %02d- %02d", secondPart, thirdPart, fourthPart);
    }

    public void clickOnSearchField() {
        logger.info("Click on Search field");
        clickOnElement(inputSearch);
    }

    public void openLoginPageAndClickOnSearchField(String textForSearch) {
        openLoginPage();
        clickOnSearchField();
        enterTextInToSearchField(textForSearch);
    }

    public void enterTextInToSearchField(String textForSearch) {
        logger.info("Enter text in to input Search - " + textForSearch);
        enterTextInToInput(inputSearch, textForSearch);
    }

    public void clickOnButtonSubmit() {
        logger.info("Click on button Submit");
        clickOnElement(buttonSubmit);
    }

    public boolean isSearchResultDisplayed() {
        checkIsElementVisible(searchResultField);
        return isElementDisplayed(searchResultField);
    }

    public void checkTextInSuccessMessage(String text) {
        checkTextInElement(searchResultMessage, text);
    }

    public LoginPage clickOnDropDownSelectValue (String text) {
        logger.info("Click on DropDown Select Value " + text);
        clickByVisibleMenuText(text);
        return this;
    }

    public LoginPage clickByYesButton() {
        logger.info ("Click by Product Catalog element");
        clickOnElement(buttonYes);
        return this;
    }
}
