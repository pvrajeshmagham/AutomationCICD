package rajeshautomationlearnings.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rajeshautomationlearnings.Testcomponents.BaseTest;
import rajeshautomationlearnings.Testcomponents.Retry;
import rajeshautomationlearnings.pageobjects.CartPage;
import rajeshautomationlearnings.pageobjects.ProductCatalog;

public class ErrorValidationTest extends BaseTest {

	@Test (groups = {"ErrorValidation"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {
		landingpage.loginApplication("student@rajeshlearnings.com", "Rajeshlearning@1234");
		//ng-tns-c4-3 toast-message ng-star-inserted
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		//Assert.assertEquals("Incorrect email password.", landingpage.getErrorMessage());// intentionally changed the code (removed or) to fail the test for screenshot purpose			
	}
	
	@Test
	// This is just for example for taking another test
	public void productErrorValidation() throws IOException {
		String productname = "ZARA COAT 3";
		ProductCatalog prodcutCatalog = landingpage.loginApplication("student@rajeshlearnings.com", "Rajeshlearning@1");
		List<WebElement> products = prodcutCatalog.getProdctList();
		prodcutCatalog.addProductToCart(productname);
		// ng-animating
		CartPage cartPage = prodcutCatalog.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

}
}
