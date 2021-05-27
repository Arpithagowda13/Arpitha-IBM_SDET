package Native;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import  static io.appium.java_client.touch.TapOptions.tapOptions;
import  static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class NtiveDemo extends Capability{

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	
	public void setup() throws MalformedURLException
	
	{
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void testcase1() throws InterruptedException
	{
		//System.out.println("launch the api demos");
     driver.findElement(MobileBy.AccessibilityId("Preference")).click();
 
     driver.findElementByAccessibilityId("3. Preference dependencies").click();
     
     driver.findElement(By.id("android:id/checkbox")).click();	
     driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
     driver.findElement(By.className("android.widget.EditText")).sendKeys("arpitha");  
     driver.hideKeyboard();
     driver.findElements(By.className("android.widget.Button")).get(0).click();
     driver.pressKey(new KeyEvent(AndroidKey.BACK));
     Thread.sleep(3000);
     driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
			
			}
	@Test(enabled=false)
	public void testcase2()
	{
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().clickable(true)").getSize());
		WebElement explst=driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
		
		TouchAction t =new TouchAction(driver);
		t.tap(tapOptions().withElement(element(explst))).perform();
		driver.findElementByAccessibilityId("1. Custom Adapter").click();
		WebElement LP=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(LP)).withDuration(ofSeconds(3))).release().perform();
		
	}
	
	@Test(enabled=false)
	public void testcase3()
	
	{
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
		
	}
	
	@Test(enabled=false)
	public void testcase4()
	
	{
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElementByAccessibilityId("Date Widgets").click();
		driver.findElementByAccessibilityId("2. Inline").click();
		driver.findElementByAccessibilityId("9").click();
		WebElement source = driver.findElementByAccessibilityId("15");
		
		WebElement destination=driver.findElementByAccessibilityId("45");
		TouchAction t =new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(3))).moveTo(element(destination)).release().perform();
		
		
}
	
	@Test
	public void testcase5()
	
	{
		driver.findElement(By.xpath("//*[@text='Views']")).click();
WebElement element1 = driver.findElements(By.className("android.view.View")).get(0);
		
		WebElement element2=driver.findElements(By.className("android.view.View")).get(1);
		TouchAction t =new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(element1))).moveTo(element(element2)).release().perform();
		
	}

}
