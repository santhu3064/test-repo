Feature: 2FA login flow

  @Portal @2FALogin @Profile
  Scenario Outline: Check if the user can use 2FA login feature by toggle ON from profile page. Also can disable the same from profile page
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    Then user should land on home page successfully
    And user clicks the options menu
    And user opens the profile page
    And user click enable 2FA button
    And user enter password to confirm 2FA popup
    And user hit submit button to confirm 2FA popup
    Then user is show with QA code, field to enter the auth code and confirm button



    Examples:
      | TestVariableName |
      | TestVariableValue |
