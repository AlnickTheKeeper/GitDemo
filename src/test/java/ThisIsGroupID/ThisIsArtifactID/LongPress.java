package ThisIsGroupID.ThisIsArtifactID;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

@Test
public class LongPress extends BaseTest
{
	public void longPressGesture() throws MalformedURLException, InterruptedException 
	{
		
	
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		
		//if same class name, specify index
		//String menuText = driver.findElements(AppiumBy.className("android.widget.TextView")).get(0).getText();
		//Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElements(AppiumBy.className("android.widget.TextView")).get(0).isDisplayed());

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
