package pages;

import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.WebDriverHelper;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static support.DeviceCreation.driver;
import static support.PropertiesReader.*;

public class companyPage {
    public companyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[contains(@id,'data.GSTIN')]")
    WebElement GSTINTextField;

    @FindBy(xpath = "//input[contains(@id,'data.name')]")
    WebElement companyName;

    @FindBy(xpath = "//input[contains(@id,'data.phone')]")
    WebElement companyPhone;

    @FindBy(xpath = "//input[contains(@id,'data.email')]")
    WebElement companyEmail;

    @FindBy(xpath = "//span[contains(text(), 'Retail')]")
    WebElement businessCategoryRetail;

    @FindBy(xpath = "//span[contains(text(), 'Service')]")
    WebElement businessCategoryService;

    @FindBy(xpath = "//span[contains(text(), 'Create Company')]")
    WebElement createCompanyButton;

    @FindBy(xpath = "//h3[contains(text(), 'Company Name')]")
    WebElement companyDetailsSectionHeading;

    @FindBy(xpath = "//h3[contains(text(), 'Add Company Employee')]")
    WebElement employeeDetailsSectionHeading;

    @FindBy(xpath = "//input[@id='name' and contains(@class, 'fi-input')]")
    WebElement companyNameOnSettings;

    @FindBy(xpath = "//textarea[contains(@id,'data.address')]")
    WebElement addressOnCompanySettings;

    @FindBy(xpath = "//input[contains(@id,'data.debit_balance')]")
    WebElement debitBalanceOnSettings;

    @FindBy(xpath = "//input[contains(@id,'data.credit_balance')]")
    WebElement creditBalanceOnSettings;

    @FindBy(xpath = "(//span[contains(text(), 'Save')])[1]")
    WebElement saveCompanyNameOnSettingsButton;
    @FindBy(xpath = "(//span[contains(text(), 'Save')])[2]")
    WebElement saveCompanySettingsButton;

    public void enterGSTINAndClickOutsideToAutoPopulateData() throws InterruptedException {
        WebDriverHelper.waitUntilVisible(GSTINTextField, 15, 3);
        GSTINTextField.clear();
        GSTINTextField.sendKeys(CompanyGSTIN);
        companyName.sendKeys("");
        Thread.sleep(2000);
        assertEquals(CompanyPhoneTest, companyPhone.getAttribute("value"));
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    public void selectNameBusinessTypeAndCategoryAndClickCreateCompany() throws InterruptedException {
        companyName.sendKeys("Furiosa");
        Select businessTypeDropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.business_type_id')]")));
        businessTypeDropdown.selectByVisibleText("Footwear");
        businessCategoryRetail.click();
        createCompanyButton.click();
    }

    public void validateSectionsOnCompanySettingsPage() {
        WebDriverHelper.waitUntilVisible(companyDetailsSectionHeading, 15, 3);
        WebDriverHelper.waitUntilVisible(employeeDetailsSectionHeading, 15, 3);
    }

    public void updateCompanySettings() throws InterruptedException {
        companyNameOnSettings.clear();
        companyNameOnSettings.sendKeys(CompanyNameTest);

        saveCompanyNameOnSettingsButton.click();
        WebDriverHelper.waitUntilInvisibilityOfElementLocated("//h3[contains(text(), 'Company updated')]");
        WebDriverHelper.scrollToElement(companyPhone);
        companyPhone.clear();
        companyPhone.sendKeys(CompanyPhoneTest);

        companyEmail.clear();
        companyEmail.sendKeys(CompanyEmailTest);

        businessCategoryService.click();

        Select businessTypeDropdownUpdate = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.business_type_id')]")));
        businessTypeDropdownUpdate.selectByVisibleText("Furniture");
        Select stateDropdownUpdate = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.state_id')]")));
        stateDropdownUpdate.selectByVisibleText(CompanyStateTest);

        addressOnCompanySettings.sendKeys(CompanyAddressTest);
        creditBalanceOnSettings.clear();
        creditBalanceOnSettings.sendKeys("100");
        debitBalanceOnSettings.clear();
        debitBalanceOnSettings.sendKeys("200");
        Thread.sleep(5000);
        saveCompanySettingsButton.click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        assertEquals(CompanyNameTest, companyNameOnSettings.getAttribute("value"));
        assertEquals(CompanyPhoneTest, companyPhone.getAttribute("value"));
        assertEquals(CompanyEmailTest, companyEmail.getAttribute("value"));
        /*
        assertTrue(businessCategoryService.isSelected());
        Select businessTypeDropdownUpdateValidation = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.business_type_id')]")));
        assertEquals("Furniture", businessTypeDropdownUpdateValidation.getFirstSelectedOption().getText());
        Select stateDropdownUpdateValidation = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.state_id')]")));
        assertEquals(CompanyStateTest, stateDropdownUpdateValidation.getFirstSelectedOption().getText());
        assertTrue(addressOnCompanySettings.getAttribute("value").contains("Hyderabad"));
         */
        assertEquals("100.00", creditBalanceOnSettings.getAttribute("value"));
        assertEquals("200.00", debitBalanceOnSettings.getAttribute("value"));
    }
}
