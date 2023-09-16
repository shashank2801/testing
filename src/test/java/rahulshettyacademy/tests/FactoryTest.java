package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BillingPage;
import PageObjects.CartPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseClass;

public class FactoryTest extends BaseClass{
	List<String> itemName = Arrays.asList("ZARA COAT 3","ADIDAS ORIGINAL");
	
	@Test(dataProvider = "sendData")
	public void placeOrder(String email,String password,String product) throws InterruptedException {
//		String email = prop.getProperty("userEmail"),password = prop.getProperty("userPassword");
		LandingPage lp = new LandingPage(driver);
		ProductCatalogue pc = lp.loginApp(email, password);
		CartPage cp = pc.addItems(itemName);
		BillingPage bp = cp.Checkout();
		ConfirmationPage confirm = bp.submit();
		Boolean match = confirm.confirm();
//		Assert.assertTrue(match);
		confirm.signOut();
		pc = lp.loginApp(email, password);
		OrderPage op = new OrderPage(driver);
		Assert.assertTrue(op.verifyOrder(itemName));
		
	}
	
//	@Test(dataProvider = "sendData",dependsOnMethods = {"placeOrder"})
//	public void OrderHistoryTest(String email,String password,String product) throws InterruptedException{
//		LandingPage lp = new LandingPage(driver);
//		ProductCatalogue pc = lp.loginApp(email, password);
//		OrderPage op = new OrderPage(driver);
//		Assert.assertTrue(op.verifyOrder(itemName));
//	}
	
	@DataProvider
	public Object[][] sendData(){
		return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"xyz123@abc.com","Xyzabc@12","ADIDAS ORIGINAL"}};
		
	}
}
