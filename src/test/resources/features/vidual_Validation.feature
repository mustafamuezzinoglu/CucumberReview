Feature:

  Scenario:  Validate visual contents
    Given user goes to the login page
    When user login with validate credentials
    Then user see below contents
      | title    | Swag Labs |
      | subTitle | Products  |
      | itemSize | 6         |