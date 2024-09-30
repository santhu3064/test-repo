Feature: Forgot password flow

  @Portal @ForgotPassword
  Scenario Outline: Check if the user can change password successfully through forgot password flow
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user clicks forgot password link
    And user lands on forgot password rest email sending page
    And user enters emails and hit submit
    And password reset email sent successfully
    And user lands on password reset page by following link in email
    And user enters email, password and confirm password on password reset page
    And user clicks reset password button
    Then player lands on login page and password reset successfully message is shown
    And user enters email on the login page
    And user enters new password on the login page
    And user clicks submit login button on the login page
    Then user should land on home page successfully


    Examples:
      | TestVariableName |
      | TestVariableValue |
