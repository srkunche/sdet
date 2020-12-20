package SeleniumSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\KuncheSreedhar\\Desktop\\Selenium installation\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
       driver.get("www.google.com");
	}

}
