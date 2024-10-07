package abdul01.SeleniumFrameworkDesign.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdul01.SeleniumFrameworkDesign.AbstractComponents.AbstractComponenet;

public class CheckoutPage extends AbstractComponenet {
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy (css="input[placeholder=\"Select Country\"]")
WebElement country;
@FindBy(xpath="//a[text()='Place Order ']")
WebElement submit;
@FindBy(xpath="(//*[contains(@class,'ta-item')])[2]")
WebElement selectCountry;
public void selectCountry(String countryName) throws Exception {
	Actions a=new Actions(driver);
	 a.sendKeys(country, countryName).build().perform();
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
	 waitForElementToAppear( By.cssSelector(".ta-item"));
	 selectCountry.click();
	 
	Thread.sleep(4000);
}

public ConfirmationPage submitOrder() throws Exception {
	JavascriptExecutor js= (JavascriptExecutor) driver;
	 js.executeScript("window.scroll(0,250)");
	Thread.sleep(4000);
	submit.click();
	return new ConfirmationPage(driver);
}



}
