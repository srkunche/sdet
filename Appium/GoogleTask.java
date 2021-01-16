package Appiumproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTask {
	 AppiumDriver<MobileElement> driver = null;
	 
	 @BeforeTest
	    public void startUp() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "xiomi Redmi");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UIAutomator2");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);
	 
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        
	    }
	 
	 @DataProvider(name = "Tasks")
	 public static Object[][] tasks() {
	     return new Object[][] { {"Complete Activity with Google Tasks"},{"Complete Activity with Google Keep"},{"Complete the second Activity Google Keep"}};
	 }
	 
	 @Test(dataProvider = "Tasks")
	 public void addActivity(String taskText) {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		 //Click on Add Activity Button		 
		 MobileElement addButton=driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
		 addButton.click();
		 
		 //Enter the Activity		 
		 MobileElement textTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		 textTask.sendKeys(taskText);

		 //Save the Activity
		 MobileElement saveTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
		 saveTask.click();

		 //Verify the Activity is saved successfully
		 MobileElement savedTask =driver.findElementByXPath("//android.widget.TextView[@text='"+taskText+"']");
		 Assert.assertEquals(savedTask.getText(), taskText);
		
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.quit();
	 }
}