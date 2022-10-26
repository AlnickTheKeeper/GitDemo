package ThisIsGroupID.ThisIsArtifactID;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

@Test
public class ScrollDemo extends BaseTest
{
	
	public void ScrollDemoTest() throws InterruptedException 
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		//Thread.sleep(2000);
		
		scrollToEndAction();
		
		
	}

}
