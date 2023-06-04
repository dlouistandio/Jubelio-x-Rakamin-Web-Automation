@Test
Feature: User Login

  Scenario Outline: Login user with valid email & password then verify user succesfuly login to home page
    Given User already in Jubelio login page
    When User enter username as "<username>"
    And User enter password as "<password>"
    And User click Masuk button
    Then User redirected to Home page
    Examples:
      | username                     | password    |
      | qa.rakamin.jubelio@gmail.com | Jubelio123! |

  Scenario Outline: Login user with invalid email then verify user cant login
    Given User already in Jubelio login page
    When User enter username as "<username>"
    And User enter password as "<password>"
    And User click Masuk button
    Then User see the error with message "<message>"
    Examples:
      | username          | password    | message                         |
      | invalid@gmail.com | Jubelio123! | Password atau email anda salah. |

