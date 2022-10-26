package ThisIsGroupID.ThisIsArtifactID;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

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

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException 
	{
		
		
		//code to start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ahormiguera//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
	
		UiAutomator2Options options = new UiAutomator2Options();
		
//		options.setDeviceName("AlnickPhone");
		options.setDeviceName("Android Device");
		//options.setChromedriverExecutable("C://Users//ahormiguera//Downloads//chromedriver_win32_101//chromedriver.exe");
		
		
		//options.setApp("C://Users//ahormiguera//eclipse-workspace//ThisIsArtifactID//src//test//java//resources//ApiDemos-debug.apk");
		//options.setApp("C://Users//ahormiguera//eclipse-workspace//ThisIsArtifactID//src//test//java//resources//General-Store.apk");
		//options.setApp("C://Users//ahormiguera//eclipse-workspace//ThisIsArtifactID//src//test//java//resources//app_382.apk");
	
		driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
		
	}
	
	public void longPressAction(WebElement ele) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
			//may give conditions here		
		}while(canScrollMore);
		
	}
	
	public void swipeAction(WebElement image, String direction)  
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)image).getId(),
			    "direction", direction,
			    "percent", 0.75
			));

		
		
	}
	
	public void swipeLeft() 
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "direction", "left",
			    "percent", 1.0,
			    "left", 1, "top", 1, "width", 300, "height", 10
				));

		
		
	}
	
	
	public void swipeRight() 
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "direction", "right",
			    "percent", 1.0,
			    "left", 1, "top", 1, "width", 300, "height", 10
				));

		
		
	}
	
	
	public Double getFormattedAmount(String amount)
	{
		Double totalPriceDouble = Double.parseDouble(amount.substring(1));
		return totalPriceDouble;
		
		
	}
	
	public void clickAction() {
		
		
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
				"x", 10, 
				"y",10
				
			));
		
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		//stop server
		service.stop();
		
		
		
	}
	
	
	
	

}
