Feature: Open Account phisical for screen
  As a web user
  I want to login in Finacle
  to create a CDT pishical for screen in Finacle

  @AccountCDTPhisicalForScreen
  Scenario: open account CDT in Finacle for screen
    Given that user is logged in finacle with your 
      | user      | password      |
      | usercdt17 | Amb13nt32017* |
    When he wants to work in finacle for branch office BC000001
    And the User enters the next detais
      | sol_id | cif_id         | scheme_Code | opening_date | stament | initial_Amt | tenor | rate | frecuency |
      |     04 | 20000000074012 | FI3         | 09-04-2018   | N       |    40000000 |    90 |  4,8 |        30 |
      |     04 | 20000000074012 | FI3         | 09-04-2018   | N       |    40000000 |    90 |  4,8 |        30 |
    Then he should see the CDT for screen created successfully
