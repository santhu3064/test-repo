Feature: Registration flow

   @Portal @Registration @Profile
  Scenario Outline: Check if the user can register successfully through email OTP authentication
    Given user launches the InstaBee portal on browser
    And user lands on registration page by clicking the try InstaBee free button
    And user enters the name
    And user enters the email
    And user enters the mobile
    And user enters the password
    And user enters the confirm password
     And user hit submit registration button
    And user lands on the 2FA page
    And user gets OTP from the email for registration
    And user enters the OTP and hit submit
    Then user should land on home page successfully


    Examples:
      | TestVariableName |
      | TestVariableValue |