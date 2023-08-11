
package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By toast = By.id("toast-container");
	By animator = By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getProductList() {
		waitForElementClickByLoc(By.className("card-body"));
		List<WebElement> items = driver.findElements(By.className("card-body"));
		return items;
	}
	
	public WebElement getItem(String itemName) {
		List<WebElement> items = getProductList();
		WebElement prod = items.stream().filter(product->product.findElement(By.tagName("h5")).getText().equals(itemName)).findFirst().orElse(null);
		return prod;
	}
	
	public CartPage addItems(List<String> itemList) throws InterruptedException {
		for(int i=0;i<itemList.size();i++) {
//			String ele = itemList.get(i);
			WebElement prod = getItem(itemList.get(i));
			prod.findElement(By.xpath(".//button[2]")).click();
//			Thread.sleep(500);
			waitForElementVisible(toast);
			waitForElementInvisible(animator);
		}
		
		goTo("cart");
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	
}
