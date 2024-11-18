package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutpage {
	
	@FindBy(id ="first-name")
	WebElement firstname;
	
	@FindBy(id ="last-name")
	WebElement lasttname;

	@FindBy(id ="postal-code")
	WebElement zipcode;
	
	@FindBy(id ="continue")
	WebElement contbtn;
	
	@FindBy(id ="finish")
	WebElement finish;
	
	@FindBy(css= "h2.complete-header")
	WebElement successMSg;
	
	public CheckOutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void provideDetails(String strFn, String strln, String strZc) {
	firstname.sendKeys(strFn);
	lasttname.sendKeys(strln);
	zipcode.sendKeys(strZc);
	contbtn.click();
	}
	public void checkoutOrder() {
	finish.click();
	}
	  public boolean isOrderSuccess() {
		  return successMSg.isDisplayed();
}
}

