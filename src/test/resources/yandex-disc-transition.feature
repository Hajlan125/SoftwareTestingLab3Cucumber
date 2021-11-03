Feature: Yandex disk transition
  Scenario: user goes to Yandex disk page
    Given an open browser with Yandex profile page
    When user press profile page button
    And user press "Диск" button
    Then user finds himself on Yandex disk page