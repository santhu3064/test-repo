Feature: Change password from profile page

   @Portal @ChangePassword
  Scenario Outline: Check if the user can change password from profile page and re-login with new password
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user should land on home page successfully
    And user clicks the options menu
    And user opens the profile page
    And user enters the current password on update password section
    And user enters the new password on update password section
    And user enters the confirm password on the update password section
    And user hits save button
     And user clicks the options menu
     And user clicks logout link
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters new password on the login page
    And user clicks submit login button on the login page
    Then user should land on home page successfully







    Examples:
      | TestVariableName |
      | TestVariableValue |