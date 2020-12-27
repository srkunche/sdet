package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();    
	    //Open browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void testcase2(){
   	String expectedheading="Welcome to Alchemy Jobs";
	String headerText=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
	if(expectedheading.equalsIgnoreCase(headerText))
	System.out.println("The expected heading is same as actual heading --- "+headerText);
	else
    System.out.println("The expected heading doesn't match the actual heading --- "+headerText);
}


    @AfterMethod
    public void afterMethod() {
        //Close the browser
     	driver.close();   
    }
   
    }
	
	


