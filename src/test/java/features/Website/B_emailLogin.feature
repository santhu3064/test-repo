Feature: Email login flow

  @Portal @Login
  Scenario Outline: Check if the user can login using the email & password successfully
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    Then user should land on home page successfully


    Examples:
      | TestVariableName |
      | TestVariableValue |
