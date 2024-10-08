Feature: Update company settings flow

  @Portal @CompanySettings @Company
  Scenario Outline: Check if the company settings page is loaded with all sections and user can update company settings successfully
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user lands on dashboard
    And user lands on company settings page
    And all the sections on company settings page are loaded
    And user can update the company settings successfully





    Examples:
      | TestVariableName |
      | TestVariableValue |