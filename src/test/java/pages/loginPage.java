package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

import static support.DeviceCreation.driver;
import static support.PropertiesReader.*;
import static support.World.objProfilePage;
import static support.World.objRegistrationPage;


public class loginPage {

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'login')]")
    WebElement login;

    @FindBy(name = "email")
    WebElement loginEmail;

    @FindBy(name = "password")
    WebElement loginPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitLogin;

    @FindBy(xpath = "//h1[contains(text(), \"Create Company\")]")
    WebElement homePageAfterRegistrationCheck;

    @FindBy(xpath = "//a[contains(@href,'auth/login/google')]")
    WebElement gmailLoginButton;

    @FindBy(id = "identifierId")
    WebElement gmailEmailField;

    @FindBy(xpath = "//span[contains(text(), \"Next\")]")
    WebElement gmailNextButton;

    @FindBy(name = "Passwd")
    WebElement gmailPassword;

    @FindBy(xpath = "//a[contains(@href,'otp/login')]")
    WebElement loginWithOTPButton;

    @FindBy(id = "mobile_phone")
    WebElement mobileOTPField;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    WebElement verifyMobileOTPButton;


    @FindBy(xpath = "//button[contains(text(),'Allow cookies')]")
    WebElement allowCookiesButton;

    @FindBy(xpath = "//button[contains(text(),'Enable')]")
    WebElement twoFAEnableButton;

    @FindBy(xpath = "//div[contains(text(),'For your')]//input")
    WebElement twoFAConfirmationPassword;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement twoFAConfirmationButton;

    @FindBy(xpath = "//div[contains(@class, 'inline-block bg-white')]")
    WebElement QRCodefor2FA;

    @FindBy(id = "code")
    WebElement authenticatorCodeField;


    public void instaBeeWebLaunch() throws InterruptedException {
        driver.get(platform_url);
        WebDriverHelper.waitUntilPageCompletelyLoad();
        Thread.sleep(3000);
        if (driver.findElements(By.xpath("//button[contains(text(),'Allow cookies')]")).size()>0){
            allowCookiesButton.click();
        }
    }

    public void landOnLoginPage() {
     login.click();
     WebDriverHelper.waitUntilVisible(loginEmail, 15, 5);
    }

    public void enterEmailOnLoginPage() {
        loginEmail.sendKeys(NewRegisterUserEmail);
    }

    public void enterPasswordOnLoginpage() {
        loginPassword.sendKeys(Password);
    }

    public void enterNewPasswordOnLoginpage() {
        loginPassword.sendKeys(NewPassword);
    }

    public void clickSumbitOnLoginpage() {
        WebDriverHelper.waitUntilClickable(submitLogin, 15, 3);
        submitLogin.click();
    }

    public void checkIfUserLoggedInSuccessfully() {
        WebDriverHelper.waitUntilVisible(homePageAfterRegistrationCheck, 15, 5);
    }

    public void clickGmailLoginButton() {
        WebDriverHelper.waitUntilVisible(gmailLoginButton, 15, 5);
        gmailLoginButton.click();
    }

    public void enterGmailEmail() {
        WebDriverHelper.waitUntilVisible(gmailEmailField, 15, 5);
        gmailEmailField.sendKeys("instabee289@gmail.com");
        gmailNextButton.click();
    }

    public void enterGmailPassword() {
WebDriverHelper.waitUntilVisible(gmailPassword, 15, 5);
gmailPassword.sendKeys("InstaBee123!");
    }


    public void submitGmailLogin() {
        gmailNextButton.click();
    }

    public void clickLoginWithOTPButton() {
        WebDriverHelper.waitUntilVisible(loginWithOTPButton, 15, 5);
        loginWithOTPButton.click();
    }

    public void submitMobileOTPReceived() throws InterruptedException {
        WebDriverHelper.waitUntilVisible(mobileOTPField, 15, 5);
        mobileOTPField.sendKeys(NewRegisterMobileNumber);
        verifyMobileOTPButton.click();
        WebDriverHelper.waitUntilVisible(objRegistrationPage.verificationCodepageCheck, 10, 3);
    }


    public void enterUpdatedEmailOnTheLoginPage() {
        loginEmail.sendKeys(objProfilePage.newProfileEmail);
    }

    public void clickEnabletwoFAButton() {
        WebDriverHelper.waitUntilVisible(twoFAEnableButton, 15, 3);
        twoFAEnableButton.click();
    }

    public void enterPasswordOnTwoFAConfirmPopup() {
        WebDriverHelper.waitUntilVisible(twoFAConfirmationPassword, 15, 3);
        twoFAConfirmationPassword.sendKeys(Password);
    }

    public void clickSubmitOnTwoFAConfirmPopup() throws InterruptedException {
        twoFAConfirmationButton.click();
        Thread.sleep(5000);
    }

    public void checkUserAskedToAuthUsingQACode() {
        WebDriverHelper.waitUntilVisible(QRCodefor2FA, 15, 3);
        WebDriverHelper.waitUntilVisible(authenticatorCodeField, 15, 3);
    }
}
