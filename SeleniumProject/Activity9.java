package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Activity9 {
WebDriver driver;
String username="root";
String password="pa$$w0rd";
	
	@BeforeMethod
	public void beforeMethod() {
	    driver = new FirefoxDriver();  
	    driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
	}
	 @Test
	public void testcase9() throws InterruptedException {    
  	driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys(username);
	driver.findElement(By.id("user_pass")).sendKeys(password);
	driver.findElement(By.id("wp-submit")).click();
    //Actions class    
	Actions action =new Actions(driver);    
    WebElement button = driver.findElement(By.xpath("//div[text()='Job Listings'][1]"));
  	//driver.findElement(By.xpath("//*[@class='page-title-action']")).click();
    //Mouse hover the element using actions class      
    action.moveToElement(button).build().perform();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New")));
    WebElement button2 = driver.findElement(By.linkText("Add New"));
    action.moveToElement(button2);
    action.click().build().perform();
     Thread.sleep(5000);
   	driver.findElement(By.xpath("(//*[@role='img'])[13]")).click();
   Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id='post-title-0']")).sendKeys("test");
    driver.findElement(By.id("_application")).clear();
	driver.findElement(By.id("_application")).sendKeys("sdet test automation");
	driver.findElement(By.id("_company_website")).sendKeys("test.com");
	driver.findElement(By.id("_company_twitter")).sendKeys("@test");
	driver.findElement(By.id("_job_location")).sendKeys("India");
	driver.findElement(By.id("_company_name")).sendKeys("ABC Pvt Ltd");	
	driver.findElement(By.xpath("//button[contains(text(), 'Publish…')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//div[@class='editor-post-publish-panel__header-publish-button']/button")).click();
	Thread.sleep(5000);
    WebElement publishedText = driver.findElement(By.className("editor-post-publish-panel__header-published"));
	Assert.assertEquals(publishedText.getText(), "Published");
	driver.findElement(By.xpath(".//div[@class='post-publish-panel__postpublish-buttons']/a")).click();
   
    }




@AfterMethod
public void afterMethod() {
    //Close the browser
 	driver.close();   
}

}