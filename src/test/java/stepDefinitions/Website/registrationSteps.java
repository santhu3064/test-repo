package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static support.World.objMailinatorPage;
import static support.World.objRegistrationPage;

public class registrationSteps {

    @Given("user lands on registration page by clicking the try InstaBee free button")
    public void user_lands_on_registration_page_by_clicking_the_try_InstaBee_free_button() {
    objRegistrationPage.landOnRegistrationPage();
    }


    @And("user enters the name")
    public void user_enters_the_name() {
    objRegistrationPage.enterRegName();
    }



    @And("user enters the email")
    public void user_enters_the_email() {
        objRegistrationPage.enterRegEmail();
    }



    @And("user enters the mobile")
    public void user_enters_the_mobile() {
objRegistrationPage.enterRegMobile();
    }



    @And("user enters the password")
    public void user_enters_the_password() {
objRegistrationPage.enterRegPassword();
    }



    @And("user enters the confirm password")
    public void user_enters_the_confirm_password() {
objRegistrationPage.enterRegConfirmPassword();
    }

    @And("user hit submit registration button")
    public void user_hit_submit_registration_button() throws IOException {
    objRegistrationPage.submitRegistration();
    }


    @And("user lands on the 2FA page")
    public void user_lands_on_the_2FA_page() {
objRegistrationPage.checkPlayerLandsOnVerificationpage();
    }


    @And("user enters the OTP and hit submit")
    public void user_enters_the_OTP_and_hit_submit() throws InterruptedException {
    objRegistrationPage.submitOTP();
    }


}
