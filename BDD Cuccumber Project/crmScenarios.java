package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class crmScenarios extends BaseClass {
	List <WebElement> dashlets = new ArrayList<WebElement>();

	//Background
		@Given("^User is on OrangeCRM page and logs in$")
	    public void Background() {
	        driver.get("https://alchemy.hguy.co/crm/");

	        driver.findElement(By.id("user_name")).sendKeys("admin");
	        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	        driver.findElement(By.name("Login")).click();
	    }

	//Dashlets
	    @When("^User counts the number of Dashlets on the homepage$")
	    public void dashlets() {
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3/span[contains(text(), 'My Activity')]")));
	        dashlets = driver.findElements(By.xpath("//td[@class = 'dashlet-title']"));
	    	Assert.assertEquals(dashlets.size(), 4);
	    }
	    
	    @Then("^Print the number and title of each Dashlet into the console$")
	    public void printCount() {
	    	System.out.println("Total number of Dashlets on the homepage: " + dashlets.size());
	    }
	    
	//Leads	    
	    @Given("^User navigates to Sales, Leads, and Create Lead$")
	    public void leads() {
	    	builder.moveToElement(driver.findElement(By.xpath("//a[text() = 'Sales']"))).build().perform();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Leads")));
	    	builder.moveToElement(driver.findElement(By.linkText("Leads"))).build().perform();
	    	driver.findElement(By.linkText("Leads")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Create Lead']")));
	    	driver.findElement(By.xpath("//div[text() = 'Create Lead']")).click();
	    }
	    
	    @And("^User gives details like \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	    public void details(String Salutation, String firstName, String lastName, String Title, String email) {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Leads0emailAddress0")));
	    	
			Select salutation = new Select(driver.findElement(By.id("salutation")));
			salutation.selectByVisibleText(Salutation);

			driver.findElement(By.id("first_name")).sendKeys(firstName);
			driver.findElement(By.id("last_name")).sendKeys(lastName);
			driver.findElement(By.id("title")).sendKeys(Title);
			driver.findElement(By.id("Leads0emailAddress0")).sendKeys(email);
	    }
	    
	    @When("^User clicks Save button$")
	    public void Save() {
	    	driver.findElement(By.id("SAVE")).click();	    	
	    }

	    @Then("^Navigate to the View Leads page to see results for \"(.*)\", \"(.*)\", \"(.*)\"$")
	    public void verfiyLeads(String Salutation, String firstName, String lastName) {
	    	String FullName = Salutation + firstName + " " + lastName;
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
	    	String Name = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
	    	Assert.assertEquals(Name, FullName);
	    	System.out.println("The lead added is: " + FullName);
	    }
	    
	//Meeting
	    @Given("^User navigates to Activities, Meetings, and Schedule a meeting$")
	    public void meeting() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_3")));
	    	builder.moveToElement(driver.findElement(By.id("grouptab_3"))).build().perform();
	    	builder.moveToElement(driver.findElement(By.linkText("Meetings"))).build().perform();
	    	driver.findElement(By.linkText("Meetings")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Schedule Meeting']")));
	    	driver.findElement(By.xpath("//div[text() = 'Schedule Meeting']")).click();    	
	    }
	    
		@When("^User gives details$")
		public void meetingName() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_first_name")));
			driver.findElement(By.id("name")).sendKeys("Test Meeting");
		}
		
		@And("^User searches and add members$")
		public void search(DataTable searchTable) {

			List<List<String>> search = searchTable.asLists();
			
			for(int i = 1; i < search.size(); i++) {
				driver.findElement(By.id("search_first_name")).sendKeys(search.get(i).get(0));
				driver.findElement(By.id("search_last_name")).sendKeys(search.get(i).get(1));
				driver.findElement(By.id("search_email")).sendKeys(search.get(i).get(2));
				
				driver.findElement(By.id("invitees_search")).click();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invitees_add_1")));
				driver.findElement(By.id("invitees_add_1")).click();
				
				driver.findElement(By.id("search_first_name")).clear();
				driver.findElement(By.id("search_last_name")).clear();
				driver.findElement(By.id("search_email")).clear();
				}
			driver.findElement(By.id("SAVE_HEADER")).click();		
		}
		
	    @Then("^Navigate to View Meetings page and confirm creation of the meeting$")
	    public void verfiyMeeting() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
	    	String Name = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
	    	Assert.assertEquals(Name, "TEST MEETING");
	    	System.out.println("The scheduled meeting is: " + Name);
	    }
	    
	//Products
	    @Given("^User navigates to All, Products, and Create Product$")
	    public void product() {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_5")));
	    	
	    	builder.moveToElement(driver.findElement(By.id("grouptab_5"))).build().perform();
	    	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text()='Products']")));
	    	driver.findElement(By.xpath("//a[text()='Products']")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Create Product']")));
	    	driver.findElement(By.xpath("//div[text() = 'Create Product']")).click();	    	
	    }
	    
	    @And("^User enters details about the product like \"(.*)\" and \"(.*)\"$")
	    public void productDetails(String Name, String Price) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contact']")));
	    	driver.findElement(By.id("name")).sendKeys(Name);
	    	driver.findElement(By.id("price")).sendKeys(Price);
	    }
	    @Then("^User navigates to View Products page to see \"(.*)\" listed$")
	    public void productDetails(String Name) {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab-content-0")));
	    	String productName = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
	    	Assert.assertEquals(productName, Name);
	    	System.out.println("The product created is: " + productName);	
	    }
	    
	//To be run After each CRM scenario
	    @After("@CRM")
	    public void logout() {
	    	builder.moveToElement(driver.findElement(By.xpath("//span[text() = 'admin']"))).build().perform();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
	       	builder.moveToElement(driver.findElement(By.linkText("Logout"))).build().perform();
	    	driver.findElement(By.linkText("Logout")).click();
	    }
	    }
