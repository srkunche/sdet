@Jobs
Feature: Alchemy Job-board system scenarios

	Background: User is in Alchemy Jobs site
		Given User is on Alchemy Jobs site
		
  @createUser
  Scenario: Create a new user
    Given User navigates to Dashboard and logs in
    When User clicks Users menu item from left hand menu
    Then locate the Add New button and click it
    And Fill all the necessary details
    When user clicks the Add New User button
    Then Verify that the user was created
   # And Close the browser
    
  @SearchAndApplyJob
  Scenario: Search and apply for job
    Given User navigates to Jobs page
    When User finds the Keywords search input field
    Then Type in keywords to search for jobs
    And Find the filter using XPath and filter job type to show only Full Time jobs
    When User finds a job listing using XPath and click it to see job details	
    Then Find the title of the job listing using XPath and print it to the console
    And Find and Click on the Apply for job button
  #  And Close the browser
    
  @PostJob
  Scenario: Post a job using parameterization
    Given User navigates to Post a Job page
    When User enters "spandan79@gmail.com" and Job title as "FullstackTester18"
    Then Type in Description as "Need a tester with knowledge of JAVA, Python, Selenium, Cucumber."
    And Enter Application email as "test210@gmail.com" and company as "IBM"
    When User click Preview and Submit listing
    Then View listing in Alchemy Jobs for "FullstackTester18"
 #   And logout from the Jobs site
 #   And Close the browser
    
  @PostJobExamples
  Scenario Outline: Post a job using parameterization
    Given User navigates to Post a Job page
    When User enters "<email>" and Job title as "<JobTitle>"
    Then Type in Description as "<Description>"
    And Enter Application email as "<Application>" and company as "<Company>"
    When User click Preview and Submit listing
    Then View listing in Alchemy Jobs for "<JobTitle>"
   # And logout from the Jobs site
   # And Close the browser
    
    Examples: 
      | email 						    | JobTitle 				    | Description 			| Application 	  	 | Company  |
      | kunche17@gmail.com 	|FullstackTester31  	| Description15     | tech15@gmail.com   |	IBM			|
    	| kunche18@gmail.com 	|FullStackTesters41 	| Jobdescription16  | test16@gmail.com   |	IBM			|