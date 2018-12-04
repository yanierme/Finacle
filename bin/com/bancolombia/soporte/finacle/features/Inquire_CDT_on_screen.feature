Feature:Inquire account CDT for screen
  As a web user
  I want to login in Finacle
  to Consult a CDT on screen the Finacle

  @InquireCDTForScreen
  Scenario: consult account CDT in Finacle for screen
    Given that user is logged in finacle with your
      | user      | password      |
      | usercdt17 | Amb13nt32017* |
    When the User enters the next detais the inquire
      | Number_CDT |
      |     800060 |
    Then you should see the CDT information on the screen
