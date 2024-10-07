package rajeshautomationlearnings.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNG {
	
	
	public static ExtentReports getReportObject()
	{
		
		
		//1. ExtentReports 2. ExtentSparkReporter
		
				String path =  System.getProperty("user.dir")+ "//reports//index.html";		
				ExtentSparkReporter reporter =  new ExtentSparkReporter(path);		
				reporter.config().setReportName("Web Automation Results");		
				reporter.config().setDocumentTitle("Test Results");		
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Rajesh");
				return extent;
	}

}
