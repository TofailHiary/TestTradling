package com.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import com.Testtradling.DriverManager;

import io.appium.java_client.MobileElement;

public class TestTrades extends DriverManager {

	@Test
	public void testAmaz() throws MalformedURLException, InterruptedException {

		DriverManager.openApp();
		Thread.sleep(8000);
		MobileElement skipSignIn = driver.findElementById("skip_sign_in_button");
		skipSignIn.click();
		Thread.sleep(2000);
		MobileElement burger_icon = driver.findElementById("chrome_action_bar_burger_icon");
		burger_icon.click();
		Thread.sleep(2000);
		MobileElement settings = driver.findElementByXPath(
				"//android.widget.TextView[@content-desc=\"Settings button. Double tap for links to change country, sign out, and more.\"]");
		settings.click();
		Thread.sleep(2000);
		MobileElement country_settings = driver.findElementByXPath("//*[@text=\"Country & Language\"]");
		country_settings.click();

		Thread.sleep(7000);
		MobileElement country_dropdownList = driver.findElementByXPath(
				"//android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[8]/android.widget.Button");

		country_dropdownList.click();

		DriverManager.scrollTo("down", 2);
		Thread.sleep(2000);
		MobileElement country_UAE = driver.findElementByXPath("//*[@text=\"United Arab Emirates Amazon.ae\"]");

		country_UAE.click();
		Thread.sleep(2000);
		MobileElement done_btn = driver
				.findElementByXPath("//android.view.View/android.view.View[14]/android.widget.Button");
		done_btn.click();
		Thread.sleep(7000);
		burger_icon.click();
		settings.click();
		country_settings.click();
		Thread.sleep(2000);
		MobileElement country_selected = driver.findElementByXPath(
				"//android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.Button");
		Assert.assertTrue(country_selected.getText().contains("United Arab Emirates"));
		done_btn.click();
		Thread.sleep(5000);
		DriverManager.scrollTo("down", 4);
		Thread.sleep(2000);
		MobileElement currency_button = driver.findElementByXPath(
				"//android.view.View[@content-desc=\"Ships from & sold by Amazon.ae. AED 35.00AED 955.00 Save on women's handbags\"]/android.view.View[3]");
		Thread.sleep(2000);
		Assert.assertTrue(currency_button.getText().contains("AED"));

	}

}
