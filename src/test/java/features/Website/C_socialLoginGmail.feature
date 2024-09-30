Feature: Social media login flow

  @Portal @SocialLogin
  Scenario Outline: Check if the user can login using the gmail email & password successfully
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user clicks the gmail login button
    And user enters the gmail email and hit next
    And user enters the gmail password
    And user hit submit
    Then user should land on home page successfully


    Examples:
      | TestVariableName |
      | TestVariableValue |
