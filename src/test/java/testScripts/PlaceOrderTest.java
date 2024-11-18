package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cartpage;
import pages.CheckOutpage;
import pages.LoginPage;
import pages.ProductListpage;

public class PlaceOrderTest {
	  WebDriver driver;
	  LoginPage loginpage;
	  ProductListpage listPage;
	  Cartpage Cartpage;
	  CheckOutpage Checkoutpage;

	  
	  public PlaceOrderTest() {
	
		  TestBase.initdriver();
		  driver = TestBase.getDriver();
		  loginpage = new LoginPage(driver);
		  listPage = new ProductListpage(driver);
		  Cartpage = new Cartpage(driver);
		  Checkoutpage = new CheckOutpage(driver);
	  }
	  @BeforeTest
	  public void setup() {
		  TestBase.openUrl("https://www.saucedemo.com/");
		  loginpage.validLogin("standard_user", "secret_sauce");
	  }
	 
	 @Test
	 public void addItemTest() {
		 
		 boolean isOnProductPage = listPage.isOnproducts();
		 Assert.assertTrue(isOnProductPage);
		 listPage.addToCart();
		 listPage.viewCart();
		 Assert.assertTrue(Cartpage.isItemAdded());
	//   Assert.assertTrue(Checkoutpage.);
	 }
	@Test
	public void checkoutItems() {
		Cartpage.checkoutItems();
	}
//	@Test
//	public void checkoutPage() {
//		Checkoutpage.checkoutPage();
//	}
  }

