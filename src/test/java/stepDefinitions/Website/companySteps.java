package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.DeviceCreation.driver;
import static support.World.objCompanyPage;
import static support.World.objDashboardPage;

public class companySteps {
    @And("user enters the GSTIN value and observe all the details are auto populated")
    public void user_enters_the_GSTIN_value_and_observe_all_the_details_are_auto_populated() throws InterruptedException {
     objCompanyPage.enterGSTINAndClickOutsideToAutoPopulateData();
    }


    @And("select name, business type and business category and click create company")
    public void select_name_business_type_and_business_category_and_click_next_and_click_create_company() throws InterruptedException {
     objCompanyPage.selectNameBusinessTypeAndCategoryAndClickCreateCompany();
    }

    @And("user lands on dashboard")
    public void user_lands_on_dashboard() {
    objDashboardPage.checkUserLandsOnDashbaord();
    }



    @Then("company created is displayed on left navigation options on dashboard page")
    public void company_created_is_displayed_on_left_navigation_options_on_dashboard_page() throws InterruptedException {
objDashboardPage.checkCompanyNameShownOnLeftNav();
    }


}
