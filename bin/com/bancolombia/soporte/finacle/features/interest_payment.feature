Feature: interest payment for web services
  As a web user
  I want to join finacle integrator
  to interest payment for web services in Finacle

  @interestPayment
  Scenario: interest payment
    Given that user is the page of finacle integrator
    When the User enters the next detais of the interest Payment
      | RequestUUID | db06050f-6h8c-11e6-98f5-0a9870yu7000 |
      | CustId      |                       20000000074012 |
      | amountValue |                             40003000 |
      | titleNo     |                               823470 |
      | intRate     |                                  4.8 |
      | intPayFreq  |                                   30 |
      | fundAmount1 |                             40000000 |
      | openingDate | 2018-04-12T10:09:04.177395           |
      | days        |                                   90 |
    Then he should see the CDT for web servicescreated successfully
