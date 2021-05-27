@AddBook
Feature: Add Book as librarian
  As a Librarian, I should be able to add a book

  Background:
    Given user is on Library Application
    When user logs in with "librarian26@library" and "gFOHHm6H" credentials
    Then user navigates to "Books"
    And user clicks on "Add Book" button

  @Scenario_AC-23 @Smoke
  Scenario: Add a book
    When user is on Add Book form
    Then user enters book information:
      | Book_Name | ISBN | Year | Author | Book_Category | Book_Description |
      |  Book1 | 01234567890123 | 2021 | Author 1 | Drama | Book description test |

  @Scenario_AC-24
  Scenario: Verify new book parameters
    When user is on Add Book form
    Then user should be able to see name, author, description, category, ISBN, year parameters

  @ScenarioOutline_AC-25
  Scenario Outline: Verify new book ISBN number
    When user is on Add Book form
    Then user enters "<Book Name>", "<Author>","<Year>","<ISBN>", "<ShouldPass>"
    Examples:
      | Book Name | Author | Year | ISBN | ShouldPass |
      | Book1 | Author1 | 2021 | | false |
      | Book1 | Author1 | 2021 | 1 | false |
      | Book1 | Author1 | 2021 | 123456789 | false |
      | Book1 | Author1 | 2021 | 123456789- | false |
      | Book1 | Author1 | 2021 | 12345678901234 | false |
      | Book1 | Author1 | 2021 | asdfghjklp | false |
      | Book1 | Author1 | 2021 | 12345!!!!! | false |
      | Book1 | Author1 | 2021 | 1234567890123 | true |
      | Book1 | Author1 | 2021 | 12345-67890 | true |

  @ScenarioOutline_AC-26
  Scenario Outline: Verify new book year parameter
    When user is on Add Book form
    Then librarian enters "<Book Name>", "<Author>","<ISBN>","<Year>","<ShouldPass>"
    Examples:
      | Book Name | Author | ISBN | Year | ShouldPass |
      | Book1 | Author1 | 1234567890123 | 2 | false   |
      | Book1 | Author1 | 1234567890123 | 20211| false |
      | Book1 | Author1 | 1234567890123 | aabb | false |
      | Book1 | Author1 | 1234567890123 | 202! | false |
      | Book1 | Author1 | 1234567890123 | !!!! | false |
      | Book1 | Author1 | 1234567890123 | 2021 | true |

  @Scenario_AC-27
  Scenario: Verify new book categories
    When user is on Add Book form
    Then user should click Book Category dropdown list
    And check categories that should be present
    |Action and Adventure|
    |Anthology|
    |Classic|
    |Comic and Graphic Novel|
    |Crime and Detective|
    |Drama|
    |Fable|
    |Fairy Tale|
    |Fan-Fiction|
    |Fantasy|
    |Historical Fiction|
    |Horror|
    |Science Fiction|
    |Biography/Autobiography|
    |Humor|
    |Romance|
    |Short Story|
    |Essay|
    |Memoir|
    |Poetry|