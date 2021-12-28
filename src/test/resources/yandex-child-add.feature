Feature: Yandex child adding
  Scenario: user add to Yandex his child's profile
    Given an open browser with Yandex profile page
    When user press "Семья" page button
    And user press "Добавить профиль" button
    And user press "Добавить профиль" button again
    And user insert name of child and press continue button
    And user press "6+" button and continue button
    And user choose child's gender and his birthday and press "Создать профиль" button
    Then user finds himself on Yandex disk page