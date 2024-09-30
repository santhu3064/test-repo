Feature: Validate user profile page and update personal details

  @UserProfile
  Scenario Outline: Check if all the sections on profile page are loaded and user can update personla info
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user enters email on the login page
    And user enters password on the login page
    And user clicks submit login button on the login page
    And user should land on home page successfully
    And user clicks the options menu
    And user opens the profile page
    Then profile info section is present on profile page
    And update password section is present on profile page
    And 2FA section is present on profile page
    And broswer sessions section is present on profile page
    And delete account section is present on profile page
    And user updates profile information on profile info section
    And user clicks the options menu
    And user clicks logout link
    And user lands on login page by clicking the login button
    And user enters the updated email on the login page
    And user enters new password on the login page
    And user clicks submit login button on the login page
    Then user should land on home page successfully










    Examples:
      | TestVariableName |
      | TestVariableValue |