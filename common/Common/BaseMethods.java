package Common;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;

	String url;
	Properties obj;

	public WebDriver getDriver() {

		if (driver == null) {
			System.out.println("Before Test");
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",
					"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
			driver.manage().window().maximize();
		}
		return driver;
	}

	public Properties getPropertiesObj() throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\Automation\\selenium-testng\\test-data\\credentials.properties");
		obj = new Properties();
		obj.load(file);

		// url = p.getProperty("url");

		// driver = getDriver();
		// driver.get(url);

		return obj;
	}

}
