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
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;

	public class Googlekeepaddnote {
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
			 
			 String Title="Complete activities";
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
			 
			 //Press the back button and make an assertion to ensure that the note was added
			 MobileElement backButton = driver.findElementByAccessibilityId("Open navigation drawer");
			 backButton.click();
			 
			 MobileElement checkAddedNoteTitle = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='"+Title+". "+Note+". ']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
			 Assert.assertEquals(checkAddedNoteTitle.getText(), Title);
			 
			 MobileElement checkAddedNoteDescription = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='"+Title+". "+Note+". ']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
			 Assert.assertEquals(checkAddedNoteDescription.getText(), Note);
			 
		 }
		 
		 @AfterTest
		 public void tearDown() {
			 driver.quit();
		 }
		 
		 
	}


