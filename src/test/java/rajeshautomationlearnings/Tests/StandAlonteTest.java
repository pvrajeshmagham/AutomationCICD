package rajeshautomationlearnings.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rajeshautomationlearnings.pageobjects.Landingpage;

public class StandAlonteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productname = "ZARA COAT 3";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		Landingpage landingpage = new Landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("student@rajeshlearnings.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rajeshlearning@1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		// System.out.println(products.size());
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		/**
		 * driver.findElement(By.cssSelector("[placeholder='Select
		 * Country']")).sendKeys("ind");
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 * 
		 * List <WebElement> Options =
		 * driver.findElements(By.cssSelector(".ta-results"));
		 * 
		 * Options.stream().filter(option->option.getText().equalsIgnoreCase(country));
		 * 
		 * for (WebElement option:Options) {
		 * 
		 * if (option.getText().equalsIgnoreCase(country)) {
		 * 
		 * option.click(); break;
		 * 
		 * } }
		 **/

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		// driver.findElement(By.cssSelector(".btnn")).click();
		a.scrollToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirMmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		// equalsIgnoreCase("Thankyou for the order.");

		Assert.assertTrue(confirMmessage.equalsIgnoreCase("Thankyou for the order."));

	}

}
