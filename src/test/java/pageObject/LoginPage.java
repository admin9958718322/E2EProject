package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By Email = By.id("user_email");
	By Password = By.id("user_password");
	By LogButton = By.name("commit");
	By ForgotPasswordLink = By.cssSelector("[href*='password/new']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(Email);

	}

	public WebElement getPassword() {
		return driver.findElement(Password);

	}
	public WebElement getButton() {
		return driver.findElement(LogButton);

	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(ForgotPasswordLink).click();
		return new ForgotPassword(driver);
		

	}

}
