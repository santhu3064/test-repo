package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import support.WebDriverHelper;

import static support.DeviceCreation.driver;
import static support.World.objLoginPage;


public class loginSteps {

    @Given("user launches the InstaBee portal on browser")
    public void user_launches_the_InstaBee_portal_on_browser() throws InterruptedException {
        objLoginPage.instaBeeWebLaunch();
        WebDriverHelper.waitUntilPageCompletelyLoad();
    }

    @Then("user lands on login page by clicking the login button")
    public void user_lands_on_login_page_by_clicking_the_login_button() {
       objLoginPage.landOnLoginPage();
    }

    @And("user enters email on the login page")
    public void user_enters_email_on_the_login_page() {
        objLoginPage.enterEmailOnLoginPage();
    }

    @And("user enters the updated email on the login page")
    public void user_enters_the_updated_email_on_the_login_page() {
        objLoginPage.enterUpdatedEmailOnTheLoginPage();
    }

    @And("user enters password on the login page")
    public void user_enters_password_on_the_login_page() {
        objLoginPage.enterPasswordOnLoginpage();
    }

    @And("user enters new password on the login page")
    public void user_enters_new_password_on_the_login_page() {
        objLoginPage.enterNewPasswordOnLoginpage();
    }

    @And("user clicks submit login button on the login page")
    public void user_clicks_submit_login_button_on_the_login_page() {
        objLoginPage.clickSumbitOnLoginpage();
    }

    @Then("user should land on home page successfully")
    public void user_should_land_on_home_page_successfully() {
      objLoginPage.checkIfUserLoggedInSuccessfully();
    }

    @Then("user clicks the gmail login button")
    public void user_clicks_the_gmail_login_button() {
objLoginPage.clickGmailLoginButton();
    }

    @Then("user enters the gmail email and hit next")
    public void user_enters_the_gmail_email_and_hit_next() {
objLoginPage.enterGmailEmail();
    }


    @Then("user enters the gmail password")
    public void user_enters_the_gmail_password() {
objLoginPage.enterGmailPassword();
    }


    @Then("user hit submit")
    public void user_hit_submit() {
objLoginPage.submitGmailLogin();
    }

    @And("user clicks the login with OTP button")
    public void user_clicks_the_login_with_OTP_button() {
objLoginPage.clickLoginWithOTPButton();
    }

    @And("user enters the valid phone number registered with the player and hit verify")
    public void user_enters_the_valid_phone_number_registered_with_the_player_and_hit_verify() throws InterruptedException {
objLoginPage.submitMobileOTPReceived();
    }

    @And("user click enable 2FA button")
    public void user_click_enable_2FA_button() {
objLoginPage.clickEnabletwoFAButton();
    }


    @And("user enter password to confirm 2FA popup")
    public void user_enter_password_to_confirm_2FA_popup() {
objLoginPage.enterPasswordOnTwoFAConfirmPopup();
    }



    @And("user hit submit button to confirm 2FA popup")
    public void user_hit_submit_button_to_confirm_2FA_popup() throws InterruptedException {
objLoginPage.clickSubmitOnTwoFAConfirmPopup();
    }

    @Then("user is show with QA code, field to enter the auth code and confirm button")
    public void user_is_show_with_QA_code_field_to_enter_the_auth_code_and_confirm_button() {
objLoginPage.checkUserAskedToAuthUsingQACode();
    }



}
