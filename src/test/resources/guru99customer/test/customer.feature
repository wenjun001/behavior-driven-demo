Feature: User Check Customer
  As a valid user
  I should be able to check my customer

Scenario: Check Customer
  Given a user has logged in user id "mngr56586" and password "AtAhUvU"
  And the user is on the Edit Customer page
  When he submits "5164" as customer id
  Then ensures the customer name is "Eric"
  And ensures the customer gender is "male"
  And ensures that DoB is "2016-12-26"