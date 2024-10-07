package rajeshautomationlearnings.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css= "tr td:nth-child(3)")
	List<WebElement> productNames;
	//List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	public Boolean verifyorderDisplay(String productName)
	{
		
		Boolean match = productNames.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	public CheckoutPage goToCheckout()
	{
		checkOutEle.click();
		
	CheckoutPage checkoutPage	=new CheckoutPage(driver);
			
		return checkoutPage;
	}

}
