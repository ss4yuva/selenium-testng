package urBuddi.BasicJava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC010LoginFunctionalityWithAssertionsAndMethods {

	static WebDriver driver;
	static WebDriverWait wait;

	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By dashboard = By.xpath("(//*[text()='Dashboard'])[2]");
	By lagoutButton = By.xpath("//*[@class='logout-btn-nav']");
	By logoutPopupYes = By.xpath("//*[text()='Yes']");

	By emailError = By.xpath("(//*[text()='*required'])[1]");
	By passwordError = By.xpath("(//*[text()='*required'])[2]");

	By invalidCredentialsError = By.xpath("//*[@class='err-msg-display mt-3']");

	By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");
	By forgotPasswordHeaderText = By.xpath("//*[text()='Forgot Password']");

	public void loginToApplication(String userName, String password) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		WebElement dashboardT = driver.findElement(dashboard);
		String dashboardText = dashboardT.getText();
		System.out.println("Actual text is: " + dashboardText);
		System.out.println("Expected text is: " + "Dashboard");

		Assert.assertEquals(dashboardText, "Dashboard");
		System.out.println("==>Login With Valid Credentails are passed");

		driver.findElement(lagoutButton).click();
		driver.findElement(logoutPopupYes).click();
	}

	public void loginWithBlankCredentials() {

		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));

		WebElement emailErrorMessage = driver.findElement(emailError);
		String emailErrorMessageText = emailErrorMessage.getText();
		System.out.println("Actual Email Error message is:" + emailErrorMessageText);
		System.out.println("Expected Email error message is: " + "*required");

		Assert.assertEquals(emailErrorMessageText, "*required");

		WebElement passwordErrorMessage = driver.findElement(passwordError);
		String passwordErrorMessageText = passwordErrorMessage.getText();
		System.out.println("Actual Password Error message is:" + passwordErrorMessageText);
		System.out.println("Expected Password error message is: " + "*required");

		Assert.assertEquals(passwordErrorMessageText, "*required");
		System.out.println("==>Login With Blank Credentials are Passed");
	}

	public void loginWIthInvalidCredentials(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);

		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);

		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage = driver.findElement(invalidCredentialsError);
		String errorText = errorMessage.getText();
		System.out.println("Actual Invalid Credentials Error Message is:" + errorText);
		System.out.println("Expected Invalid Credentail Error Message is:" + "*Invalid credentials");

		Assert.assertEquals(errorText, "*Invalid credentials");
		System.out.println("==>Login with Invalid Credentials are passed");
	}

	public void loginWithValidEmailAndInvalidPassword(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage1 = driver.findElement(invalidCredentialsError);
		String errorText1 = errorMessage1.getText();
		System.out.println("Actual Error Message is: " + errorText1);
		System.out.println("Expected Error Message is: " + "*Invalid credentials");

		Assert.assertEquals(errorText1, "*Invalid credentials");
		System.out.println("==>Login With Valid Email and Invalid Password is Passed ");
	}

	public void loginWithInvalidEmailAndValidPassword(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage2 = driver.findElement(invalidCredentialsError);
		String errorText2 = errorMessage2.getText();
		System.out.println("Actual Error Message is: " + errorText2);
		System.out.println("Expected Error Message is:" + "*Invalid credentials");

		Assert.assertEquals(errorText2, "*Invalid credentials");
		System.out.println("==>Login with Valid Email and Invalid Password is passed");
	}

	public void verificationOfForgotPasswordLink() {
		driver.findElement(forgotPasswordLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordHeaderText));
		WebElement forgotPasswordHeader = driver.findElement(forgotPasswordHeaderText);
		String fPasswordHeaderText = forgotPasswordHeader.getText();
		System.out.println("Actual Forgot Password Header Text is: " + fPasswordHeaderText);
		System.out.println("Expected Forgot Password Header Text is: " + "Forgot Password");

		Assert.assertEquals(fPasswordHeaderText, "Forgot Password");
		System.out.println("==>Verification of Forgot Password Link is passed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		TC010LoginFunctionalityWithAssertionsAndMethods obj = new TC010LoginFunctionalityWithAssertionsAndMethods();

		obj.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		obj.loginWithBlankCredentials();
		obj.loginWIthInvalidCredentials("ss4yuvan@gmail.com", "sruthi1234");
		obj.loginWithValidEmailAndInvalidPassword("suresh.salloju@openskale.com", "Sruthi@123");
		obj.loginWithInvalidEmailAndValidPassword("ss4yuvan@gmail.com", "New@2024");
		obj.verificationOfForgotPasswordLink();

		driver.close();
	}
}
