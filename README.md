
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

Once the tests are finished, type **mvn serenity:aggregate** in terminal and a link to a full report will be displayed in console
