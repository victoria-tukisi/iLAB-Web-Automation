package iLAB_WEBSITE;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.CareersPageObjects;
import pageobjects.HomePageObjects;
import pageobjects.JobApplicationFormPageObjects;
import pageobjects.JobOpeningsPagesObjects;
import resources.base;

public class OnlineJobApplicationTest extends base {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = InitializeDriver();
		System.out.println("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void applyJobOnline() throws InterruptedException {
		HomePageObjects homepage = new HomePageObjects(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		CareersPageObjects careers = new CareersPageObjects(driver);
		JobOpeningsPagesObjects jobs = new JobOpeningsPagesObjects(driver);
		JobApplicationFormPageObjects jobform = new JobApplicationFormPageObjects(driver);

		homepage.gotoCareers().click();
		jse.executeScript("arguments[0].scrollIntoView()", careers.getLocation());
		careers.getLocation().click();
		jobs.getJob().click();
		jse.executeScript("arguments[0].scrollIntoView()", jobform.applyOnline());
		jobform.applyOnline().click();
		Thread.sleep(3000L);
		jobform.getName().sendKeys("Tester");
		jobform.getEmail().sendKeys("automationAssessment@iLABQuality.com");
		jobform.getPhoneNr().sendKeys(jobform.generateRandomPhoneNumbers());
		jobform.getMessage().sendKeys("This is an automated message.");
		jobform.sendApplication().click();
		Thread.sleep(3000L);
		// validating the attachment field
		Assert.assertTrue(jobform.isFilesUploaded().isDisplayed());
		System.out.println("Validation passed!!!"
				+ "\n Verified that the text 'You need to upload at least one file.' is displayed on the Job Application Form");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
