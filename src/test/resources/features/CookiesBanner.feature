Feature: Cookies Banner

  As a user
  I want to interact with the cookies banner
  So that I can control my cookie preferences

  Background:
    Given the user navigates to the start page

  Scenario: Cookies banner is displayed on first visit
    Then the cookies banner should be visible
    And the banner should contain "I'm OK with analytics cookies" and "Do not use analytics cookies" buttons

  Scenario: User accepts all cookies
    When the user clicks the "I'm OK with analytics cookies" button
    Then the cookies banner should disappear
    And a confirmation message should be shown
#    And the user's preference should be saved

  Scenario: User rejects all cookies
    When the user clicks the "Do not use analytics cookies" button
    Then the cookies banner should disappear
    And a confirmation message should be shown
#    And the user's preference should be saved
#
#  Scenario: Cookies banner is not shown after preference is set
#    Given the user has previously set a cookie preference
#    When the user revisits the start page
#    Then the cookies banner should not be visible
#
#  Scenario: Accessibility of the cookies banner
#    Then the cookies banner should be accessible by keyboard
#    And the banner should have appropriate ARIA labels