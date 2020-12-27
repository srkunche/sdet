package SeleniumProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();    
	    //Open browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	 public void testcase4(){
   	String expectedheader="Quia quis non";
	String headertext=driver.findElement(By.xpath("//div[@class='entry-content clear']//following::h2")).getText();
    System.out.println("second heading on the page is: " + headertext);
    Assert.assertEquals(headertext,expectedheader);
	}


    @AfterMethod
    public void afterMethod() {
        //Close the browser
     	driver.close();   
    }
   
    }
	