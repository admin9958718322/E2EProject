package academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

public class VerifyTitle extends base {
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
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void VerifyTitle() throws IOException {

		LandingPage l = new LandingPage(driver);
		assertEquals(l.verifyText().getText(), "FEATURED COURSES");
		log.info("Successfully validated the text message");
		
	}

	
	  @AfterTest public void closeDriver() { driver.close();
	  
	  }
	 
}