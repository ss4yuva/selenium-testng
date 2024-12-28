package urBuddi.TestNG;

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

public class TC2LoginFunctionality {

	static WebDriver driver;
	static WebDriverWait wait;
	static String errorText, errorText1, errorText2;

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

	@BeforeTest
	public void pagelaunch() {
		System.out.println("Befor Test");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		System.out.println("Test1: Login With Valid Credentials");

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("suresh.salloju@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("suresh_123");
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
		driver.findElement(lagoutButton).click();
		driver.findElement(logoutPopupYes).click();
	}

	@Test(priority = 2)
	public void loginWithblankcredentials() {
		System.out.println("Test2: Login With blank credentials");

		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError));
		WebElement emailErrorMessage = driver.findElement(emailError);
		String emailErrorMessageText = emailErrorMessage.getText();
		System.out.println("Email error message is: " + emailErrorMessageText);
		if (emailErrorMessageText.equals("*required")) {
			System.out.println("Expected Email Error Message is showing");
		} else {
			System.out.println("Expected Email Error Message is not showing");
		}
		WebElement passwordErrorMessage = driver.findElement(emailError);
		String passwordErrorMessageText = passwordErrorMessage.getText();
		System.out.println("Password error message is: " + passwordErrorMessageText);
		if (passwordErrorMessageText.equals("*required")) {
			System.out.println("Expected Password Error Message is showing");
		} else {
			System.out.println("Expected Password Error Message is not showing");
		}
	}

	@Test(priority = 3)
	public void loginWithInvalidCredentials() {

		System.out.println("Test3: Login With Invalid Credentials");

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("ss4yuvan@gmail.com");

		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("sruthi1234");

		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage = driver.findElement(invalidCredentialsError);
		String errorText = errorMessage.getText();
		System.out.println("Error Message is: " + errorText);
		if (errorText.contains("*Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}
	}

	@Test(priority = 4)
	public void loginWithValidEmailAndInvalidPassword() {

		System.out.println("Test4: Login With Valid Email And Invalid Password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys("suresh.salloju@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys("Sruthi@123");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage1 = driver.findElement(invalidCredentialsError);
		errorText1 = errorMessage1.getText();
		System.out.println("Error Message is: " + errorText1);

		if (errorText.contains("*Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}
	}

	@Test(priority = 5)
	public void loginWithInvalidEmailAndValidPassword() {

		System.out.println("Test5: Login With Invalid Email And Valid Password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys("ss4yuvan@gmail.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys("suresh_123");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage2 = driver.findElement(invalidCredentialsError);
		errorText2 = errorMessage2.getText();
		System.out.println("Error Message is: " + errorText2);
		if (errorText.contains("Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}
	}

	@Test(priority = 6)
	public void forgotPassword() {

		System.out.println("Test6: ForgotPassword");

		driver.findElement(forgotPasswordLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordHeaderText));
		WebElement forgotPasswordHeader = driver.findElement(forgotPasswordHeaderText);
		String fPasswordHeaderText = forgotPasswordHeader.getText();
		System.out.println("Forgot Password Header Text is: " + fPasswordHeaderText);
		if (fPasswordHeaderText.equals("Forgot Password")) {
			System.out.println("Expected Header text is showing");
		} else {
			System.out.println("Expected header text is not showing");
		}
		driver.findElement(forgotPasswordEmailInputField).click();
		driver.findElement(forgotPasswordEmailInputField).sendKeys("ss4yuvan@gmail.com");
		driver.findElement(forgotpasswordGenerateOTP).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordGenerateOTPError));
		WebElement OtpError = driver.findElement(forgotPasswordGenerateOTPError);
		String emailOTPError = OtpError.getText();
		System.out.println("Dashboard text is: " + emailOTPError);
		if (emailOTPError.equals("*Email not found")) {
			System.out.println("Expected email OTP error message is showing");
		} else {
			System.out.println("Expected email OTP error message is not showing");
		}
	}

	@AfterTest
	public void close() {
		System.out.println("After test");
		driver.close();
	}
}
