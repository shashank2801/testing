package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class BillingPage extends AbstractComponents{
	
	WebDriver driver = null;
	public BillingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
