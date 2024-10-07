package rajeshautomationlearnings.AbstactComponenets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rajeshautomationlearnings.pageobjects.CartPage;
import rajeshautomationlearnings.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css= "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css= "[routerlink*='myorders']")
	WebElement orderHeader;
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	
	public void waitForElementToAppear(By findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public void waitForElementDisappear(WebElement ele)
	{
		// 4seconds - Application issue (its not consider as issue as per instructor because so many members at a time using the application for practice)
		// if you don't want to wait then use Thread.sleep instead of explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage()
	
	{
		
		cartHeader.click();
		
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrderPage goToOrdersPage()
	
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}

}
