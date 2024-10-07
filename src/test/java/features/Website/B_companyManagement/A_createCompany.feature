Feature: Create company flow

  @Portal @CreateCompany @Company
  Scenario Outline: Check if the user can create company successfully using the GSTIN ID
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user should land on home page successfully
    And user enters the GSTIN value and observe all the details are auto populated
    And select business type and business category and click create company
    Then user lands on dashboard
    And company created is displayed on left navigation options on dashboard page



    Examples:
      | TestVariableName |
      | TestVariableValue |