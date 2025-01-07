package urBuddi.BasicTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC2LoginToApplicationTNDirectCode {
	static WebDriver driver;
	static WebDriverWait wait;

	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By dashboard = By.xpath("(//*[text()='Dashboard'])[2]");

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");
		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");

		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	}

	@Test
	public void verifyLoginIsSuccess() throws InterruptedException {
		System.out.println("Test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("suresh.salloju@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("New@2024");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		WebElement dashboardT = driver.findElement(dashboard);
		String dashboardText = dashboardT.getText();
		System.out.println("Dashboard text is: " + dashboardText);
		if (dashboardText.equals("Dashboard")) {
			System.out.println("Expected Dashboard text is showing");
		} else {
			System.out.println("Expected Dashbaord text is not showing");
		}
	}

	@AfterTest
	public void browserclose() {
		System.out.println("After Test");
		driver.close();
	}
}
