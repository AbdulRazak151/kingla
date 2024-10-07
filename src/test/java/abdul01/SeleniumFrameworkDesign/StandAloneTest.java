package abdul01.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abdul01.SeleniumFrameworkDesign.TestComponents.BaseTest;
import abdul01.SeleniumFrameworkDesign.pageobjects.CartPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.LandingPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.OrderPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest{
	String productname="ZARA COAT 3";
	private String file="C:\\Users\\Abdul Razak\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\abdul01\\SeleniumFrameworkDesign\\Data\\PurchaseOrder.json";
@Test(dataProvider="getData",groups= {"Purchase"})
public void submitOrder(HashMap <String,String> input) throws Exception {
	
	//instead of system.setproperties we are using webdriver manager
	//String productname="ZARA COAT 3";
	//launchApplication();
	ProductCatalogue productcatelog=landingpage.loginApplication(input.get("email"),input.get("password"));
	productcatelog.getProductList();
	productcatelog.addProducttoCart(input.get("product"));
	Thread.sleep(3000);
	CartPage cartpage=productcatelog.gotoCartPage();
	boolean match = cartpage.match(input.get("product"));
	Assert.assertTrue(match);
	CheckoutPage checkoutpage=cartpage.gotoCheckout();
	checkoutpage.selectCountry("india");
	ConfirmationPage confirmation=checkoutpage.submitOrder();
	String verifyConfirmationMessage = confirmation.verifyConfirmationMessage();
	Assert.assertTrue(verifyConfirmationMessage.equalsIgnoreCase("Thankyou for the order."));
	
	
	
}
// To verify Zara Coat 3 is displaying in orders page
@Test(dependsOnMethods= {"submitOrder"})
public void OrderHistoryTest() {
	//"Zara Coat 3"
	ProductCatalogue productcatelog=landingpage.loginApplication("abdulrazak@yopmail.com","Abdul@1234");
	OrderPage orderpage=	productcatelog.gotoOrderPage();
	Assert.assertTrue(orderpage.verifyProductMatch(productname));
	
	
}
@DataProvider
public Object[][] getData() throws Exception {
/*	HashMap<Object,Object> map=new HashMap<Object,Object>();
	map.put("email", "abdulrazak@yopmail.com");
	map.put("password", "Abdul@1234");
	map.put("product","ZARA COAT 3");
	HashMap<Object,Object> map1=new HashMap<Object,Object>();
	map1.put("email", "abdulrazakt11@yopmail.com");
	map1.put("password", "Abdul@1234");
	map1.put("product","ADIDAS ORIGINAL");*/
	List<HashMap<String, String>> jsonDataToMap = getJsonDataToMap(file);
	return  new Object[][] {{jsonDataToMap.get(0)},{jsonDataToMap.get(1)}};
	
}



/*@DataProvider
public void Object[][] Object[][] getdata(){
	return  new Object[][] {{"",""},{"",""}}
}*/
/*@DataProvider
public Object[][] getData() {
	HashMap<Object,Object> map=new HashMap<Object,Object>();
	map.put("email", "abdulrazak@yopmail.com");
	map.put("password", "Abdul@1234");
	map.put("product","ZARA COAT 3");
	HashMap<Object,Object> map1=new HashMap<Object,Object>();
	map1.put("email", "abdulrazakt11@yopmail.com");
	map1.put("password", "Abdul@1234");
	map1.put("product","ADIDAS ORIGINAL");

	
	return  new Object[][] {{map},{map1}};}*/
	
}
