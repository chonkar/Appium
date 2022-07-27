package KavitaChonkar.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Misc2 extends baseTest {
	
	@Test
	public void AppiumTest() throws MalformedURLException {
		
		
		//different locators: xpath, id, accessibilityId, className, androidAutomator
		//Use Appuim by for exclusive appuim locators eg: accessibilityId, AndroifAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String wifiSettings=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiSettings, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Kavita");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
	}

}
