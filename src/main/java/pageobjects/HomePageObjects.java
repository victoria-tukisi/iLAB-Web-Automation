package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
		
	By career = By.linkText("CAREERS");
	//By career = By.xpath("//a[contains(text(), 'CAREERS')]");
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement gotoCareers() {
		return driver.findElement(career);
	}

	
}
