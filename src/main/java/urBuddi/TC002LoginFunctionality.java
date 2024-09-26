package urBuddi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC002LoginFunctionality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

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

		// TC_008 Verify the Login functionality with Valid Credentials
		System.out.println("TC_008");
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("govardhan.gottemukkula@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("Govardhan_123");
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

		// TC_009 Verify the Login functionality with blank of User name and Password
		System.out.println("****************************************");
		System.out.println("TC_009");
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

		// TC_010 Verify the Login functionality with InValid Credentials
		System.out.println("****************************************");
		System.out.println("TC_010");
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

		// TC_011 Verify the Login functionality with Valid Email and Invalid Password
		System.out.println("****************************************");
		System.out.println("TC_011");
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys("govardhan.gottemukkula@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys("Sruthi@123");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage1 = driver.findElement(invalidCredentialsError);
		String errorText1 = errorMessage1.getText();
		System.out.println("Error Message is: " + errorText1);
		if (errorText.contains("*Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}

		// TC_012 Verify the Login functionality with InValid Email and valid Password
		System.out.println("****************************************");
		System.out.println("TC_012");
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys("ss4yuvan@gmail.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys("Govardhan_123");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage2 = driver.findElement(invalidCredentialsError);
		String errorText2 = errorMessage2.getText();
		System.out.println("Error Message is: " + errorText2);
		if (errorText.contains("Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}

		// TC_013 Verify the functionality of Forgot Password with invalid email
		System.out.println("****************************************");
		System.out.println("TC_013");
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
		driver.close();
	}

}
