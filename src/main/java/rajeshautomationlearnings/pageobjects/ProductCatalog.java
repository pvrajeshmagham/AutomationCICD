package rajeshautomationlearnings.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		
		//initialization
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//PageFactory
	@FindBy(css= ".mb-3")
	List<WebElement> products;
	@FindBy(css= ".ng-animating")
	WebElement spinner;
	
	By prodcutsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By  toastMessage= By.cssSelector("#toast-container");
	//WebElement ele = driver.findElement(By.cssSelector(".ng-animating"));
	
	public List<WebElement> getProdctList()
	{
		
		waitForElementToAppear(prodcutsBy);
		return products;
	}
	
	
	public WebElement getproductByName(String productName)
	{
		
		WebElement prod = getProdctList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		
		return prod;
		
		
	}
	public void addProductToCart(String productName)
	{
		
		WebElement prod = getproductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementDisappear(spinner);
		
		
		
	}
		
	
}
