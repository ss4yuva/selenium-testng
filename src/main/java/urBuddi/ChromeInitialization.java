package urBuddi;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeInitialization {
	static WebDriver driver;
	static WebDriverWait wait;
	static ChromeDriver chrome;
	CommonMethods cm;

	
	public ChromeInitialization(WebDriverWait w, WebDriver d, ChromeDriver c) {
		this.driver = d;
		this.wait = w;
		this.chrome = c;
	}
	
	public void chrome(){

	driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver",
			"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
	driver.manage().window().maximize();

	driver.get("https://dev.urbuddi.com/login");

//	wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}
}
