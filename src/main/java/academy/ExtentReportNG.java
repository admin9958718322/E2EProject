package academy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportNG {

		static ExtentTest test;
		static ExtentReports extent;

		public static ExtentReports getReportObject() {
			System.out.println("Dir:::"+System.getProperty("user.dir"));
			extent = new ExtentReports(System.getProperty("user.dir") + "\\reports\\index.html");
			
			extent.addSystemInfo("Environment", "QA");
			extent.addSystemInfo("User Name", "Guest");
			
			test = extent.startTest("E2EProjectAutomationResult");
			
			return extent;
							
		}
	}
