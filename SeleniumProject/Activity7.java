package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Activity7 {
		 WebDriver driver;
		 String JobTitle="TestLead";
		 String JobLocation="Hyderabad";
		 String desc="SDET";
		 String username="root";
		 String password="pa$$w0rd";
	
		@BeforeMethod
		public void beforeMethod() {
		    driver = new FirefoxDriver();    
		    //Open browser
		    driver.get("https://alchemy.hguy.co/jobs/");
		}
	@Test
		 public void testcase7() throws InterruptedException{
	   		driver.findElement(By.xpath("//*[@id='menu-item-26']")).click();
			driver.findElement(By.xpath("//*[text()='Sign in']")).click();
			driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
			driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
			driver.findElement(By.id("wp-submit")).click();
		    driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(JobTitle);
		    driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys(JobLocation);
		    //Frames class
		    driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='job_description_ifr']")));
            driver.findElement(By.xpath("//*[@id='tinymce']")).click();
            driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("SDET");
            String desc= driver.findElement(By.xpath("//*[@id='tinymce']")).getText();
            System.out.println(desc);
            //Switch to parent class
            driver.switchTo().defaultContent();
	   	    driver.findElement(By.xpath("//input[@value='Preview']")).click();
		    driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
		    driver.findElement(By.xpath("//*[text()='click here']")).click();
     		String JobPosted=driver.findElement(By.xpath("//div[@class='job_description']")).getText();
	    	System.out.println(JobPosted);
		    if(desc.equalsIgnoreCase(JobPosted))
			System.out.println("The job listing posted  is same as the job applied --- "+desc);
		    else
	        System.out.println("The job listing posted doesn't match the job applied --- "+desc);
	}		

		
	
	  @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	     	driver.close();   
	    }
	  
	}
	   
	

