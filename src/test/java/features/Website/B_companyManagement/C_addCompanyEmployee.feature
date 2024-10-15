Feature: Validate the company employees addition flow

  @Portal @CompanyEmployeeAddition @Company
  Scenario Outline: Check if the user can add the employees to the company with specific roles
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user lands on dashboard
    And user lands on company settings page



    Examples:
      | TestVariableName |
      | TestVariableValue |