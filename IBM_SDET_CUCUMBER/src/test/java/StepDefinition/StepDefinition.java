package StepDefinition;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utilities.hooks;

public class StepDefinition {

	WebDriver driver = hooks.driver;

	@Given("^User is on Learning landing page (.+)$")
	public void user_is_on_learning_landing_page(String url) throws Throwable {

		driver.get(url);
		driver.findElement(By.xpath("//a[text()=' Sign up! ']")).click();
		driver.manage().window().maximize();

	}

	@When("^User registration with following details firstname (.+) and lastname (.+)$")
	public void user_registration_with_following_details_firstname_and_lastname(String firstname, String lastname)
			throws Throwable {
		driver.findElement(By.xpath("// input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);

	}

	@And("^Emailid (.+) and UserName (.+)$")
	public void emailid_and_username(String Gmail, String username) throws Throwable {

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Gmail);

		// To generate random string
		String Uniqueuseranme = RandomStringUtils.randomAlphanumeric(6);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Uniqueuseranme);
	}

	@And("^Enter password (.+) and Enter Confirm password (.+)$")
	public void enter_password_and_enter_confirm_password(String pass1, String pass2) throws Throwable {

		driver.findElement(By.xpath("//input[@name='pass1']")).sendKeys(pass1);
		driver.findElement(By.xpath("//input[@name='pass2']")).sendKeys(pass2);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
	}

	@Then("^User successfully registered$")
	public void user_successfully_registered() throws Throwable {

		driver.findElement(By.xpath("//p[contains(text(),'Dear Arpitha Gowda,')]")).isDisplayed();
		driver.findElement(
				By.xpath("//p[contains(text(), 'An e-mail has been sent to remind you of your login and password.')]"))
				.isDisplayed();
		driver.findElement(
				By.xpath("//p[contains(text(),'You can now select, in the list, the course you want access to.')]"))
				.isDisplayed();

	}

	@And("^Validate mail id and Navigate to inbox page under user profile (.+)$")
	public void validate_mail_id_and_navigate_to_inbox_page_under_user_profile(String gmail) throws Throwable {

		driver.findElement(By.xpath("//li[contains(@class,'dropdown')]")).click();
		String mailId = driver.findElement(By.xpath("//p[contains(text(),'gmail.com')]")).getText();
		System.out.println(mailId);
		Assert.assertEquals(gmail, mailId);
		driver.findElement(By.xpath("//a[@title='Inbox']")).click();
	}

	@When("^User compose a mail with (.+) and (.+)$")
	public void user_compose_a_mail_with_and(String mailidsearchinput, String mailsubject) throws Throwable {
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(mailidsearchinput);
		Thread.sleep(2000L);

		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@id,'users-results')]"));

		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("virat kohli (virat)")) {
				option.click();
				break;
			}

		}

		driver.findElement(By.name("title")).sendKeys(mailsubject);

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebElement framebody = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(framebody);

		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[contains(@class,'editable cke')]")));

		driver.findElement(By.xpath("//body[contains(@class,'editable cke')]"))
				.sendKeys("Hi Virat,\nThis for testing \n\n\n" + "From Arpitha");
		driver.switchTo().defaultContent();

		driver.findElement(By.name("compose")).click();
	}

	@Then("^User successfully sent a message (.+)$")
	public void user_successfully_sent_a_message(String confirmation) throws Throwable {

		String alert = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
		Assert.assertEquals(alert, confirmation);
	}

}
