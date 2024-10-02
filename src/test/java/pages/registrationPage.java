package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static support.DeviceCreation.driver;
import static support.PropertiesReader.Password;

public class registrationPage {

    Properties props = new Properties();

    @FindBy(xpath = "//a[contains(@href,\"register\")]")
    WebElement registerButton;

    @FindBy(xpath = "//a[contains(@href,\"login\")]")
    WebElement registrationPageTitleCheck;

    @FindBy(id = "name")
    WebElement regName;

    @FindBy(id = "email")
    WebElement regEmail;

    @FindBy(id = "mobile_phone")
    WebElement regMobile;

    @FindBy(id = "password")
    WebElement regPassword;

    @FindBy(id = "password_confirmation")
    WebElement regConfirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement regSubmitButton;

    @FindBy(xpath = "//button[contains(text(),'Not received code? Click here')]")
    WebElement verificationCodepageCheck;

    @FindBy(id = "codeIndex_0")
    WebElement OTP;


    public final String emailAddress = "auto" + WebDriverHelper.getRandomAlphanumericEmailString(5, "@yopmail.com").toLowerCase();
    private final String mobileNumber = "9"+ WebDriverHelper.getRandomNumeric(9);

    public registrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void landOnRegistrationPage() {
     registerButton.click();
        WebDriverHelper.waitUntilVisible(registrationPageTitleCheck, 15, 5);
    }

    public void enterRegName() {
        regName.sendKeys("Mad Max Test");
    }

    public void enterRegEmail() {
     regEmail.sendKeys(emailAddress);
    }


    public void enterRegMobile() {
        regMobile.sendKeys(mobileNumber);
    }

    public void enterRegPassword() {
        regPassword.sendKeys(Password);
    }


    public void enterRegConfirmPassword() {
        regConfirmPassword.sendKeys(Password);
    }

    public void submitRegistration() throws IOException {
        WebDriverHelper.waitUntilClickable(regSubmitButton, 15, 5);
        regSubmitButton.click();

        //Data Entry to CommonData
        FileInputStream in1 = new FileInputStream("data/commonData.properties");
        props.load(in1);
        in1.close();
        FileOutputStream out1 = new FileOutputStream("data/commonData.properties");
        props.setProperty("NewRegisterUserEmail", emailAddress);
        props.setProperty("NewRegisterMobileNumber", mobileNumber);
        props.store(out1, null);
        out1.close();
    }

    public void checkPlayerLandsOnVerificationpage() {
        WebDriverHelper.waitUntilVisible(verificationCodepageCheck, 15, 5);
    }

    public void submitOTP() throws InterruptedException {
        OTP.sendKeys(mailinatorPage.OTPfull);
        }
    }


