package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static support.World.objLogoutPage;

public class logoutSteps {
    @And("user clicks the options menu")
    public void user_clicks_the_options_menu() {
        objLogoutPage.clickOnOptionsMenu();
    }



    @And("user clicks sign out button")
    public void user_clicks_sign_out_button() {
    objLogoutPage.clickOnSignOutOption();
    }


    @And("user clicks logout link")
    public void user_clicks_logout_link() {
        objLogoutPage.clickLogoutLink();
    }

    @Then("user gets logged out successfully")
    public void user_gets_logged_out_successfully() {
     objLogoutPage.checkIfUserLoggedOut();
    }



}
