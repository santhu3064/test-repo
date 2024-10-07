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
import static support.DeviceCreation.driver;
import static support.PropertiesReader.CompanyGSTIN;
import static support.PropertiesReader.CompanyPhoneTest;

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

    @FindBy(xpath = "//span[contains(text(), 'Retail')]")
    WebElement businessCategory;

    @FindBy(xpath = "//span[contains(text(), 'Create Company')]")
    WebElement createCompanyButton;


    public void enterGSTINAndClickOutsideToAutoPopulateData() throws InterruptedException {
        WebDriverHelper.waitUntilVisible(GSTINTextField, 15, 3);
        GSTINTextField.clear();
        GSTINTextField.sendKeys(CompanyGSTIN);
        companyName.sendKeys("");
        Thread.sleep(2000);
        assertEquals(CompanyPhoneTest, companyPhone.getAttribute("value"));
    }

    public void selectBusinessTypeAndCategoryAndClickCreateCompany() throws InterruptedException {
        Select businesstypedropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'data.business_type_id')]")));
        businesstypedropdown.selectByVisibleText("Footwear");
        businessCategory.click();
        createCompanyButton.click();
    }


}
