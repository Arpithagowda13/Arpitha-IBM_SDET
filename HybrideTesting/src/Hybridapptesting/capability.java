package Hybridapptesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class capability {

public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Arpitha Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
				cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
				AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
						cap);
				return driver;
				
	}

}
