package Appiumproject;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Web_Todolist {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "xiomi Redmi");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 5);        
}

    @Test (priority = 0)
    public void ScrollTest() {
    //Open Selenium page on Chrome
    driver.get("https://www.training-support.net/selenium/");
        
    //wait for page to load and Assertion
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text = 'Selenium']")));
    String Title = driver.findElementByXPath("//android.view.View[@text = 'Selenium']").getText();
	Assert.assertEquals(Title, "Selenium");
	System.out.println("The first page title is: " + Title);
		
	//scroll to To_Do List and click       
    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));
    MobileElement toDoList=driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
    toDoList.click();
        
    //wait for page to load and Assertion
    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.view.View")));
    String NewTitle = driver.findElementByXPath("//android.view.View[contains(@text, 'To-Do List')]").getText();
	Assert.assertEquals(NewTitle, "To-Do List");
	System.out.println("The new page title is: " + NewTitle); 
    }
    
    @Test (priority = 1)
    public void AddAndClearsTasks()  {
    	
    //Adding the tasks 
    MobileElement taskInput = driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']");
    MobileElement addTask = driver.findElementByXPath("//android.widget.Button[@text='Add Task']");
    
    String[] tasksToAdd	 = {"Add tasks to list", "Get number of tasks", "Clear the list"};
    
	for (String taskToAdd : tasksToAdd) {
		taskInput.sendKeys(taskToAdd);
		addTask.click();	
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View[@text= \"" + taskToAdd + "\"]")));
	    	}
	
	//Assertion after adding tasks
	List<MobileElement> tasksAdded = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View");
	System.out.println("Number of tasks added: " + tasksAdded.size());
	Assert.assertEquals(tasksAdded.size(), 4);

	List<String> taskNames = new ArrayList<>();
	List<String> expectedTaskNames = new ArrayList<>(Arrays.asList("Add more tasks to this list.", "Add tasks to list", "Get number of tasks", "Clear the list"));
	
	System.out.println("The Tasks added are: ");
	for (MobileElement taskAdded : tasksAdded) {
		System.out.println(taskAdded.getText());
	    taskNames.add(taskAdded.getText());
	 	}
	Assert.assertEquals(taskNames, expectedTaskNames);	

	//Striking out each task
	for (MobileElement taskAdded : tasksAdded) {
		taskAdded.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View[@text= '" + taskAdded.getText() + "']")));
		}
	
	//Clearing the list
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Clear List')]")));
	driver.findElementByXPath("//android.view.View[contains(@text,'Clear List')]").click();

	//Assertion after clearing tasks
	wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View")));
	List<MobileElement> tasksCleared = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
	System.out.println("Number of tasks after clearing: " + tasksCleared.size());
	Assert.assertEquals(tasksCleared.size(), 0);
}  

    @AfterTest
    public void tearDown() {
    driver.quit();
    }
}