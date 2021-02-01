package StepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Jobs extends BaseClass {

	//Background
		@Given("^User is on Alchemy Jobs site$")
	    public void Background() {
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/");
	    }
		
	//Create User
	 	@Given("^User navigates to Dashboard and logs in$")
	    public void loginPage() {
	    	driver.findElement(By.linkText("Job Dashboard")).click();
	    	driver.findElement(By.linkText("Sign in")).click();
	    	
	       //Enter username
	        driver.findElement(By.id("user_login")).sendKeys("root");
	        //Enter password
	        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	        //Click Login
	        driver.findElement(By.id("wp-submit")).click();
	        driver.findElement(By.linkText("Alchemy Jobs")).click();
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
	    }

	    @When("^User clicks Users menu item from left hand menu$")
	    public void users() {
	    	driver.findElement(By.xpath("//div[text()='Users']")).click();
	    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(@class, 'heading')]")));
	    }
	    
	    @Then("^locate the Add New button and click it$")
	    public void addNew() {
	    	driver.findElement(By.xpath("//a[contains(@class, 'title')]")).click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-new-user")));
	    }
	    
	    @And("^Fill all the necessary details$")
	    public void details() {
	    	driver.findElement(By.id("user_login")).sendKeys("vandanas29");
	    	driver.findElement(By.id("email")).sendKeys("emailidS2213@gmail.com");
	    	driver.findElement(By.id("first_name")).sendKeys("swoels2");
	    	driver.findElement(By.id("last_name")).sendKeys("qowlp2");
	    	driver.findElement(By.id("url")).sendKeys("website11");	 
	    	driver.findElement(By.xpath("//button[text()='Show password']")).click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("strong")));    	
	    }
	    
	    @When("^user clicks the Add New User button$")
	    public void clickAdd() {
	    	driver.findElement(By.id("createusersub")).submit();
	    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(@class, 'heading')]")));
	    	
	    }
	    @Then("^Verify that the user was created$")
	    public void verfiyUsers() throws InterruptedException {
	    	Thread.sleep(3000);
	    	driver.findElement(By.id("user-search-input")).sendKeys("vandanas29");
	    	driver.findElement(By.id("search-submit")).click();
	    	String username = driver.findElement(By.linkText("vandanas29")).getText();
	    	System.out.println("The new user added is: " + username);
	    	Assert.assertEquals(username, "vandanas29");  	
	    }
	    
	    @And("^Close the browser$")
	    public void closeBrowser() {
	        //Close browser
	        driver.close();
	    }
	    
	//Search and Apply for Job
		@Given("^User navigates to Jobs page$")
		public void jobsPage() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Jobs']")));
	        driver.findElement(By.linkText("Jobs")).click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Jobs']")));
	    }

	    @When("^User finds the Keywords search input field$")
	    public void keywordsSearch() {
	    	driver.findElement(By.id("search_keywords")).click();
	    }
	    
	    @Then("^Type in keywords to search for jobs$")
	    public void testerJob() {
	    	driver.findElement(By.id("search_keywords")).sendKeys("FullstackTester2");
	    }
	    
	    @And("^Find the filter using XPath and filter job type to show only Full Time jobs$")
	    public void jobType() {
	    	driver.findElement(By.xpath("//input[contains(@id, 'freelance')]")).click();
	    	driver.findElement(By.xpath("//input[contains(@id, 'internship')]")).click();
	    	driver.findElement(By.xpath("//input[contains(@id, 'part-time')]")).click();
	    	driver.findElement(By.xpath("//input[contains(@id, 'temporary')]")).click();    	
	    }
	    
	    @When("^User finds a job listing using XPath and click it to see job details$")
	    public void jobDetails() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text() = 'FullstackTester2']")));
	    	driver.findElement(By.xpath("//h3[text() = 'FullstackTester2']")).click();   
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'FullstackTester2']")));
	    }
	    
	    @Then("^Find the title of the job listing using XPath and print it to the console$")
	    public void jobTitle() {
	    	String jobTitle = driver.findElement(By.xpath("//h1[text() = 'FullstackTester2']")).getText(); 
	    	System.out.println("The title of the job listing is: " + jobTitle);
	    	Assert.assertEquals(jobTitle, "FullstackTester2");
	    	
	    	String jobType = driver.findElement(By.xpath("//li[contains(@class, 'job-type')]")).getText(); 
	    	Assert.assertEquals(jobType, "Full Time");
	    }
	   
	    @And("^Find and Click on the Apply for job button$")
	    public void applyJob() {
	    	driver.findElement(By.xpath("//input[contains(@class, 'application_button')]")).click();  
	    	
	    	WebElement applyJob = driver.findElement(By.xpath("//a[contains(@class, 'email')]")); 
	    	if(applyJob.isDisplayed()) {
	    		System.out.println("Applied for the job");	
	    	}
	    }
	    
	//Post Job
	    @Before("@PostJob or @PostJobExamples")
	    public void logOut() {
	    	builder.moveToElement(driver.findElement(By.partialLinkText("Howdy"))).build().perform();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Log")));
	    	builder.moveToElement(driver.findElement(By.partialLinkText("Log"))).build().perform();
	    	driver.findElement(By.partialLinkText("Log")).click();
	      }
	    
		@Given("^User navigates to Post a Job page$")
		public void postJobPage() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Post a Job']")));
	        driver.findElement(By.partialLinkText("Post")).click();
	    }

	    @When("^User enters \"(.*)\" and Job title as \"(.*)\"$")
	    public void jobdetails(String email, String title) {
	    	driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys(email);
	    	driver.findElement(By.xpath("//input[contains(@id, 'title')]")).sendKeys(title);
	    }
	    
	    @Then("^Type in Description as \"(.*)\"$")
	    public void JobDescription(String description) {
	    	driver.switchTo().frame(0);
	       	driver.findElement(By.xpath("//body[contains(@id,'mce')]")).sendKeys(description);
	    	driver.switchTo().defaultContent();
	    }
	    
	    @And("^Enter Application email as \"(.*)\" and company as \"(.*)\"$")
	    public void application(String application, String company) {
	    	driver.findElement(By.id("application")).click();
	    	driver.findElement(By.id("application")).sendKeys(application);
	    	driver.findElement(By.id("company_name")).sendKeys(company);
	    }
	    
	    @When("^User click Preview and Submit listing$")
	    public void previewAndSubmit() {
	    	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[contains(@name,'submit_job')]")));
	    	driver.findElement(By.name("submit_job")).click();
	    	driver.findElement(By.name("continue")).click();
	    }
	    
	    @Then("^View listing in Alchemy Jobs for \"(.*)\"$")
	    public void alchemyJobs(String title) {
	    	driver.findElement(By.linkText("click here")).click();
 
	    	String jobTitle = driver.findElement(By.xpath("//h1[@class= 'entry-title']")).getText(); 
	    	System.out.println("The title of the job posted is: " + jobTitle);
	    	Assert.assertEquals(jobTitle, title);
	    }     
	}