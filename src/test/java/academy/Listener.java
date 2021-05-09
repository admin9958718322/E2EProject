package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener extends base implements ITestListener {

	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;

	// the below step is needed if we need to run parallel execution for all tests.
	// In this case for all the tests to not override each other, we are putting in
	// to the thread safe pool.
	// In all below listeners steps the file will be called from threadlocal pool.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.startTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(LogStatus.PASS, "Testcase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();

		// the below step is needed to call the driver instance of the running test
		// got failed and give the life to driver in this block.
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		extentTest.get().log(LogStatus.FAIL, result.getThrowable());
		extentTest.get().log(LogStatus.FAIL, "Testcase Failed");
		try {
			extentTest.get().log(LogStatus.FAIL, extentTest.get().addScreenCapture(getScreenshotPath(testMethodName, driver)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(LogStatus.SKIP, "Testcase skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.endTest(test);
		extent.flush();
		
	}

}
