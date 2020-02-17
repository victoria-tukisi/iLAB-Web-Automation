package iLAB_WEBSITE;

import java.io.IOException;
import java.util.ArrayList;

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
import resources.ExcelDataDriven;
import resources.base;

public class ExcelDrivenJobApplicatonTest extends base {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = InitializeDriver();
		System.out.println("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void applyJobOnline() throws InterruptedException, IOException {
		HomePageObjects homepage = new HomePageObjects(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		CareersPageObjects careers = new CareersPageObjects(driver);
		JobOpeningsPagesObjects jobs = new JobOpeningsPagesObjects(driver);
		JobApplicationFormPageObjects jobform = new JobApplicationFormPageObjects(driver);

		ExcelDataDriven edd = new ExcelDataDriven();
		ArrayList data = edd.getData("Test Engineer"); // change name data to test with a different job applicant

		homepage.gotoCareers().click();
		jse.executeScript("arguments[0].scrollIntoView()", careers.getLocation());
		careers.getLocation().click();
		jobs.getJob().click();
		jse.executeScript("arguments[0].scrollIntoView()", jobform.applyOnline());
		jobform.applyOnline().click();
		Thread.sleep(3000L);
		jobform.getName().sendKeys(data.get(0).toString());
		jobform.getEmail().sendKeys(data.get(1).toString());
		jobform.getPhoneNr().sendKeys(jobform.generateRandomPhoneNumbers());
		jobform.getMessage().sendKeys(data.get(2).toString());
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
