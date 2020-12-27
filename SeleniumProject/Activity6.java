package SeleniumProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	String jobs="Testing";
	
	public class Activity5 {
		WebDriver driver;
		@BeforeMethod
		public void beforeMethod() {
		    driver = new FirefoxDriver();    
		    //Open browser
		    driver.get("https://alchemy.hguy.co/jobs/");
		}

	@Test
	 public void testcase6() throws InterruptedException{
   	driver.findElement(By.xpath("//*[@id='menu-item-24']")).click();
	driver.findElement(By.id("search_keywords")).sendKeys(jobs);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()='Automation Test Specialist'][1]")).click();
	driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	String text=driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
	System.out.println(text);
	Assert.assertEquals(text, "selenium.project4@gmail.com");
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
    //	driver.close();   
    }
	}
	
}

