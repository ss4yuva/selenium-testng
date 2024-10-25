package urBuddi.Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC001LoginPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");

		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		// TC_001 Verify the urBuddi URL after launching the URL
		System.out.println("TC_001");
		String url = driver.getCurrentUrl();
		System.out.println("URL: " + url);

		// Locators
		By companyLogo = By.xpath("//*[@class='company-logo']");
		By headerText = By.xpath("//*[@class='welcomeMessage']");
		By subText = By.xpath("//*[@class='subtext']");
		By emailInputfield = By.id("userEmail");
		By passwordInputfield = By.id("userPassword");
		By loginButton = By.xpath("//*[@type='submit']");
		By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");

		// TC_002 Verify "urBuddi logo" is displayed on the login page
		System.out.println("****************************************");
		System.out.println("TC_002");
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogo));
		WebElement logo = driver.findElement(companyLogo);
		boolean logoDisplayed = logo.isDisplayed();
		if (logoDisplayed == true) {
			System.out.println("urBuddi logo is displayed");
		} else {
			System.out.println("urBuddi Logo is not displayed");
		}

		// TC_003 Verify "Welcome to urBuddi" header text is displayed or not
		System.out.println("****************************************");
		System.out.println("TC_003");
		WebElement header = driver.findElement(headerText);
		String htext = header.getText();
		System.out.println("HeaderText is: " + htext);
		if (htext.equals("Welcome to urBuddi")) {
			System.out.println("Expected 'Welcome to urBuddi' Headertext is showing");
		} else {
			System.out.println("Expected 'Welcome to urBuddi' Headertext is not showing");
		}

		// TC_004 Verify "Enter your login credentials here" text is displayed or not
		System.out.println("****************************************");
		System.out.println("TC_004");
		WebElement sub = driver.findElement(subText);
		String stext = sub.getText();
		System.out.println("SubText is: " + stext);
		if (stext.contains("Enter your login credentials here")) {
			System.out.println("Expected 'Enter your login credentials here' Subtext is showing");
		} else {
			System.out.println("Expected 'Enter your login credentials here' Subtext is not showing");
		}

		// TC_005 Verify Email and Password input fields are displayed or not
		System.out.println("****************************************");
		System.out.println("TC_005");
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

		// TC_006 Verify Login button is displayed or not
		System.out.println("****************************************");
		System.out.println("TC_006");
		WebElement login = driver.findElement(loginButton);
		boolean loginButtonDisplayed = login.isDisplayed();
		if (loginButtonDisplayed == true) {
			System.out.println("Login button is displayed");
		} else {
			System.out.println("Login button is not displayed");
		}

		// TC_007 Verify "FORGOT PASSWORD?" link is displayed or not
		System.out.println("****************************************");
		System.out.println("TC_007");
		WebElement forgotPassword = driver.findElement(forgotPasswordLink);
		String forgotPasswordText = forgotPassword.getText();
		System.out.println("ForgotPassword Text is:" + forgotPasswordText);
		if (forgotPasswordText.contains("FORGOT PASSWORD?")) {
			System.out.println("Forgot Password link text is showing");
		} else {
			System.out.println("Forgot Password link text is not showing");
		}

		Thread.sleep(1000);

		driver.close();

	}

}
