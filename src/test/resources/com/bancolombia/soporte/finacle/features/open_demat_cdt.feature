Feature: Open Account dematerialized
  As a web user
  I want to login in Finacle
  to create a CDT dematerialized for screen in Finacle

  @AccountDematerialized
  Scenario: open account CDT dematerialized
    Given that user is logged in finacle with your 
      | user      | password      |
      | usercdt17 | Amb13nt32017* |
    When he wants to work in finacle for branch office BC000030
    And the User enters the next detail the openning dematerialized
      | sol_id | cif_id         | scheme_Code | opening_date | stament | initial_Amt | tenor | rate | frecuency |
      |     04 | 20000000074012 | FI3         | 09-04-2018   | N       |    40000000 |    90 |  4,8 |        30 |
    #Then he should see the CDT for 