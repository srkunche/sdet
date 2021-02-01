@HRM
Feature: HRM Scenarios

	Background: Open the OrangeHRM page and login with credentials provided
		Given User is on OrangeHRM page and logs in

  @jobVacancy
  Scenario: To create a job vacancy for “DevOps Engineer”
    Given User navigates to the Recruitment page
    When User clicks on the Vacancies menu item to navigate to the vacancies page
    Then Click on the Add button to navigate to the Add Job Vacancy form
    And Fill out the details like "DevOps Engineer", "Engineer vacancies32", "orange hrm", "3"
    When User clicks the Save button
    Then Verify that the vacancy was created for "DevOps Engineer"
 #   And Close the browser

  @addCandidate
  Scenario: Add information about a candidate for recruitment
    Given User navigates to the Recruitment page 
    When User clicks on the Add button to add candidate information
    Then User fills in the details of the candidate
    And Upload a resume to the form
    When User clicks the Save button
    Then Navigate back to the Recruitments page to confirm candidate entry
 #   And Close the browser  
  
  @addMultipleEmployees
  Scenario Outline: Add multiple employees using the Examples table
    Given User navigates to the PIM option in the menu and click it
    When Click the Add button to add a new Employee
    Then Make sure the Create Login Details checkbox is checked
    And Fill in the "<FirstName>", "<LastName>", "<EmployeeID>", and "<UserName>"
    When User clicks the Save button
    Then Verify that the employee "<FirstName>", "<LastName>" has been created
    #And Close the browser  

    Examples: 
      | FirstName     | LastName  	| EmployeeID  |	UserName  |
      | Sreedhar|  kunche1| 13015 			|	skunche37 	|
      | Sreedhar1|  kunche2| 13025 			|	skunche42		|
      
  @MultipleVacanies
  Scenario Outline: Creating multiple vacancies using data from an Examples table
    Given User navigates to the Recruitment page
    When User clicks on the Vacancies menu item to navigate to the vacancies page
    Then Click on the Add button to navigate to the Add Job Vacancy form
    And Fill out the details like "<JobTitle>", "<VacancyName>", "<HiringManager>", "<Positions>"
    When User clicks the Save button
    Then Verify that the vacancy was created for "<JobTitle>"
    #And Close the browser

    Examples: 
      | JobTitle  			| VacancyName			  	| HiringManager  |	Positions	|
      | Rust Engineer	  | Engineervacancy46		| Amy Russo			 |	10				|
      | Java Developer  | Developervacancy55	| Tim Long		   |	7					|