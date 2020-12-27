package SeleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();    
	    //Open browser
	    driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	 public void testcase5(){
   	String expectedTitle="Alchemy Jobs – Job Board Application";
	String actualTitle = driver.getTitle(); 
	driver.findElement(By.xpath("//*[@id='menu-item-24']")).click();
	if(expectedTitle.equalsIgnoreCase(actualTitle))
	System.out.println("The expected page title is same as actual page --- "+actualTitle);
	else
     System.out.println("The expected page title doesn't match the actual page --- "+actualTitle);
}
    @AfterMethod
    public void afterMethod() {
        //Close the browser
     	driver.close();   
    }
    }
