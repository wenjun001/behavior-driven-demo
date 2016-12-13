Feature: Customer Login
  As a customer,
  I can log in guru99 with my valid user id and password

Scenario: Valid Login
  Given a user is on the login page
  When he enters "mngr56586" as user id
  And he enters "AtAhUvU" as password
  And he clicks the Login button
  Then ensures the manager id is "mngr56586"