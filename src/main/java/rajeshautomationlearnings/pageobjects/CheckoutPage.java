package rajeshautomationlearnings.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rajeshautomationlearnings.AbstactComponenets.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement enterName;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;

	// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]"))

	@FindBy(css = ".action__submit")
	WebElement submit;

	// driver.findElement(By.cssSelector(".action__submit"))

	// driver.findElement(By.cssSelector("[placeholder='Select Country']"))

	By results = By.cssSelector(".ta-results");
	

	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(enterName, countryName).build().perform();
		waitForElementToAppear(results);		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		selectCountry.click();
		
	}

	public ConfirmationPage submitOrder() 

	{
		Actions a = new Actions(driver);
		a.scrollToElement(submit).build().perform();		
		submit.click();

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;

	}

}
