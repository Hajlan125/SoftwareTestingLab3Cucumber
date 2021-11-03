Feature: Download and Upload file to Yandex Disk
  Scenario: user download and upload file to Yandex disk
    Given opened browser with Yandex disk page
    When user press on file and press download
    And user refresh page
    And user upload file
    Then user delete uploaded file