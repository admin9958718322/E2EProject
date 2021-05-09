package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	/*
	 * This line is only needed if we want to rul testing in parallel mode. If we
	 * dont keep local browser, then all classes will open the browser and override
	 * each others, which will create the issue. hence to overcome, we need to assign one local browser driver in each test class.
	 */
	WebDriver driver; 
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver initialized");
		
	}

	@Test(dataProvider = "getData")
	public void HomePage(String UserName, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		
		LoginPage lp = l.getLogin();
		
		
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		lp.getButton().click();
		
		ForgotPassword fp = lp.forgotPassword();
		
		fp.getEmail_FP().sendKeys("msingh06@outlook.com");
		fp.getSendIns().click();

	}

	
	  @AfterTest public void closeDriver() { driver.close();
	  
	  }
	 

	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[2][2];

		data[0][0] = "msingh06@outlook.com";
		data[0][1] = "123456";

		data[1][0] = "maya.singh2006.com";
		data[1][1] = "121212";

		return data;
	}

}
