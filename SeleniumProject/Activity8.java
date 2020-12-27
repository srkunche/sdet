package SeleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	String username="root";
    String password="pa$$w0rd";
    
	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();  
	    driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
	}
	
     @Test
    public void testcase8() {
  	driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys(username);
	driver.findElement(By.id("user_pass")).sendKeys(password);
	driver.findElement(By.id("wp-submit")).click();
    String logintext= driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']")).getText();
	System.out.println(logintext);
	Assert.assertEquals(logintext,"Howdy, root");
	   
	}
	   

	  @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	     	driver.close();   
	    }
	  
	}


