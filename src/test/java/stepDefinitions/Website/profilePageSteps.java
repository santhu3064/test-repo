package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static support.World.objProfilePage;

public class profilePageSteps {
    @Then("profile info section is present on profile page")
    public void profile_info_section_is_present_on_profile_page() {
        objProfilePage.checkProfilePageLoading();
    }


    @And("update password section is present on profile page")
    public void update_password_section_is_present_on_profile_page() {
          objProfilePage.checkProfileUpdateSectionPresent();
    }


    @And("2FA section is present on profile page")
    public void twofa_section_is_present_on_profile_page() {
        objProfilePage.checkTwoFaSectionPresent();
    }


    @And("broswer sessions section is present on profile page")
    public void broswer_sessions_section_is_present_on_profile_page() {
objProfilePage.checkBrowserSessionSectionPresent();
    }


    @And("delete account section is present on profile page")
    public void delete_account_section_is_present_on_profile_page() {
objProfilePage.checkDeleteAccountSectionPresent();
    }


    @And("user updates profile information on profile info section")
    public void user_updates_profile_information_on_profile_info_section() throws InterruptedException, IOException {
objProfilePage.checkPersonalInfoIsUpdated();
    }

}
