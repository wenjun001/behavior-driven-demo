Feature: Customer Check Balance
  As a valid customer
  I should be able to check balance

Scenario: Check Balance
  Given a user has logged in user id "mngr56586" and password "AtAhUvU"
  And the user is on the Balance Enquiry page
  When he submits "19892" as account no
  Then ensures the account type is "Savings"
  And ensures the balance is "20000"
  