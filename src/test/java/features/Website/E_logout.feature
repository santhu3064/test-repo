Feature: Logout flow

  @Portal @Logout
  Scenario Outline: Check if the user can successfully
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user should land on home page successfully
    And user clicks the options menu
    And user clicks sign out button
    Then user gets logged out successfully




    Examples:
      | TestVariableName |
      | TestVariableValue |
