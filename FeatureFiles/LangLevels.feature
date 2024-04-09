Feature: Capturing Languages and their CourseCount
 
 	@smoke
  Scenario: Languages
    Given the user is navigated to coursera home page
    When clicks on Explore button
    And clicks on Language Learning
    And select the language as All Language Courses 
    Then the user should print Languages under various levels