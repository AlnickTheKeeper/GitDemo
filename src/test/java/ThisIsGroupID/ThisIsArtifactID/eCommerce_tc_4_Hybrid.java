package ThisIsGroupID.ThisIsArtifactID;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class eCommerce_tc_4_Hybrid extends BaseTest {
	
	@Test
	
	public void FillForm() throws MalformedURLException, InterruptedException 
	{
		//locators: xpath, id, accessibilityId, classname, androidUIAutomator
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Alnick Bryan");
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//tap 2 items
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//explicitly wait for Cart page to display. Jar comes from Selenium
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int count = productPrices.size();
		Double sum = 0.0; 
		for (int i=0; i<count; i++)
		{
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);  // remove dollar character
			sum += price;
			
			
		}
		
		String totalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double totalPriceDouble = getFormattedAmount(totalPrice);
		
		Assert.assertEquals(totalPriceDouble,sum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
		Thread.sleep(6000);
		
		// Change context from Android native app to Web browser 
		//context name for Webview can change. Ask developer
		Set<String> contexts =driver.getContextHandles();
		
		//Check context names
		for(String contextName :contexts)
		{
			System.out.println(contextName);
		}
		
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("first web test");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
		
		
	}
	
	

}


