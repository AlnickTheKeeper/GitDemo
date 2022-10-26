package ThisIsGroupID.ThisIsArtifactID;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TclFwTestCase extends BaseTest {
	
	@Test
	
	public void LaunchSos() throws MalformedURLException, InterruptedException 
	{
		

	// wake up device in case device charging screen is displayed	
		clickAction();
		Thread.sleep(200);
		
		
		for (int i=0; i<6;i++) 
		{
			swipeLeft();
			Thread.sleep(1000);
		}
		
		
		
		driver.findElement(By.id("com.tcl.wearable.launcher:id/fragment_app_card_iv_icon")).click();
		
		//driver.pressKey(new KeyEvent(AndroidKey.HOME));

		for (int i=0; i<4;i++) 
		{
			swipeLeft();
			Thread.sleep(1000);
		}
		driver.findElement(By.id("com.tcl.wearable.launcher:id/fragment_app_card_iv_icon")).click();
		
		driver.findElement(By.id("com.timexgroup.seniorwatch.timer:id/img_EditButton")).click();
		driver.findElement(By.id("com.timexgroup.seniorwatch.timer:id/txt_SecondsField")).click();
		
		for(int i=0; i<10; i++)
			driver.findElement(By.id("com.timexgroup.seniorwatch.timer:id/img_SecondsUpArrow")).click();
		
		
		Thread.sleep(1000);
		
		
	
		
		
		//}
		
		
	}
	
	

}


