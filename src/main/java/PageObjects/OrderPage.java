package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> items;
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public List<WebElement> getProductList() throws InterruptedException{
		Thread.sleep(1000);
		return items;
	}
	
	public boolean verifyOrder(List<String> items) throws InterruptedException {
		goTo("myorders");
		boolean match = true;
		for(int i=0;i<items.size();i++) {
			String prod = items.get(i);
			if(!getProductList().stream().anyMatch(product->product.getText().equalsIgnoreCase(prod))) {
				match = false;
				break;
			}
		}
		
		return match;
	}

}
