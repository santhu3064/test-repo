package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

import java.util.ArrayList;

import static support.DeviceCreation.driver;
import static support.PropertiesReader.NewRegisterUserEmail;
import static support.PropertiesReader.yopMail_url;
import static support.World.objRegistrationPage;


public class mailinatorPage {

    public static String OTPfull;
    public mailinatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ycptinput")
    WebElement emailSearch;

    @FindBy(id = "refreshbut")
    WebElement emailSearchSubmit;

    @FindBy(id = "ifmail")
    WebElement mailIframe;

    @FindBy(xpath = "//p[contains(@class, 'fc-button-label') and text() = 'Consent']")
    WebElement giveConsentToCookiePopup;

    @FindBy(xpath = "//p[contains(text(),'verification code')]")
    WebElement verificationCodeExtract;

    public void getTheOTPfromEmailForRegistration() throws InterruptedException {
        getTheOTPfromEmail(objRegistrationPage.emailAddress);
    }

    public void getTheOTPfromEmailForLogin() throws InterruptedException {
        getTheOTPfromEmail(NewRegisterUserEmail);
    }
    public void getTheOTPfromEmail(String email) throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(yopMail_url);
        WebDriverHelper.waitUntilPageCompletelyLoad();
        if (driver.findElements(By.xpath("//p[contains(@class, 'fc-button-label') and text() = 'Consent']")).size()>0){
            giveConsentToCookiePopup.click();
        }
        Thread.sleep(3000);
        WebDriverHelper.waitUntilVisible(emailSearch, 30, 5);
        emailSearch.sendKeys(email);
        emailSearchSubmit.click();
        WebDriverHelper.waitUntilVisible(mailIframe, 30, 5);
        driver.switchTo().frame(mailIframe);
        OTPfull = verificationCodeExtract.getText().substring(verificationCodeExtract.getText().length() -6);
        driver.switchTo().window(tabs.get(0));
        WebDriverHelper.waitUntilPageCompletelyLoad();
    }


    public void checkPlayerLandsOnPasswordResetPageFromEmail() {
    }
}
