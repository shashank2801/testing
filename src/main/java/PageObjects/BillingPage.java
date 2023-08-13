package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement dropdown;
	
	@FindBy(xpath = "//button[@type='button'][2]")
	WebElement country;
	
	@FindBy(className = "action__submit")
	WebElement submit;
	
	By suggestions = By.className("ta-results");
	
	public void selectIndia()
	{
		dropdown.sendKeys("India");
		waitForElementVisible(suggestions);
		country.click();
	}
	
	public ConfirmationPage submit() {
		selectIndia();
		submit.click();
		ConfirmationPage cp = new ConfirmationPage(driver);
		return cp;
		
	}
	
}
