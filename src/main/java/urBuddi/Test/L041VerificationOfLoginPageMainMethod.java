package urBuddi.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.ChromeInitialization;
import urBuddi.Pages.L042VerificationOfLoginPage;

public class L041VerificationOfLoginPageMainMethod {
	static WebDriver driver;
	static WebDriverWait wait;
	static ChromeDriver chrome;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		driver.get("https://dev.urbuddi.com/login");
		Thread.sleep(5000);
		
		L042VerificationOfLoginPage loginPage = new L042VerificationOfLoginPage(wait, driver, chrome);
		
		loginPage.verifyUrBuddiLogo();
		loginPage.verifyHeaderTextWelcomeToUrBuddi();
		loginPage.verifySubtext();
		loginPage.verifyEmailInputField();
		loginPage.verifyPasswordInputField();
		loginPage.verifyLoginButton();
		loginPage.verifyForgotPasswordLink();

		driver.close();
	}

}
