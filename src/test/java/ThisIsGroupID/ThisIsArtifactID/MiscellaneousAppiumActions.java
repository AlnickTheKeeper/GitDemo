package ThisIsGroupID.ThisIsArtifactID;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousAppiumActions extends BaseTest {
	
	@Test
	
	public void MiscellaneousAppiumActionDemo() throws MalformedURLException, InterruptedException 
	{
		
		//go immediately to the desired screen
		//go to CMD and search for Package name and Activity name: adb shell dumpsys window | find "mCurrentFocus"
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//landscape
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//copy to clipboard, paste from clipboard
		
		driver.setClipboardText("Alnick Network");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		
		//press back, click OK button, press back and home 
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		

		
	}
	
	

}


