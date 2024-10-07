package rajeshautomationlearnings.Stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rajeshautomationlearnings.Testcomponents.BaseTest;
import rajeshautomationlearnings.pageobjects.CartPage;
import rajeshautomationlearnings.pageobjects.CheckoutPage;
import rajeshautomationlearnings.pageobjects.ConfirmationPage;
import rajeshautomationlearnings.pageobjects.Landingpage;
import rajeshautomationlearnings.pageobjects.ProductCatalog;

public class StepDefintionImple extends BaseTest {

	public Landingpage landingpage;
	public ProductCatalog prodcutCatalog;
	public ConfirmationPage confirmationPage;

	@Given("I landed on e-Commerce page")
	public void I_landed_on_eCommerce_page() throws IOException {
		landingpage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {

		prodcutCatalog = landingpage.loginApplication(username, password);

	}

	@When("^I add product (.+) from cart$")

	public void I_add_product_from_cart(String productname)

	{

		List<WebElement> products = prodcutCatalog.getProdctList();
		prodcutCatalog.addProductToCart(productname);

	}

	@When("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productname)

	{
		CartPage cartPage = prodcutCatalog.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Ind");
		confirmationPage = checkoutPage.submitOrder();
	}

	@Then("{string} message displayed on confirmation page")

	public void message_displayed_on_confiramtion_page(String string)

	{

		String confirMmessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirMmessage.equalsIgnoreCase(string));
		
	driver.close();
	}
	
	@Then("{string} message is displayed")
	
	public void Error_message_is_displayed(String string)
	
	{
		Assert.assertEquals(string, landingpage.getErrorMessage());
	}

}
