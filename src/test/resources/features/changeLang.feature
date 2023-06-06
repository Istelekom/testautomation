Feature: The use shall be able to change the language in Tesco website
  Rule: Allow to change the language

    Background:
      Given open main page
      And accept cookies

    @TC_ChangeLang
    Scenario Outline: Change language

      Given language is set to "<language>"
      When change the language to "<new_language>"
      Then it shows elements in "<new_language>"

      Examples:
        | language | new_language |
        | English  | Magyar       |
        | Magyar   | English      |

    @TC_ChangeLangWithDataTable
    Scenario: Change language with data table
      Given language is set to "Magyar"
      When change the language to
        | lang    | code |
        | Magyar  | HUN  |
        | English | ENG  |
      Then it shows elements in "English"
