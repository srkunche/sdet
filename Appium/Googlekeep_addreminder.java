package Appiumproject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Googlekeep_addreminder {

 AppiumDriver<MobileElement> driver = null;
	 
	 @BeforeTest
	    public void startUp() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "xiomi Redmi");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UIAutomator2");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", ".activities.BrowseActivity");
	        caps.setCapability("noReset", true);
	 
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        
	    }
	 
	 
	 
	 @Test
	 public void addNote() {
		 
		 String Title="Complete activities for reminder";
		 String Note="Complete activities to complete course";
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //Click the Create New Note button to add a new Note
		 MobileElement addNoteButton = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]");
		 addNoteButton.click();
		 
		 //Add a title for the note and add a small description
		 MobileElement addTitle = driver.findElementById("com.google.android.keep:id/editable_title");
		 addTitle.sendKeys(Title);
		 
		 MobileElement addNote = driver.findElementById("com.google.android.keep:id/edit_note_text");
		 addNote.sendKeys(Note);
		 
		 MobileElement reminderButton = driver.findElementByAccessibilityId("Reminder");
		 reminderButton.click();
		 
		//Click the reminder icon on the toolbar to add a reminder for Afternoon of the same day.
	     MobileElement selectTime = driver.findElementById("com.google.android.keep:id/time_spinner");
	     selectTime.click();
	     	     
	     //Select Afternoon
	     driver.findElement(MobileBy.AndroidUIAutomator("text(\"Afternoon\")")).click();
	     
	     //Click on Save Button
	     driver.findElementById("com.google.android.keep:id/save").click();
	     
	     //Press the back button and switch to the Reminders page
		 MobileElement backButton = driver.findElementByAccessibilityId("Open navigation drawer");
		 backButton.click();
		 
		 //Make an assertion to ensure that the note was added with a reminder
		 MobileElement checkAddedNoteTitle = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='"+Title+". "+Note+". ']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
		 Assert.assertEquals(checkAddedNoteTitle.getText(), Title);
		 
		 MobileElement checkAddedNoteDescription = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='"+Title+". "+Note+". ']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
		 Assert.assertEquals(checkAddedNoteDescription.getText(), Note);
		 
		 MobileElement checkReminder = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='"+Title+". "+Note+". ']/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
		 Assert.assertEquals(checkReminder.getText(), "Today, 1:00 PM");
		 
	 }
	 
	 
	 @AfterTest
	 public void tearDown() {
	    driver.quit();
	 }
	 
	

}
