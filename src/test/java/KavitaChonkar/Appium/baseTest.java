package KavitaChonkar.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class baseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService servicebuilder;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		//to start the server use the below line of code, we have passed the string, we need to convert it into file
		servicebuilder=new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new File("C:\\Users\\kavit\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").usingPort(4723).build();
		servicebuilder.start();
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("KavitaDevice");
		options.setApp("C:\\Users\\kavit\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPress(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "duration",3000));
	}
	
	public void scrollUntilEnd() {
		//No idea until where to scroll
				boolean canScrollMore;
				do{
					canScrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 3.0
					));
				}while(canScrollMore);
	}
	
	public void swipeGesture(WebElement ele, String direction) {
		//Swipe Gesture
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.50
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		servicebuilder.stop();
	}

}
