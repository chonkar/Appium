package KavitaChonkar.Appium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Misc extends baseTest {
	
	@Test
	public void miscDemo() throws MalformedURLException, InterruptedException {
		
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		String Message=driver.findElement(By.id("android:id/alertTitle")).getText();
		//Assert.assertEquals(Message, "Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop.");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Saturday']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Kavita");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("password");
		driver.findElement(By.id("android:id/button1")).click();

	}

}
