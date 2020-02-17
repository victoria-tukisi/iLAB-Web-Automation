package iLAB_WEBSITE;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.CareersPageObjects;
import pageobjects.HomePageObjects;
import pageobjects.JobApplicationFormPageObjects;
import pageobjects.JobOpeningsPagesObjects;
import resources.ExcelDataDriven;
import resources.base;

public class ParameterisedJobApplicationTest extends base {

	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = InitializeDriver();
	}

	@Test(dataProvider = "getData")
	// Parametrisation method to run multiple user data at the same time using
	// TestNG (@DataProvider)
	public void iLabJobApplication(String name, String email, String message) throws InterruptedException {
		driver.get(prop.getProperty("url"));

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
		jobform.getName().sendKeys(name);
		jobform.getEmail().sendKeys(email);
		jobform.getPhoneNr().sendKeys(jobform.generateRandomPhoneNumbers());
		jobform.getMessage().sendKeys(message);
		jobform.sendApplication().click();
		Thread.sleep(3000L);
		// validating the attachment field
		Assert.assertTrue(jobform.isFilesUploaded().isDisplayed());
		System.out.println("Validation passed!!!"
				+ "\nVerified that the text 'You need to upload at least one file.' is displayed on the Job Application Form");

	}

	// One way of storing and utilizing test data is by using testNG data-provider
	@DataProvider
	public Object[][] getData() throws IOException {
		Object[][] data = new Object[3][3];
		ExcelDataDriven edd = new ExcelDataDriven();
		ArrayList exceldata = edd.getData("QA Analyst");

		// first test data 1
		data[0][0] = "SQA Tester";
		data[0][1] = "automationAssessment@iLABQuality.com";
		data[0][2] = "This is an automated message.";

		// second test data 2
		data[1][0] = "QA Automation Tester";
		data[1][1] = "qatestautomation@iLABQuality.com";
		data[1][2] = "Note that this is an automated message.";

		// Another way of storing data is by utilizing excel test-data
		data[2][0] = exceldata.get(0).toString();
		data[2][1] = exceldata.get(1).toString();
		data[2][2] = exceldata.get(2).toString();

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null; // memory to not get waisted
	}
}
