package StepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Cartpage;
import pages.CheckOutpage;
import pages.LoginPage;
import pages.ProductListpage;


public class OrderStepDef {
	  WebDriver driver = TestBase.getDriver();
	  LoginPage loginpage;
	  ProductListpage listPage;
	  Cartpage Cartpage;
	  CheckOutpage Checkoutpage;

	  
	  public OrderStepDef() {
		  loginpage = new LoginPage(driver);
		  listPage = new ProductListpage(driver);
		  Cartpage = new Cartpage(driver);
		  Checkoutpage = new CheckOutpage(driver);
	  }

@Given("User is on login page")
public void user_is_on_login_page() {
	  TestBase.openUrl("https://www.saucedemo.com/");   
    
}
@When("User enters {string}, {string}")
public void user_enters(String strUser, String strpwd) {
	loginpage.validLogin(strUser, strpwd);
	

}

@Given("User should be on Home page")
public void user_should_be_on_home_page() {
	Assert.assertTrue(listPage.isOnproducts());
}

@When("user add item to cart")
public void user_add_item_to_cart() {
	listPage.addToCart();

}
@Then("Item must be added")
public void item_must_be_added() {
listPage.viewCart();
Assert.assertTrue(Cartpage.isItemAdded());

}
@Given("User is on cart page")
public void user_is_on_cart_page() {
   listPage.viewCart();
}
@When("User do Checkout")
public void user_do_checkout() {
	Cartpage.checkoutItems();    
}
@Then("Should navigate to checkout page")
public void should_navigate_to_checkout_page() {
	Checkoutpage.provideDetails("Test","User","34343");
	Checkoutpage.checkoutOrder();
	Assert.assertTrue(Checkoutpage.isOrderSuccess());
}
}