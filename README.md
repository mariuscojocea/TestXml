
## XML Testing

The TestXML repo contains some tests that verify that:
- debtor total amount has at least 2 digits
- debtor amount is equal to the sum of all credits
- transaction date is not in the future
- IBANs are valid


### Prerequisites

The following are required before you start testing:
- Java 11
- Maven

### Running Tests

Create a Junit test runner with the following:
- Java 11
- VM Options: -ea -Dcucumber.filter.tags="@all"
- Class: LocalTestRunner.java

### Viewing the test report

Once the tests have run, you should be presented with the location of the report. For example,

Open this report in your browser.

