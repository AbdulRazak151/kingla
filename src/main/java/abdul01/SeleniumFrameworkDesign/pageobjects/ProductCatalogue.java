package abdul01.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdul01.SeleniumFrameworkDesign.AbstractComponents.AbstractComponenet;

public class ProductCatalogue extends AbstractComponenet
{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver){
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//WebElement userEmail=	driver.findElement(By.id("userEmail"));
//PageFactory
@FindBy(css=".mb-3")
List<WebElement> productList;
@FindBy(css="b")
WebElement products;
@FindBy(css=".ng-animating")
WebElement spinner;
@FindBy(css="[routerlink*='cart']")
WebElement addtoCart;
By findBy=By.cssSelector(".mb-3");
By addToCart=By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.cssSelector("#toast-container");
By GetText=By.cssSelector("b");
public List<WebElement> getProductList() {
	waitForElementToAppear(findBy);
	return productList;
}
public WebElement getproductByName(String productname) {
	WebElement prod = productList.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	productList.stream().filter(product->product.findElement(GetText).getText().equals(productname)).findFirst().orElse(null);
	return prod;
}
public void addProducttoCart(String productname) throws InterruptedException {
	WebElement prod=getproductByName(productname);
	prod.findElement(addToCart).click();
	waitForElementToAppear(toastMessage);
	waitforElementToDisappear(spinner);

	
}

}