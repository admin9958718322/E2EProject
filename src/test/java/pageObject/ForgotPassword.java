package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	By EmailID_ForgotPassword = By.id("user_email");
	By SendMeInstructions = By.cssSelector("[type='submit']");
	//By SendMeInstructions = By.cssSelector("[value='Send Me Instruction']");
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail_FP() {
		return driver.findElement(EmailID_ForgotPassword);

	}
	
	public WebElement getSendIns() {
		return driver.findElement(SendMeInstructions);

	}
}
