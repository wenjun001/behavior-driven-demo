Feature: Customer check BMI value and category
  As a customer,
  I want to check my BMI value and category using my weight and height
 
Scenario: Underweight
  Given the user is on the BMI Calculate page
  When he calculate BMI using "160" as height and "45" as weight
  Then ensure the bmi category is "Underweight"
  And ensure the bmi value is "17.6"
  
Scenario: Normal
  Given the user is on the BMI Calculate page
  When he calculate BMI using "168" as height and "70" as weight
  Then ensure the bmi category is "Normal"
  And ensure the bmi value is "24.8"
