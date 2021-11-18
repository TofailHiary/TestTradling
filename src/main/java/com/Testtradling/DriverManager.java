package com.Testtradling;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class DriverManager {

	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriver<MobileElement> openApp() throws MalformedURLException {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setCapability("deviceName", "Pixel3aAPI29");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "11");
	capabilities.setCapability("automationName", "uiautomator2");
	capabilities.setCapability("app", System.getProperty("user.dir") + "/Builds/amazon-shopping.apk");
	capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
	capabilities.setCapability("newCommandTimeout", 40000);
	
	driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	
	return driver;
	}
	
	
	
	public static void scrollTo(String direction, int times) throws InterruptedException {
		if (direction.equalsIgnoreCase("down")) {

			Dimension dim = driver.manage().window().getSize();
			int width = dim.getWidth() / 2;
			for (int i = 0; i < times; i++) {
				int startY = (int) (dim.getHeight() * 0.65);
				int endY = (int) (dim.getHeight() * 0.35);
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(width, startY)).waitAction(waitOptions(Duration.ofMillis(1500)))
						.moveTo(PointOption.point(width, endY)).release().perform();
	
			}
		}
	}
			
}
