@CRM
Feature: CRM Scenarios

	Background: Open the OrangeCRM page and login with credentials provided
		Given User is on OrangeCRM page and logs in

  @dashlets
  Scenario: Counting Dashlets
    When User counts the number of Dashlets on the homepage
    Then Print the number and title of each Dashlet into the console
   # And Close the browser

  @leads
    Scenario: Create leads using parameterization
    Given User navigates to Sales, Leads, and Create Lead
    And User gives details like "Ms.", "Spandu07", "Javvaji16", "Manager", "test06@email.com"
    When User clicks Save button
    Then Navigate to the View Leads page to see results for "MS. ", "SPANDU07", "JAVVAJI16"
   # And Close the browser
  
  @meeting 
    Scenario: Schedule a meeting and invite 3 members
    Given User navigates to Activities, Meetings, and Schedule a meeting
    When User gives details
    And User searches and add members
    |	firstName |	lastName	  |	email						            	|
    |	Ahmed 		|	Carranza	  | kid.vegan.sales@example.com		|
    |	Colleen 	|	Windsor			|	hr.info@example.net           |
    |	Santo 		|	Petti				|	the.info@example.tv			      |
    Then Navigate to View Meetings page and confirm creation of the meeting
   # And Close the browser

  @product      
  Scenario Outline: Creating a Product
    Given User navigates to All, Products, and Create Product
    And User enters details about the product like "<Name>" and "<Price>"
    When User clicks Save button
    Then User navigates to View Products page to see "<Name>" listed
  #  And Close the browser

    Examples: 
      | Name		  | Price |
      | PENCIL16  | 3.79  |
      | BOOK17	 	| 14.35 |