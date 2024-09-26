package urBuddi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunctionalityUsingMenthods1 {

	static WebDriver driver;
	static WebDriver wait;

	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By lagoutButton = By.xpath("//*[@class='logout-btn-nav']");
	By logoutPopupYes = By.xpath("//*[text()='Yes']");

	public void loginToApplication(String userName, String password) throws InterruptedException {
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(15000);
	}

	public void loginToApplicationWithBlank() throws InterruptedException {
		driver.findElement(loginButton).click();
		Thread.sleep(15000);
	}

	public void loginWithInvalid(String userName, String password) throws InterruptedException {
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
		driver.findElement(lagoutButton).click();
		driver.findElement(logoutPopupYes).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		WebDriver wait = (WebDriver) new WebDriverWait(driver, Duration.ofSeconds(1000));

		LoginFunctionalityUsingMenthods1 obj = new LoginFunctionalityUsingMenthods1();
		obj.loginToApplication("govardhan.gottemukkula@openskale.com", "Govardhan_123");
		obj.loginToApplicationWithBlank();
		obj.loginWithInvalid("ss4yuvan@gmail.com", "sruthi@123");
	}

}
