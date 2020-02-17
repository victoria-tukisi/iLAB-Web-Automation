package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobOpeningsPagesObjects {
	public WebDriver driver;
	
	By job = By.partialLinkText("Automation Specialist – Johannesburg");
	
	public JobOpeningsPagesObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getJob()
	{
		return driver.findElement(job);
	}

}
