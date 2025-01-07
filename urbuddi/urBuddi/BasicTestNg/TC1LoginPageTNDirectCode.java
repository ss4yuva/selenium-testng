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

public class TC1LoginPageTNDirectCode {
	static WebDriver driver;
	static WebDriverWait wait;

	// Locators
	By companyLogo = By.xpath("//*[@class='company-logo']");
	By headerText = By.xpath("//*[@class='welcomeMessage']");
	By subText = By.xpath("//*[@class='subtext']");
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");

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

	@Test(priority = 1)
	public void verifyURL() {
		System.out.println("Test Priority = 1");
		String url = driver.getCurrentUrl();
		System.out.println("URL: " + url);
	}

	@Test(priority = 2)
	public void verifyLogo() {
		System.out.println("Test Priority = 2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogo));
		WebElement logo = driver.findElement(companyLogo);
		boolean logoDisplayed = logo.isDisplayed();
		if (logoDisplayed == true) {
			System.out.println("urBuddi logo is displayed");
		} else {
			System.out.println("urBuddi Logo is not displayed");
		}
	}

	@Test(priority = 3)
	public void verifyWelcomeToUrBuddiText() {
		System.out.println("Test Priority = 3");
		WebElement header = driver.findElement(headerText);
		String htext = header.getText();
		System.out.println("HeaderText is: " + htext);
		if (htext.equals("Welcome to urBuddi")) {
			System.out.println("Expected 'Welcome to urBuddi' Headertext is showing");
		} else {
			System.out.println("Expected 'Welcome to urBuddi' Headertext is not showing");
		}
	}

	@Test(priority = 4)
	public void verifyEnterYourLoginCredentialsHereText() {
		System.out.println("Test Priority = 4");
		WebElement sub = driver.findElement(subText);
		String stext = sub.getText();
		System.out.println("SubText is: " + stext);
		if (stext.contains("Enter your login credentials here")) {
			System.out.println("Expected 'Enter your login credentials here' Subtext is showing");
		} else {
			System.out.println("Expected 'Enter your login credentials here' Subtext is not showing");
		}
	}

	@Test(priority = 5)
	public void verifyEmailAndPasswordInputFieldsDisplay() {
		System.out.println("Test Priority = 5");
		WebElement email = driver.findElement(emailInputfield);
		boolean emailDisplayed = email.isDisplayed();
		if (emailDisplayed == true) {
			System.out.println("Email inputfield is displayed");
		} else {
			System.out.println("Email inputfield is not displayed");
		}
		WebElement password = driver.findElement(passwordInputfield);
		boolean passwordDisplayed = email.isDisplayed();
		if (passwordDisplayed == true) {
			System.out.println("Password inputfield is displayed");
		} else {
			System.out.println("Password inputfield is not displayed");
		}
	}

	@Test(priority = 6)
	public void verifyLoginButtonDisplay() {
		System.out.println("Test Priority = 6");
		WebElement login = driver.findElement(loginButton);
		boolean loginButtonDisplayed = login.isDisplayed();
		if (loginButtonDisplayed == true) {
			System.out.println("Login button is displayed");
		} else {
			System.out.println("Login button is not displayed");
		}
	}

	@Test(priority = 7)
	public void verifyForgotPasswordLinkDisplay() {
		System.out.println("Test Priority = 7");
		WebElement forgotPassword = driver.findElement(forgotPasswordLink);
		String forgotPasswordText = forgotPassword.getText();
		System.out.println("ForgotPassword Text is:" + forgotPasswordText);
		if (forgotPasswordText.contains("FORGOT PASSWORD?")) {
			System.out.println("Forgot Password link text is showing");
		} else {
			System.out.println("Forgot Password link text is not showing");
		}
	}

	@AfterTest
	public void browserClose() {
		System.out.println("After Test");
		driver.close();
	}

}
