package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogin extends Page {

    @FindBy(id = "loginFrm_loginname")
    private WebElement fillLoginName;
    @FindBy(id = "loginFrm_password")
    private WebElement fillPassword;
    @FindBy(xpath = "//button[@title='Login']")
    private WebElement submitLoginButton;
    @FindBy(xpath = "//div[contains(@class,'alert-error')]")
    private WebElement alertLogin;
    @FindBy(xpath = "//a[contains(@href,'account/forgotten/password')]")
    private WebElement forgotYourPassword;
    @FindBy(xpath = "//a[contains(@href,'account/forgotten/loginname')]")
    private WebElement forgotYourLogin;
    @FindBy(id = "forgottenFrm_email")
    private WebElement fieldEmailAddress;
    @FindBy(id = "forgottenFrm_loginname")
    private WebElement fieldForgottenLoginName;
    @FindBy(xpath = "//button[@title='Continue']")
    private WebElement resetContinueButton;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successAlert;
    @FindBy(id = "forgottenFrm_lastname")
    private WebElement lastName;


    public void logIn(String usernameValue, String passwordValue) {
        fillLoginName.sendKeys(usernameValue);
        fillPassword.sendKeys(passwordValue);
        submitLoginButton.click();
    }
    public void fillOutLoginName(String loginName) {
        fillLoginName.sendKeys(loginName);
    }
    public void clickLoginButton() {
        submitLoginButton.click();
    }
    public String getAlertLogin() {
        return alertLogin.getText();
    }
    public void functionalityFillPassword(String password) {
        fillPassword.sendKeys(password);
    }
    public String getEmptyPassword() {
        return fillPassword.getText();
    }
    public void clickForgotPassword() {
        forgotYourPassword.click();
    }
    public void clickForgotLogin() {
        forgotYourLogin.click();
    }
    public void fillOutEmail(String eMail) {
        fieldEmailAddress.sendKeys(eMail);
    }
    public void fillOutForgottenLoginName(String loginName) {
        fieldForgottenLoginName.sendKeys(loginName);
    }
    public void clickResetContinue() {
        resetContinueButton.click();
    }
    public String getSuccessAlertLogin() {
        return successAlert.getText();
    }
    public void fillOutLastName(String firstName) {
        lastName.sendKeys(firstName);
    }
}
