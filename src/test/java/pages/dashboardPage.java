package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.WebDriverHelper;

import static org.testng.AssertJUnit.assertEquals;
import static support.PropertiesReader.CompanyNameTest;

public class dashboardPage {
    public dashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(), \"Dashboard\")]")
    WebElement dashboardPageTitle;

    @FindBy(xpath = "//button[contains(@class, 'fi-tenant-menu')]")
    WebElement menuOnLeftNav;


    public void checkUserLandsOnDashbaord() {
        WebDriverHelper.waitUntilVisible(dashboardPageTitle, 15, 3);
    }

    public void checkCompanyNameShownOnLeftNav() {
        WebDriverHelper.waitUntilVisible(menuOnLeftNav, 15, 3);
        assertEquals(CompanyNameTest, menuOnLeftNav.getText());
    }
}
