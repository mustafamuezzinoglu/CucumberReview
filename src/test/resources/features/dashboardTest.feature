Feature: Dashboard Test

  Background:
    Given user is on the login page


  Scenario Outline: Check dashboard elements as a user

    When user enters as different "<role>"
    Then user should see menu option

      | Dashboards       |
      | Fleet           |
      | Customers       |
      | Sales           |
      | Activities      |
      | Marketing       |
      | Reports & Segments |
      | System          |

    Examples:
      | role          |
      | sales manager |
      | store manager |

  Scenario: Check dashboard elements as a sales manager
    When user enters "user1" and "UserUser123" as credentials
    Then user should see menu option


      | Fleet           |
      | Customers       |
      | Activities      |
      | System          |


