package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

public WebDriver driver;
//By signin= By.cssSelector("a[href*='sign_in']");
By signin=By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");
By text=By.xpath("//div[@class='text-center']/h2");
By nav=By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav");

public LandingPage(WebDriver driver)
{
	this.driver=driver;
}

public LoginPage getLogin()
{
	 driver.findElement(signin).click();
	  return new LoginPage(driver);
	  
	
	 
}

public WebElement verifyText()
{
	return driver.findElement(text);
	 
}

public WebElement verifyNavBar()
{
	return driver.findElement(nav);
	 
}

}
