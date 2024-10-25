package urBuddi.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.L032LoginPageFunctionality;

public class L031LoginPageFunctionalityMainMethod {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		L032LoginPageFunctionality loginPageFunctionality = new L032LoginPageFunctionality(wait, driver);

		Thread.sleep(5000);
		loginPageFunctionality.verifyUrBuddiLoginPage();
		loginPageFunctionality.loginWithValidCredentials("suresh.salloju@openskale.com", "suresh_123");
		loginPageFunctionality.verifyLoginPage();
		loginPageFunctionality.clickOnLogout();
		loginPageFunctionality.loginWithBlankCredentials();
		loginPageFunctionality.verifyErrorMessageLoginWithBlankCredentials();
		loginPageFunctionality.loginWithInValidCredentails("ss4yuvan@gmail.com", "sruthi1234");
		loginPageFunctionality.verifyErrorMessageLoginWithInvalidCredentials();
		loginPageFunctionality.loginWithValidEmailAndInValidPassword("suresh.salloju@openskale.com", "Sruthi@123");
		loginPageFunctionality.verifyErrorMessageLoginWithValidEmailAndInValidPassword();
		loginPageFunctionality.loginWithInValidEmailAndValidPassword("ss4yuvan@gmail.com", "suresh_123");
		loginPageFunctionality.verifyErrorMessageLoginWithInValidEmailAndValidPassword();
		loginPageFunctionality.clickOnForgotPasswordLink();
		loginPageFunctionality.verifyForgotPasswordPage();

		driver.close();
	}

}
