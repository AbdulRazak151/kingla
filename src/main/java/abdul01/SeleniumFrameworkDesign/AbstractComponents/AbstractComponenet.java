package abdul01.SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abdul01.SeleniumFrameworkDesign.pageobjects.CartPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.OrderPage;

public class AbstractComponenet {
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cartHeader;
	WebDriver driver;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
public AbstractComponenet(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}

		
public void waitForElementToAppear(By findBy ) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
public void waitForWebElementToAppear(WebElement findBy ) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOf(findBy));
}
public void waitforElementToDisappear(WebElement ele) throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	Thread.sleep(3000);
}
public CartPage gotoCartPage() {
	cartHeader.click();
	CartPage cartpage=new CartPage(driver);
	return cartpage;
}
public OrderPage gotoOrderPage() {
	orderHeader.click();
	OrderPage orderPage=new OrderPage(driver);
	return orderPage;
}
}
