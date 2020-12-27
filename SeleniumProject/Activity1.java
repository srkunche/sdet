package SeleniumProject;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
@BeforeMethod
public void beforeMethod() {
    driver = new FirefoxDriver();    
    //Open browser
    driver.get("https://alchemy.hguy.co/jobs/");
}
	@Test
	 public void testcase1(){
   	// Check the title of the page
	String actualtitle = driver.getTitle();    
	String expectedTitle = "Alchemy Jobs – Job Board Application";
	System.out.println("Page title is: " + actualtitle);
	 Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
    @AfterMethod
    public void afterMethod() {
        //Close the browser
    	driver.close();   
    }
    
	
	}
	


