package iLAB_WEBSITE;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.JobApplicationFormPageObjects;
import resources.base;
/*
 * Here we want to test validate the mandatory field before sending the application
 * This particular test focuses on validating if the required file/s had been uploaded
 */
public class ValidateJobApplicationFormTest extends base
{
	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
		System.out.println("Driver is initialized");
		driver.get("https://www.ilabquality.com/job/senior-test-automation-specialist-cape-town-2/");
	}
	
	@Test
	public void validateRequiredFieldsOnJobForm() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		JobApplicationFormPageObjects jobform = new JobApplicationFormPageObjects(driver);
				
		jse.executeScript("arguments[0].scrollIntoView()", jobform.applyOnline());
		jobform.applyOnline().click();
		Thread.sleep(3000L);
		jobform.sendApplication().click();
		
		//After clicking the send application button the form validates whether the file/s were uploaded or not, 
		//Below I used two methods to check if validation took place:
		jse.executeScript("arguments[0].scrollIntoView()", jobform.isFilesUploaded());  //scroll to view the attachment field
		Thread.sleep(3000L);
		//Method 1: Comparing if a particular text exists from the "Job Application Form", (Expected versus Actual)		
				Assert.assertEquals("You121 need to upload at least one file.", jobform.isFilesUploaded().getText()); 
				System.out.println("Validation method 1 passed, 'You need to upload at least one file.' text exist");		
				
		//Method 2: Verify that the text "You need to upload at least one file." is displayed on the "Job Application Form"
				Assert.assertTrue(jobform.isFilesUploaded().isDisplayed());
				System.out.println("Validation method 2 passed, 'You need to upload at least one file.' text is displayed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;  
	}
}