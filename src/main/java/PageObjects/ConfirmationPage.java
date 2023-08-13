package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(className= "hero-primary")
	WebElement message;
	
	public boolean confirm() {
//		Assert.assertEquals(false, null);
		return (message.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		message.getText();
	}

}
