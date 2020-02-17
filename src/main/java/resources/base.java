package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;

public WebDriver InitializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Victoria\\iLAB_WEB\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
				
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\Setups\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\Setups\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if (browsername.equals("msEdge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Work\\Setups\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
}
