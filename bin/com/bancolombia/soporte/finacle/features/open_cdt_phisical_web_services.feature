Feature: Open Account phisical for web services
  As a web user
  I want to ingresar a finacle integrator
  to create a CDT pishical for web services in Finacle

  @AccountCDTPhisicalForWebServices
  Scenario: open account CDT in Finacle for web services
    Given that user is the page of finacle integrator
    When the User enters the next detais of the account
      | action      | openPhisical                         |
      | RequestUUID | db06050f-6h8c-11e6-98f5-0a9870yu7000 |
      | CustId      |                       20000000074012 |
      | amountValue |                             40000000 |
      | titleNo     |                               823470 |
      | intRate     |                                  4.8 |
      | intPayFreq  |                                   30 |
      | fundAmount1 |                             40000000 |
      | openingDate | 2018-04-12T10:09:04.177395           |
      | days        |                                   90 |
    Then he should see the CDT for web servicescreated successfully
