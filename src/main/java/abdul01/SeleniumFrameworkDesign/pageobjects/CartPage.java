package abdul01.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdul01.SeleniumFrameworkDesign.AbstractComponents.AbstractComponenet;

public class CartPage extends AbstractComponenet{
WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
@FindBy (css=".cartSection h3")
List<WebElement> productTitles;
@FindBy(css=".totalRow button")
WebElement checkout;
public boolean match(String productname) {
	boolean match=productTitles.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
	return match;
}
public CheckoutPage gotoCheckout() {
	checkout.click();
	return new CheckoutPage(driver);
}
}
