Feature: Open Account
  As a web user
  I want to login in Finacle
  to create a CDT in Finacle

  Scenario: open account CDT in Finacle
    Given that user wants to login in finacle with your
      | user      | password      |
      | usercdt17 | Amb13nt32017* |
    When he wants to open a CDT in finacle in the sold_id
    And the User enters the next detais
      | sol_id | cif_id         | scheme_Code | opening_date | stament | initial_Amt | tenor | rate | frecuency |
      |     04 | 20000000074012 | FI25        | success      | None    |     5000000 |    60 | 0,15 |        30 |
    Then he should see the CDT created
