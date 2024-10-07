package abdul01.SeleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import abdul01.SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public  WebDriver driver;
	 protected LandingPage landingpage;
public WebDriver initializeDriver() throws Exception {
	
	//Properties class
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream("C:\\Users\\Abdul Razak\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\abdul01\\SeleniumFrameworkDesign\\resources\\GlobalData.properties");
	prop.load(file);
	//browser name passing from cmd maven
	
	String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	//String browserName = prop.getProperty("browser");
	if(browserName.contains("chrome")) {
	
	WebDriverManager.chromedriver().setup();
	//To run browser in head less mode(running in back end without showing execution in front end)
	
	ChromeOptions options=new ChromeOptions();
	if(browserName.contains("headless"))
	{
	options.addArguments("headless");
	}
	 driver=new ChromeDriver(options);
	 
	

}
	else if(browserName.contains("firefox")) {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Abdul Razak\\eclipse-workspace\\Java Project\\geckodriver.exe");
	   driver=new FirefoxDriver();
	   driver.manage().window().setSize(new Dimension(1440,900));
	}
	else if(browserName.contains("edge")) {
		//edge
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
}
@BeforeMethod(alwaysRun=true)
 public LandingPage launchApplication() throws Exception {
	 driver=initializeDriver();
	  landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
 }
public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws Exception {
	 
    String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
    //String to Hashmap  jackson databind
    ObjectMapper mapper=new ObjectMapper();
    List <HashMap<String,String>> data= mapper.readValue(jsonContent, new  TypeReference<List<HashMap<String,String>>>(){});
    //return {map1,map2}
    return data;
}
public String getScreenshot(String testcaseName, WebDriver driver) throws Exception {
  TakesScreenshot ts= (TakesScreenshot) driver;
  File source = ts.getScreenshotAs(OutputType.FILE);
  File file=new File("C:\\Users\\Abdul Razak\\eclipse-workspace\\SeleniumFrameworkDesign"+"//reports"+testcaseName+".png");
  FileUtils.copyFile(source,file);
  return "C:\\Users\\Abdul Razak\\eclipse-workspace\\SeleniumFrameworkDesign"+"//reports"+testcaseName+".png";
}
/*@AfterMethod
public void tearDown() {
	driver.close();
}*/
//Extent Reports attach screen shots
}
