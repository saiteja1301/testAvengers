Name - Dodda Teja vardhan Reddy
Employee ID - 2318496
Role - CSD Trainee
Cohort Code - CSDQEA24QE002

Identify Courses
*******************

Problem Statement : Identify Courses
***************************************
Search and display all web development courses 
1. Should be for beginners level.
2. Courses offered in English language
3. Display first two courses with name, total learning hours and rating.
(Suggested Site: coursera.org however  you are free to choose any other legitimate  site)

Detailed Description: Hackath Ideas
***********************************
1. Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses
2. Look for Language Learning; Extract all the languages and different levels with its total count & display them
3. In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid (example: email); Capture the error message & display
(Suggested Site: coursera.org however  you are free to choose any other legitimate  site)

Key Automation Scope
********************
Handling different browser windows, search option
Extract multiple drop down list items & store in collections
Navigating back to home page
Filling form (in different objects in web page)
Capture warning message
Scrolling down in web page

Application URL - https://www.coursera.org/ 

***Test Scenarios and Test Cases For the above Requirement are***
---
1) Feature: Capturing Course Info

   Scenario: Course Info
     1)Given the user is navigated to the coursera home page
     2)When user enters input field as "Web Development Courses" and clicks on search button
     3)And select the language as english and select the level as Beginner
     4)Then the user should print the first two courses title, rating and hours of learning

2) Feature: Capturing Languages and their CourseCount

   Scenario: Languages
     1)Given the user is navigated to coursera home page
     2)When clicks on Explore button
     3)And clicks on Language Learning
     4)And select the language as All Language Courses 
     5)Then the user should print Languages under various levels

3) Feature: Filling out the Ready to Transform Form

   Scenario Outline: Submitting the form with an invalid data atleast one data
     1)Given the user is on the home page of coursera
     2)When the user enters click on the For Enterprise
     3)When the user enters into that For Enterprise page and click on the Solutions
     4)When the user enters into the Solutions and navigate to Coursera for Campus section
     5)Then the user should be redirected to the Registration form  page
     6)And fill the FirstName and LastName and Email and Password as by passing  "<row_index>"
     7)Then click on the submit button
     8)And the user should see a Error message

Utility Classes
***************
1. DataReader.java    - For retrieving data from Excel sheet to the WebPage.
2. ExcelUtility.java  - For Writing the data into the excel sheet.


Technologies Used
*****************
1. Java Programming Language
2. Selenium Automation Tool
3. Cucumber Framework
4. Hybrid Framework
5. Apache Log4j
6. Apache POI
7. AventStack
8. JUnit

Libraries and Dependencies Used
*******************************
selenium-java    - 4.19.1

webdrivermanager - 5.7.0

apache-poi       - 5.2.5
apache-poi-ooxml - 5.2.5

testng - 7.9.0

log4j-core - 2.23.1
log4j-api  - 2.23.1

extentreports - 5.1.1

cucumber-junit - 7.15.0
cucumber-java  - 7.15.0

junit - 4.13.2

extentreports-cucumber7-adapter - 1.14.0





