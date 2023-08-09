package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	public ProductCatalogue pc = null;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement emailElement;
	
	@FindBy(id = "userPassword")
	WebElement passwordElement;
	
	@FindBy(className = "login-btn")
	WebElement login;
	
	public ProductCatalogue loginApp(String email,String password) {
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		login.click();
		pc = new ProductCatalogue(driver);
		return pc;
	}
}
