package abdul01.SeleniumFrameworkDesign.TestComponents;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import abdul01.SeleniumFrameworkDesign.resources.ExtentReportermg;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReportermg.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
		extentTest.set(test);//Unique thread id(error validation test()-->
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");	
	}
	@Override
	public void onTestFailure(ITestResult result) {
	
		
		extentTest.get().fail(result.getThrowable());
	//take screen shot and attach to reports
	//get the driver from the ItestResult because it stores actual driver testcase class
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			String screenshotpath = null;
			try {
				screenshotpath = getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			extentTest.get().addScreenCaptureFromPath(screenshotpath,result.getMethod().getMethodName());
	    
		

}
	@Override
	public void onFinish(ITestContext result) {
		extent.flush();
		
		
	}
}
