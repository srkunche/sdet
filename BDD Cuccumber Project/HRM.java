package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRM extends BaseClass {
	
	//Background
		@Given("^User is on OrangeHRM page and logs in$")
	    public void Background() {
	        //Open browser
	        driver.get("http://alchemy.hguy.co/orangehrm");
	       //Enter username
	    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
	        //Enter password
	    	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	        //Click Login
	        driver.findElement(By.id("btnLogin")).click();
	    }
		
	//Job Vacancies
		@Given("^User navigates to the Recruitment page$")
		public void Recruitment() {
			driver.findElement(By.linkText("Recruitment")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Vacancies")));
		}
			
		@When("^User clicks on the Vacancies menu item to navigate to the vacancies page$")
    	public void Vacancies() {
			driver.findElement(By.linkText("Vacancies")).click();
		}
	    
	    @Then("^Click on the Add button to navigate to the Add Job Vacancy form$")
	    public void addNew() {
	    	driver.findElement(By.id("btnAdd")).click();
	    }
	    
	    @And("^Fill out the details like \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	    public void vacancyDetails(String jobTitle, String vacancyName, String manager, String positions) {
	    	Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'jobTitle')]")));
	    	dropdown.selectByVisibleText(jobTitle);  	
	    	
	    	driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
	    	driver.findElement(By.xpath("//input[contains(@class, 'FormatHint')]")).sendKeys(manager);   	
	    	driver.findElement(By.xpath("//input[contains(@id, 'noOfPositions')]")).sendKeys(positions);
	    }

	    @When("^User clicks the Save button$")
	    public void Save() {
	    	driver.findElement(By.id("btnSave")).click();	
	    }
	    
	    @Then("^Verify that the vacancy was created for \"(.*)\"$")
	    public void verifyVacany(String jobTitle) {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Edit')]")));
	    	String vacancy = driver.findElement(By.xpath("//h1[contains(text(), 'Edit')]")).getText();
	    	Assert.assertEquals(vacancy, "Edit Job Vacancy");
	    	
	    	String Title = driver.findElement(By.xpath("//select[contains(@id, 'jobTitle')]/option[@selected = 'selected']")).getText();
	    	Assert.assertEquals(Title, jobTitle);
	    	System.out.println("The vacancy added is: " + Title);
	    }
	    
	//Add Candidate
	    @When("^User clicks on the Add button to add candidate information$")
    	public void Candidates() {
			driver.findElement(By.linkText("Candidates")).click();
			driver.findElement(By.id("btnAdd")).click();
		}
	    
	    @Then("^User fills in the details of the candidate$")
	    public void candidateDetails() {
	    	driver.findElement(By.xpath("//input[contains(@id, 'firstName')]")).sendKeys("Spandana45"); 
	    	driver.findElement(By.xpath("//input[contains(@id, 'lastName')]")).sendKeys("Javvaji45"); 
	    	driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys("test34@gmail.com"); 
	    	
	    	Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'vacancy')]")));
	    	dropdown.selectByVisibleText("Automation Tester");  	
	    }	    	

	    @And("^Upload a resume to the form$")
	    public void resume() {
	    	driver.findElement(By.xpath("//input[contains(@id, 'resume')]")).sendKeys("C:\\Users\\SpandanaJavvaji\\eclipse-workspace\\CucumberProject1\\src\\test\\resources\\Resume.docx"); 
	    	
	    }
	    
	    @Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	    public void verifyCandidate() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Candidate']")));
	    	String page = driver.findElement(By.xpath("//h1[text() = 'Candidate']")).getText();
	    	Assert.assertEquals(page, "Candidate");
	    	
	    	String firstName = driver.findElement(By.xpath("//input[contains(@id, 'firstName')]")).getAttribute("value");
	    	String lastName = driver.findElement(By.xpath("//input[contains(@id, 'lastName')]")).getAttribute("value");
	    	Assert.assertEquals(firstName, "Spandana45");
	    	Assert.assertEquals(lastName, "Javvaji45");
	    	System.out.println("The candidate added is: " + firstName + " " + lastName);
	    }

	//Add Multiple Employees
	    @Given("^User navigates to the PIM option in the menu and click it$")
    	public void pim() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("PIM")));
			driver.findElement(By.linkText("PIM")).click();
		}
	    
		@When("^Click the Add button to add a new Employee$")
		public void add() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee")));
			driver.findElement(By.linkText("Add Employee")).click();
		}
		
	    @Then("^Make sure the Create Login Details checkbox is checked$")
	    public void checkbox() {
	    	driver.findElement(By.id("chkLogin")).click(); 
	    }	    	

	    @And("^Fill in the \"(.*)\", \"(.*)\", \"(.*)\", and \"(.*)\"$")
	    public void employeeDetails(String firstName, String lastName, String employeeID, String userName) {
	    	driver.findElement(By.id("firstName")).sendKeys(firstName);
	    	driver.findElement(By.id("lastName")).sendKeys(lastName);
	    	driver.findElement(By.id("employeeId")).clear();
	    	driver.findElement(By.id("employeeId")).sendKeys(employeeID);  	
	    	driver.findElement(By.id("user_name")).sendKeys(userName); 
	    }
	    
	    @Then("^Verify that the employee \"(.*)\", \"(.*)\" has been created$")
	    public void verifyEmployee(String firstName, String lastName) {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Personal Details']")));
	    	String page = driver.findElement(By.linkText("Employee List")).getText();
	    	Assert.assertEquals(page, "Employee List");
	    	
	    	String FName = driver.findElement(By.xpath("//input[contains(@id, 'FirstName')]")).getAttribute("value");
	    	String LName = driver.findElement(By.xpath("//input[contains(@id, 'LastName')]")).getAttribute("value");
	    	Assert.assertEquals(FName, firstName);
	    	Assert.assertEquals(LName, lastName);
	    	System.out.println("The candidate added is: " + FName + " " + LName);
	    }
	}