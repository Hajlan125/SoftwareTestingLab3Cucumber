Feature: Yandex Authorization
Scenario: user can authorizate on Yandex
  Given an open browser with Yandex ru auth
  When user type login and press enter
  And user type password and press enter
  Then user should see profile page