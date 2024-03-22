# Created by mcojocea at 19.03.2024
@all @pain1
Feature: Pain1 XML

  Background:
    Given I have pain1 XML file

  @validateXml
    Scenario: Validate XML
    Then The XML pain1 file is valid against pain.001.001.11 schema

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

