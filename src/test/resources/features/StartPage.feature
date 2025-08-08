Feature: NHS Exemption Start Screen

  Scenario Outline: User navigates to informational pages from the landing screen
    Given I am on the NHS exemption start page
    When I click the "<link>" link
    Then I should be taken to the "<screen>" page

    Examples:
      | testno | link                    | screen                         |
      | TC03   | Privacy policy          | Privacy notice                 |
      | TC04   | Cookies                 | Cookies                        |
      | TC05   | Terms And Conditions    | Terms and Conditions           |
      | TC06   | Accessibility statement | Accessibility statement        |
