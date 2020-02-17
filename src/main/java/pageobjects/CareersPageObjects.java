package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPageObjects {
	public WebDriver driver;
		
	By location = By.linkText("South Africa");
	
	public CareersPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getLocation()
	{
		return driver.findElement(location);
	}
	
			
}
