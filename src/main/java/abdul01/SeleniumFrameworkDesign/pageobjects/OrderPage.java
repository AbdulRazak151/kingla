package abdul01.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdul01.SeleniumFrameworkDesign.AbstractComponents.AbstractComponenet;

public class OrderPage extends AbstractComponenet{
WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
@FindBy (css="tr td:nth-child(3)")
List<WebElement> productNames;
@FindBy(css=".totalRow button")
WebElement checkout;
public boolean verifyProductMatch(String productname) {
	boolean match=productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
	return match;
}

}
