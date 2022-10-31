Feature: Rabota by tests
  
  Scenario:
    When i enter text "QA automation"
    And i click submit button
    Then i check page title "Работа QA automation в Минске"
    Then i check vacancies count more or equal than 25