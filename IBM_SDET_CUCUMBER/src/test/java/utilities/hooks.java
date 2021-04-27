package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {

	public static WebDriver driver;

	@Before("@smokeTest")
	public void beforeScenario() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpitha\\Desktop\\SDET\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before Scenario");
	}

	@After("@smokeTest")
	public void afterScenario() {
		driver.quit();
		System.out.println("After Scenario");
	}
}
