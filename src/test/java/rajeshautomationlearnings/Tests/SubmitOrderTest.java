package rajeshautomationlearnings.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rajeshautomationlearnings.Testcomponents.BaseTest;
import rajeshautomationlearnings.pageobjects.CartPage;
import rajeshautomationlearnings.pageobjects.CheckoutPage;
import rajeshautomationlearnings.pageobjects.ConfirmationPage;
import rajeshautomationlearnings.pageobjects.OrderPage;
import rajeshautomationlearnings.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {
	String productname = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "PurchaseOrder")
	public void SubmitOrder(HashMap<String, String> input) throws IOException {

		ProductCatalog prodcutCatalog = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = prodcutCatalog.getProdctList();
		prodcutCatalog.addProductToCart(input.get("productname"));
		// ng-animating
		CartPage cartPage = prodcutCatalog.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(input.get("productname"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Ind");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirMmessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirMmessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void orderHistoryTest() {
		ProductCatalog prodcutCatalog = landingpage.loginApplication("student@rajeshlearnings.com", "Rajeshlearning@1");
		OrderPage orderPage = prodcutCatalog.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyorderDisplay(productname));

	}

	// Extent Reports

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\rajeshautomationlearnings\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}

//three lines are removed its already indicated in landing page for usermail id
// and password and click on login
//removing the lines already indicated in Abstractcomponent for wait and in
// product catalog for prodcuts,getproductbyName, addProductToCart and CartPage
//I tried with given India also but not worked
//and tried with increase the wait time and used Thread.sleep also(When I used Thread able to select  country but click on place holder)
// but not working

// equalsIgnoreCase("Thankyou for the order.");

//HashMap<String,String> map = new HashMap<String,String>();
//
//map.put("email", "student@rajeshlearnings.com");
//map.put("password", "Rajeshlearning@1");
//map.put("productname", "ZARA COAT 3");
//
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//
//map1.put("email", "student@practice.com");
//map1.put("password", "Rajeshlearning@2");
//map1.put("productname", "ADIDAS ORIGINAL");
//return new Object [][] {{map}, {map1}};
