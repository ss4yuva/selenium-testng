package urBuddi.BasicLevel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC006LoginFunctionalityUsingMethods {

	static WebDriver driver;
	static WebDriverWait wait;

	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By dashboard = By.xpath("(//*[text()='Dashboard'])[2]");
	By lagoutButton = By.xpath("//*[@class='logout-btn-nav']");
	By logoutPopupYes = By.xpath("//*[text()='Yes']");

	By invalidCredentialsError = By.xpath("//*[@class='err-msg-display mt-3']");
	By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");
	By emailError = By.xpath("(//*[text()='*required'])[1]");
	By passwordError = By.xpath("(//*[text()='*required'])[2]");
	By forgotPasswordHeaderText = By.xpath("//*[text()='Forgot Password']");
	By forgotPasswordEmailInputField = By.name("email");
	By forgotpasswordGenerateOTP = By.xpath("//*[@class='generateOtp']");
	By forgotPasswordGenerateOTPError = By.xpath("//*[text()='Email not found']");

	public void loginToAppliction(String userName, String password) {
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(lagoutButton));
		wait.until(ExpectedConditions.elementToBeClickable(lagoutButton));
		driver.findElement(lagoutButton).click();
		driver.findElement(logoutPopupYes).click();
	}

	public void loginToAppliction1(String userName, String password) {
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		TC006LoginFunctionalityUsingMethods obj = new TC006LoginFunctionalityUsingMethods();

		obj.loginToAppliction("suresh.salloju@openskale.com", "New@2024");
		Thread.sleep(5000);
		obj.loginToAppliction1("", "");
		Thread.sleep(5000);
		obj.loginToAppliction1("ss4yuvan@gmail.com", "sruthi1234");
		Thread.sleep(5000);
		obj.loginToAppliction1("suresh.salloju@openskale.com", "Sruthi@123");
		Thread.sleep(5000);
		obj.loginToAppliction1("ss4yuvan@gmail.com", "suresh_123");
		Thread.sleep(5000);

		driver.close();
	}

}
