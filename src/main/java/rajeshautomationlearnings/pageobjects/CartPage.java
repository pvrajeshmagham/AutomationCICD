package rajeshautomationlearnings.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//*[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	//List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	public Boolean verifyProductDisplay(String productName)
	{
		
		Boolean match = cartProducts.stream()
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
