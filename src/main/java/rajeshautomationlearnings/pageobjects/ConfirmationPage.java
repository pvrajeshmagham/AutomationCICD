package rajeshautomationlearnings.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	//String confirMmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getConfirmationMessage()
	{
		
		return confirmMessage.getText();
	}



}
