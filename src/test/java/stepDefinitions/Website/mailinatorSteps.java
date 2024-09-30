package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static support.World.objMailinatorPage;


public class mailinatorSteps {

    @Given("user successfully register an account")
    public void player_successfully_register_an_account() {

    }

    @And("user gets OTP from the email for registration")
    public void user_gets_OTP_from_the_email_for_registration() throws InterruptedException {
       objMailinatorPage.getTheOTPfromEmailForRegistration();
    }

    @And("user gets OTP from the email for login")
    public void user_gets_OTP_from_the_email_for_login() throws InterruptedException {
        objMailinatorPage.getTheOTPfromEmailForLogin();
    }

    @And("user lands on password reset page by following link in email")
    public void user_lands_on_password_reset_page_by_following_link_in_email() {
   objMailinatorPage.checkPlayerLandsOnPasswordResetPageFromEmail();
    }


}
