package stepDefinitions.Website;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static support.World.objPasswordReset;


public class passwordResetSteps {
    @And("user opens the profile page")
    public void user_opens_the_profile_page() {
   objPasswordReset.openProfilePage();
    }



    @And("user enters the current password on update password section")
    public void user_enters_the_current_password_on_update_password_section() {
objPasswordReset.enterCurrentPassword();
    }



    @And("user enters the new password on update password section")
    public void user_enters_the_new_password_on_update_password_section() {
objPasswordReset.enterNewPassword();
    }


    @And("user enters the confirm password on the update password section")
    public void user_enters_the_confirm_password_on_the_update_password_section() {
objPasswordReset.enterConfirmPassword();
    }

    @And("user hits save button")
    public void user_hits_save_button() {
objPasswordReset.clickSaveChangePasswordButton();
    }

    @And("user clicks forgot password link")
    public void user_clicks_forgot_password_link() {
        objPasswordReset.clickOnForgotPasswordLink();
    }


    @And("user lands on forgot password rest email sending page")
    public void user_lands_on_forgot_password_rest_email_sending_page() {
       objPasswordReset.checkUserLandsOnForgotPasswordEmailSendingPage();
    }


    @And("user enters emails and hit submit")
    public void user_enters_emails_and_hit_submit() {
       objPasswordReset.enterEmailAndClickSubmit();
    }


    @And("password reset email sent successfully")
    public void password_reset_email_sent_successfully() {
       objPasswordReset.checkPasswordResetEmailSentSuccessfully();
    }



    @And("user enters email, password and confirm password on password reset page")
    public void user_enters_email_password_and_confirm_password_on_password_reset_page() {
       objPasswordReset.enterDetailsOnPasswordResetPage();
    }



    @And("user clicks reset password button")
    public void user_clicks_reset_password_button() {
        objPasswordReset.clickRestPasswordButton();
    }


    @Then("player lands on login page and password reset successfully message is shown")
    public void player_lands_on_login_page_and_password_reset_successfully_message_is_shown() {
        objPasswordReset.checkPlayerLandsOnLoginPageWithPasswordResetMessage();
    }




}
