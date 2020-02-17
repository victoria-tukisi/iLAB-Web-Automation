package pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobApplicationFormPageObjects {
public WebDriver driver;
	
	By btnApplyOnline = By.partialLinkText("Apply Onli");
	By name = By.xpath("//input[@id='applicant_name']");
	By email = By.cssSelector("#email");
	By phone = By.xpath("//input[@id='phone']");
	By message = By.xpath("//textarea[@id='message']");
	By btnSendApplication = By.cssSelector("#wpjb_submit");
	By validateFileUploads = By.xpath("//li[contains(text(),'You need to upload at least one file.')]");
	
	
	public JobApplicationFormPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement applyOnline()
	{
		return driver.findElement(btnApplyOnline);
	}
	public WebElement getName()
	{
		return driver.findElement(name);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPhoneNr()
	{
		return driver.findElement(phone);
	}
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
	public WebElement sendApplication()
	{
		return driver.findElement(btnSendApplication);
	}
	public WebElement isFilesUploaded()
	{
		return driver.findElement(validateFileUploads);
	}
	public String generateRandomPhoneNumbers()
	{
		int num1=0;
        int num2, num3; 
        int pair3, pair4;
        
        Random generator = new Random();        
         
        num2 = generator.nextInt(8); 
        num3 = generator.nextInt(8);
        
        pair3 = generator.nextInt(899) + 100;
        pair4 = generator.nextInt(8999) + 1000;
        
        String phoneNumbers = num1 + "" + num2 + "" + num3 + " " + pair3 + " " + pair4 ;
        
        return phoneNumbers;
		
	}
}
