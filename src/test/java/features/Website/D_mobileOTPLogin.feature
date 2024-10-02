Feature: Mobile OTP login

  @Portal @OTPLogin
  Scenario Outline: Check if the user can login using mobile OTP
    Given user launches the InstaBee portal on browser
    And user lands on login page by clicking the login button
    And user clicks the login with OTP button
    And user enters the valid phone number registered with the player and hit verify
    And user gets OTP from the email for login
    And user enters the OTP and hit submit
    Then user should land on home page successfully


    Examples:
      | TestVariableName |
      | TestVariableValue |
