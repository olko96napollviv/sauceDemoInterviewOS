@login @demo
Feature: Login Functionality

  @validCreds
  Scenario Outline: Login with valid credentials
    #Given navigate to SauceDemo login page
    When enter valid "<login>" and "<password>"
    And click on login button
    Then verify products title is displayed
    #And quit the browser
    Examples:
      | login                   | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @invalidCreds
  Scenario: Login with invalid credentials
    #Given navigate to SauceDemo login page
    When enter invalid credentials
    And click on login button
    Then verify error message
    #And quit the browser