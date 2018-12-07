Feature: interest payment for web services
  As a web user
  I want to join finacle integrator
  to interest payment for web services in Finacle

  @interestPayment
  Scenario: interest payment
    Given that user is the page of finacle integrator
    When the User enters the next detais of the interest Payment
      | RequestUUID | Req_1456261590460 |
      | titleNo     |            823470 |
    Then he should see the interest Payment