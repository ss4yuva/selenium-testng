package urBuddi.BasicJava;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationCommandstest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);

		driver.navigate().refresh();
		Thread.sleep(1000);
	}

}
