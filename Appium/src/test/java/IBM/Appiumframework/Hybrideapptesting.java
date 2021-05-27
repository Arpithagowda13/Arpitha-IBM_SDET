package IBM.Appiumframework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Hybrideapptesting extends capability {

	AndroidDriver<AndroidElement> driver;

	/*@BeforeTest

	public void setup() throws IOException, InterruptedException

	{
		driver = capabilities(deviceName, apppackage, appActivity);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}*/

	@Test(enabled = false)
	public void testcase1() throws InterruptedException {
		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arpitha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")
				.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// driver.findElementByAndroidUIAutomator("text(\"Let's Shop\")");
		WebElement toastview = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		String exp = toastview.getAttribute("name");
		String act = "Please enter your name";
		Assert.assertEquals(act, exp);

	}

	@Test
	public void testcase2() throws InterruptedException, IOException {

	//	service.start();
		Thread.sleep(8000);
		service=startserver();
		
		
		driver = capabilities(deviceName, apppackage, appActivity);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arpitha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")
				.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		service.stop();
	}

	@Test(enabled = false)
	public void testcase3() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arpitha");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Air Jordan 9 Retro\"))"));
		// driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		int products = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(products);
		for (int i = 0; i < products; i++) {
			String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			System.out.println(productname);
			if (productname.equals("Air Jordan 9 Retro")) {

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		// t.tap(tapOptions().withElement(element(explst))).perform();
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(9000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		// this is to change from native app to web app
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		// driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

}
