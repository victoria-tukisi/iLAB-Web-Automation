# iLAB-Web-Automation : https://www.ilabquality.com/

Instructions to run the Project

Install the latest Eclipse IDE, and follow the steps: 
+ Clone or Download project from GitHut
+ Save the project in a desired location on your machine e.g Desktop
+ Import the project in Eclipse IDE
+ Expand the iLAB_WEB project folders:
+ Make string-path changes in the following classes:
  - base.java - For example my location is "C:\\Users\\Victoria\\iLAB_WEB\\src\\main\\java\\resources\\data.properties" and yours will be different
  - ExcelDataDriven.java - For example my location is "C:\\Users\\Victoria\\iLAB_WEB\\ExcelData.xlsx" and yours will be different

----------------------------------------------------------

Next, you can run the project, by using two options:
	Option 1: Using TestNG
		Right-click on the testng.xml file to run all the test scripts using TestNG, 
		examine the some output on the console tab
		
After successfully running the test scripts, 
right-click the iLAB_WEB project and select refresh.
To view the test reports: 
Open the test-output folder, 
Right-click the ExtentReportsTestNG.html, 
Select Properties, 
Copy the "Location" path-address, 
Navigate to any broswer e.g chrome, firefox and 
paste the copied address and examine the report and test results 
Notice that I purposely made one validation test to fail, 
specifically on ValidateJobApplicationFormTest.java class
- so that you will notice the beauty of the report. :-)


---------------------------------------------------------------------
	Option 2: Using Maven
		 Open the command prompt 
		 Change directory to the location of the project e.g C:...\Desktop\iLAB_WEB 
		 Run the program by using maven commands: > mvn clean 	
							: > mvn compile 
							: > mvn test 

After successfully running the test scripts, 
right-click the iLAB_WEB project and select refresh.
To view the test reports: 
Open the test-output folder, 
Right-click the ExtentReportsTestNG.html, 
Select Properties, 
Copy the "Location" path-address, 
Navigate to any broswer e.g chrome, firefox and 
paste the copied address and examine the report and test results 
Notice that I purposely made one validation test to fail, 
specifically on ValidateJobApplicationFormTest.java class
- so that you will notice the beauty of the report. :-)

In order to read data from Excel for iLAB_WEB
Change the string path of the FileInputStream according to the location of the excel file.
For example my location is "C:\\Users\\Victoria\\iLAB_WEB\\ExcelData.xlsx" and yours might be different




			********************************* THE END *********************************
