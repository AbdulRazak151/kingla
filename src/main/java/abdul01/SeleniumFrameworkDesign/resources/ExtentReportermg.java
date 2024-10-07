package abdul01.SeleniumFrameworkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportermg {
public static ExtentReports getReportObject() {
	//Extent Reports, Extent Spark Reporter
		String path=System.getProperty("user.dir")+"\\reports/index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		//report name 
		reporter.config().setReportName("Web Automation Results");
		//title
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent=new ExtentReports();
		//attach complement reports
		extent.attachReporter(reporter);
		//tester name
		extent.setSystemInfo("Tester","Rahul Shetty");
	return extent;
}
}
