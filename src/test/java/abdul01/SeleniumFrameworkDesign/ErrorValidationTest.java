package abdul01.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import abdul01.SeleniumFrameworkDesign.TestComponents.BaseTest;
import abdul01.SeleniumFrameworkDesign.TestComponents.Retry;
import abdul01.SeleniumFrameworkDesign.pageobjects.CartPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.LandingPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {
	//ExtentReports extent;
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() {
		//instead of system.setproperties we are using webdriver manager
		String productname="ZARA COAT 3";
	
	  
		
		landingpage.loginApplication("abdulrazak@yopmail.com","Abdul@12345");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		
}
	/*@Test
	public void ProductErrorValidation() throws Exception {
		String productname="ZARA COAT 3";
		//launchApplication();
		ProductCatalogue productcatelog=landingpage.loginApplication("abdulrazak@yopmail.com","Abdul@1234");
		productcatelog.getProductList();
		productcatelog.addProducttoCart(productname);
		Thread.sleep(3000);
		CartPage cartpage=productcatelog.gotoCartPage();
		boolean match = cartpage.match("ZARA COAT 33");
		Assert.assertFalse(match);

}*/
}