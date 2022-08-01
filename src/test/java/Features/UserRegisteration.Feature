Feature: User Registeration
  I want to check The user can register in our e-commerce website

  Scenario Outline: User Can Regiser Successfully
    Given User at Home page
    When I Click on Register Link
    And I entered <firstname>,<lastname>,<email>,<password>
    Then The Regiseration page is Displayed Successfully

    Examples: 
      | firstname | lastname | email        | password |
      | ahmed     | mahmoud  | hggf@trd.com | 12345678 |
      | moataz    | ali      | jgf@oub.com  | 12345678 |
