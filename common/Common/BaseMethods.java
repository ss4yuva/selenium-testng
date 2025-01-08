package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.LoginToApplication;

public class BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginToApplication loginPage;

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

}
