package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

import static support.PropertiesReader.*;

public class passwordReset {

    public passwordReset(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'user/profile')]")
    WebElement profilePageButton;

    @FindBy(id = "current_password")
    WebElement currentPasswordField;

    @FindBy(id = "password")
    WebElement newPasswordField;

    @FindBy(id = "password_confirmation")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//h3[contains(text(), \"Two Factor Authentication\")]/preceding::button[1]")
    WebElement saveChangePasswordButton;

    @FindBy(xpath = "//a[contains(@href,'forgot-password')]")
    WebElement forgotPasswordLink;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(xpath = "//button[contains(text(),'Email Password Reset')]")
    WebElement sendPasswordResetEmailButton;

    @FindBy(xpath = "//button[contains(text(),'Email Password Reset')]")
    WebElement passwordRestEmailSentConfirmationMessage;

    @FindBy(xpath = "//button[contains(text(),'Reset Password')]")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//div[contains(text(),'Your password has been')]")
    WebElement passwordRestConfirmationMessageOnLoginPage;


    public void openProfilePage() {
        WebDriverHelper.waitUntilVisible(profilePageButton, 15, 5);
        profilePageButton.click();
    }

    public void enterCurrentPassword() {
        WebDriverHelper.waitUntilPageCompletelyLoad();
        currentPasswordField.sendKeys(NewPassword);
    }

    public void enterNewPassword() {
        newPasswordField.sendKeys(Password);
    }

    public void enterConfirmPassword() {
        confirmPasswordField.sendKeys(Password);
    }

    public void clickSaveChangePasswordButton()  {
        WebDriverHelper.scrollToElement(saveChangePasswordButton);
        saveChangePasswordButton.click();
        WebDriverHelper.scrollToTopOfThePage();
    }

    public void clickOnForgotPasswordLink() {
        WebDriverHelper.waitUntilVisible(forgotPasswordLink, 15, 3);
        forgotPasswordLink.click();
    }

    public void checkUserLandsOnForgotPasswordEmailSendingPage() {
        WebDriverHelper.waitUntilVisible(sendPasswordResetEmailButton, 15, 3);
    }

    public void enterEmailAndClickSubmit() {
        email.sendKeys(NewRegisterUserEmail);
        sendPasswordResetEmailButton.click();
    }

    public void checkPasswordResetEmailSentSuccessfully() {
      WebDriverHelper.waitUntilVisible(passwordRestEmailSentConfirmationMessage, 15, 3);
    }

    public void enterDetailsOnPasswordResetPage() {
        WebDriverHelper.waitUntilVisible(email, 15, 3);
        newPasswordField.sendKeys(NewPassword);
        confirmPasswordField.sendKeys(NewPassword);
    }

    public void clickRestPasswordButton() {
        WebDriverHelper.waitUntilClickable(resetPasswordButton, 15, 3);
        resetPasswordButton.click();
    }

    public void checkPlayerLandsOnLoginPageWithPasswordResetMessage() {
        WebDriverHelper.waitUntilVisible(passwordRestConfirmationMessageOnLoginPage, 15, 3);
    }
}
