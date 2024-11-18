package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListpage {
	
	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	WebElement itemOne;
	
	@FindBy(id= "add-to-cart-sauce-labs-bike-light")
	WebElement itemTwo;
	
	@FindBy(id= "shopping_cart_container")
	WebElement cartIcon;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	WebElement productsTitle;

	//Actions
	//add to cart
	//view cart

  public ProductListpage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  public void addToCart() {
	  itemOne.click();
	  itemTwo.click();
	  
  }
  public void viewCart() {
	  cartIcon.click();
	  
  }
  public boolean isOnproducts() {
	  return productsTitle.isDisplayed();
  }
}