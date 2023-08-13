package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BillingPage;
import PageObjects.CartPage;
import PageObjects.ConfirmationPage;
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
		BillingPage bp = cp.Checkout();
		ConfirmationPage confirm = bp.submit();
		Boolean match = confirm.confirm();
		Assert.assertTrue(match);
		
	}
}
