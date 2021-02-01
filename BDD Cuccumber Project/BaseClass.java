package StepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class BaseClass {
	    static WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Actions builder = new Actions(driver);  
	}

