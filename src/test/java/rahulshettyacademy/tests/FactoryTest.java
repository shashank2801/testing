package rahulshettyacademy.tests;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseClass;

public class FactoryTest extends BaseClass{
	
	@Test
	public void placeOrder() throws InterruptedException {
		String email = prop.getProperty("userEmail"),password = prop.getProperty("userPassword");
//		Thread.sleep(1000);
//		System.out.println(email);
//		System.out.println(password);
//		LandingPage.login()
		LandingPage lp = new LandingPage(driver);
		ProductCatalogue pc = lp.loginApp(email, password);
	}
}
