package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;
import static support.DeviceCreation.driver;


public class profilePage {

    Properties props = new Properties();
    public final String newProfilename=WebDriverHelper.getRandomAlphabeticString(5);
    public final String newProfileEmail = "auto" + WebDriverHelper.getRandomAlphanumericEmailString(5, "@yopmail.com").toLowerCase();
    public final String newPhone = "9" + WebDriverHelper.getRandomNumeric(9);

    public profilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), \"Profile\")]")
    WebElement profilePageLoadCheck;

    @FindBy(xpath = "//h3[contains(text(), \"Profile Information\")]")
    WebElement profileInfoSectionCheck;

    @FindBy(xpath = "//h3[contains(text(), \"Update Password\")]")
    WebElement changePasswordSectionCheck;

    @FindBy(xpath = "//h3[contains(text(), \"Two Factor Authentication\")]")
    WebElement twoFASectionCheck;

    @FindBy(xpath = "//h3[contains(text(), \"Browser Sessions\")]")
    WebElement browserSessionsSectionCheck;

    @FindBy(xpath = "//h3[contains(text(), \"Delete Account\")]")
    WebElement deleteAccountSectionCheck;

    @FindBy(id = "name")
    WebElement profileName;

    @FindBy(id = "email")
    WebElement profileEmail;

    @FindBy(id = "mobile_phone")
    WebElement profilePhone;

    @FindBy(xpath = "//h3[contains(text(), \"Update Password\")]/preceding::button[1]")
    WebElement savePersonalInfoUpdateButton;

    public void checkProfilePageLoading() {
        WebDriverHelper.waitUntilVisible(profilePageLoadCheck, 15, 3);
    }

    public void checkProfileUpdateSectionPresent() {
        WebDriverHelper.waitUntilVisible(profileInfoSectionCheck, 15, 3);
    }

    public void checkTwoFaSectionPresent() {
        WebDriverHelper.waitUntilVisible(twoFASectionCheck, 15, 3);
    }

    public void checkBrowserSessionSectionPresent() {
        WebDriverHelper.waitUntilVisible(browserSessionsSectionCheck, 15, 3);
    }

    public void checkDeleteAccountSectionPresent() {
        WebDriverHelper.waitUntilVisible(deleteAccountSectionCheck, 15, 3);
    }

    public void checkPersonalInfoIsUpdated() throws InterruptedException, IOException {
        profileName.clear();
        profileName.sendKeys(newProfilename);
        profileEmail.clear();
        profileEmail.sendKeys(newProfileEmail);
        profilePhone.clear();
        profilePhone.sendKeys(newPhone);
        WebDriverHelper.waitUntilClickable(savePersonalInfoUpdateButton,15, 3);
        savePersonalInfoUpdateButton.click();
        Thread.sleep(3000);


        //Data Entry to CommonData
        FileInputStream in1 = new FileInputStream("data/commonData.properties");
        props.load(in1);
        in1.close();
        FileOutputStream out1 = new FileOutputStream("data/commonData.properties");
        props.setProperty("NewRegisterUserEmail", newProfileEmail);
        props.setProperty("NewRegisterMobileNumber", newPhone);
        props.store(out1, null);
        out1.close();


        driver.navigate().refresh();
        Thread.sleep(3000);
        assertEquals(newProfilename, profileName.getAttribute("value"));
        assertEquals(newProfileEmail, profileEmail.getAttribute("value"));
        assertEquals(newPhone, profilePhone.getAttribute("value"));
    }
}
