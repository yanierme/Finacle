Feature: Open Account phisical for web services
  As a web user
  I want to ingresar a finacle integrator
  to create a CDT pishical for web services in Finacle

  @AccountCDTPhisicalForWebServices
  Scenario: open account CDT in Finacle for web services
    Given that user is the page of finacle integrator
    When the User enters the next detais of the account
      | CustId         | amountValue | tenor | rate | frecuency |
      | 20000000074012 |    40000000 |    90 |  4,8 |        30 |
      | 20000000074012 |    40000000 |    90 |  4,8 |        30 |
    Then he should see the CDT created successfully