# Created by mcojocea at 19.03.2024
@all
Feature: Pain XML

  Background:
    Given I have pain XML file
#    And The XML file is valid

  @minimumDigits
  Scenario: Minimum 2 digits
    When I verify the debtor total amount
    Then The total amount has at least 2 digits

  @debtAmount
  Scenario: debtor amount is equal to the sum of all credits
    When I verify the debtor total amount
    Then The amount is equal to the sum of all credits

  @transactionDate
  Scenario: transaction date is not in the future
    When I get the transaction date
    Then The transaction date is not in the future

  @IBAN
  Scenario: IBAN is valid
    When I retrieve the IBAN
    Then The IBAN is valid

