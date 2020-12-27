package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();    
	    //Open browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	 public void testcase3(){
     String headerimg=driver.findElement(By.xpath("//*[@class='attachment-large size-large wp-post-image']")).getAttribute("src");
     System.out.println("Image source path : \n"+ headerimg);
     
	}	


@AfterMethod
public void afterMethod() {
    //Close the browser
	driver.close();   
}
}


