package rajeshautomationlearnings.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//WebElement userPassword = driver.findElement(By.id("userPassword"));
	//WebElement login = driver.findElement(By.id("login"));
	//PageFactory
	@FindBy(id= "userEmail")
	WebElement userEmail;
	
	@FindBy(id ="userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;
	
	//ng-tns-c4-3 toast-message ng-star-inserted
	@FindBy(css = ".ng-star-inserted")
	WebElement errorMessage;
	
	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	public ProductCatalog loginApplication(String email, String password)
	
	{
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		
		ProductCatalog prodcutCatalog = new ProductCatalog(driver);
		return prodcutCatalog;
		
	}
	
	
	public String getErrorMessage()
	
	{
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
}
