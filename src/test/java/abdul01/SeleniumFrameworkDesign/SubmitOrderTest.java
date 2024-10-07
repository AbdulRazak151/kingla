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

import abdul01.SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {
public static void main(String[] args) throws Exception {
	//instead of system.setproperties we are using webdriver manager
	String productname="ZARA COAT 3";
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	driver.get("https://rahulshettyacademy.com/client/");
	LandingPage landingPage=new LandingPage(driver);
	driver.findElement(By.id("userEmail")).sendKeys("abdulrazak@yopmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Abdul@1234");
	driver.findElement(By.cssSelector("input[id='login']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod = productList.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//anymatch function help us to iterate and match for the text
	 boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
	 Assert.assertTrue(match);
	 driver.findElement(By.cssSelector(".totalRow button")).click();
	 Actions a=new Actions(driver);
	 a.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")), "india").build().perform();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
	 
	 driver.findElement(By.xpath("(//*[contains(@class,'ta-item')])[2]")).click();
	JavascriptExecutor js= (JavascriptExecutor) driver;
	 js.executeScript("window.scroll(0,250)");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	 
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
   
	
	
}
}
