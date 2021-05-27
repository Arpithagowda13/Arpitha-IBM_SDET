package Native;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
 File fs=new File("src\\ApiDemos-debug.apk");
		//MobileCapabilityType is common cap can be used for all mobile device
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Arpitha Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//cap.setCapability("noReset",true);
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,""
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);

		return driver;
	}

}
