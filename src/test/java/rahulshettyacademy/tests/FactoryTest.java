package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseClass;

public class FactoryTest extends BaseClass{
	List<String> itemName = Arrays.asList("ZARA COAT 3","ADIDAS ORIGINAL");
	@Test
	public void placeOrder() throws InterruptedException {
		String email = prop.getProperty("userEmail"),password = prop.getProperty("userPassword");
		LandingPage lp = new LandingPage(driver);
		ProductCatalogue pc = lp.loginApp(email, password);
		CartPage cp = pc.addItems(itemName);
		cp.Checkout();
		
	}
}
