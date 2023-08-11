package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementClick(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForElementClickByLoc(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void waitForElementVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementInvisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void goTo(String loc) {
		WebElement button = driver.findElement(By.cssSelector("button[routerlink*="+loc+"]"));
		waitForElementClick(button);
		button.click();
	}

}
