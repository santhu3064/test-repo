package stepDefinitions.Website;

import io.cucumber.java.en.And;

import static support.World.objCompanyPage;
import static support.World.objDashboardPage;

public class dashboardSteps {
    @And("user lands on dashboard")
    public void user_lands_on_dashboard() {
        objDashboardPage.checkUserLandsOnDashbaord();
    }

    @And("user lands on company settings page")
    public void user_lands_on_company_settings_page() throws InterruptedException {
        objDashboardPage.openCompanySettingsPage();
    }

}
