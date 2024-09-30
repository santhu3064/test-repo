package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

public class logoutPage {
    public logoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[contains(@src,'ui-avatars.com')]")
    WebElement menuOptionsButton;

    @FindBy(xpath = "//span[contains(text(), \"Sign out\")]")
    WebElement signOutButton;

    @FindBy(xpath = "//a[contains(@href,'logout')]")
    WebElement logOutButtonLink;

    @FindBy(xpath = "//a[contains(@href,'login')]")
    WebElement login;

    public void clickOnOptionsMenu() {
        WebDriverHelper.waitUntilVisible(menuOptionsButton, 15, 5);
        menuOptionsButton.click();
    }

    public void clickOnSignOutOption() {
        WebDriverHelper.waitUntilVisible(signOutButton, 15, 3);
        signOutButton.click();
    }

    public void checkIfUserLoggedOut() {
        WebDriverHelper.waitUntilVisible(login, 15, 5);
    }

    public void clickLogoutLink() {
        WebDriverHelper.waitUntilVisible(logOutButtonLink, 10, 3);
        logOutButtonLink.click();
    }
}

