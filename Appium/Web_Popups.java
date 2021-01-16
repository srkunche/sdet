package Appiumproject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Web_Popups {
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
	        wait = new WebDriverWait(driver, 20);        
    }

	    @Test (priority = 0)
	    public void ScrollTest() throws Exception {
	    //Open Selenium page on Chrome
	    driver.get("https://www.training-support.net/selenium/");
	    	    
	    //wait for page to load and Assertion
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text = 'Selenium']")));
	    String Title = driver.findElementByXPath("//android.view.View[@text = 'Selenium']").getText();
		Assert.assertEquals(Title, "Selenium");
		System.out.println("The first page title is: " + Title);
			
		//scroll to Login Form and click   
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));
        MobileElement popups = driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]");
        popups.click();
        
        //wait for page to load and Assertion
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text= 'Popups']")));
	    String NewTitle = driver.findElementByXPath("//android.view.View[@text= 'Popups']").getText();
		Assert.assertEquals(NewTitle, "Popups");
		System.out.println("The new page title is: " + NewTitle); 
	    
    }  
    
	    @Test (priority = 1)
	    public void PopupTest() {
	    //Clicking Sign In Button
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[contains(@text, 'Sign')]")));
	    MobileElement signinButton = driver.findElementByXPath("//android.widget.Button[contains(@text, 'Sign')]");
	    signinButton.click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Sign In']")));
	    
	    //Assertion
	    MobileElement signinPopup = driver.findElementByXPath("//android.view.View[@text='Sign In']");
	    Assert.assertTrue(signinPopup.isDisplayed());
	    System.out.println("Sign In pop up is displayed");
	    	    
	    MobileElement username = driver.findElementByXPath("//android.widget.EditText[@resource-id='username']");
	    MobileElement password = driver.findElementByXPath("//android.widget.EditText[@resource-id='password']");  
	    MobileElement loginButton = driver.findElementByXPath("//android.widget.Button[@text='Log in']");
	    
	    //Login with valid credentials  
	    username.sendKeys("admin");
	    password.sendKeys("password");
	    loginButton.click();
	    	    
	    //Assertion	
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id='action-confirmation']")));
	    MobileElement message = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
	    Assert.assertEquals(message.getText(), "Welcome Back, admin");
	    System.out.println("The message for valid credentials: " + message.getText());
	    
	    //Clicking Sign In Button
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[contains(@text, 'Sign')]")));
	    signinButton.click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Sign In']")));
	    
	    //Assertion
	    Assert.assertTrue(signinPopup.isDisplayed());
	    System.out.println("Sign In pop up is displayed again");
	    
	   //Login with invalid credentials
	    username.sendKeys("admin1");
	    password.sendKeys("password1");
	    loginButton.click();
	    	    
	    //Assertion
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")));
	    Assert.assertEquals(message.getText(), "Invalid Credentials");
	    System.out.println("The message for invalid credentials: " + message.getText());
	}
	    
	    @AfterTest
	    public void tearDown() {
	    driver.quit();   
	    }
	}