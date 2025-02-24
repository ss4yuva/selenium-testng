package urBuddi.Java.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.LoginFunctionalityPage;

public class POM2LoginPageFunctionality {

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

		LoginFunctionalityPage loginPageFunctionality = new LoginFunctionalityPage(wait, driver);

		loginPageFunctionality.verifyUrBuddiLoginPage();
		loginPageFunctionality.loginWithValidCredentials("suresh.salloju@openskale.com", "New@2024");
		loginPageFunctionality.verifyLoginPage();
		loginPageFunctionality.clickOnLogout();
		loginPageFunctionality.loginWithBlankCredentials();
		loginPageFunctionality.verifyErrorMessageLoginWithBlankCredentials();
		loginPageFunctionality.loginWithInValidCredentails("ss4yuvan@gmail.com", "sruthi1234");
		loginPageFunctionality.verifyErrorMessageLoginWithInvalidCredentials();
		loginPageFunctionality.loginWithValidEmailAndInValidPassword("suresh.salloju@openskale.com", "Sruthi@123");
		loginPageFunctionality.verifyErrorMessageLoginWithValidEmailAndInValidPassword();
		loginPageFunctionality.loginWithInValidEmailAndValidPassword("ss4yuvan@gmail.com", "New@2024");
		loginPageFunctionality.verifyErrorMessageLoginWithInValidEmailAndValidPassword();
		loginPageFunctionality.clickOnForgotPasswordLink();
		loginPageFunctionality.verifyForgotPasswordPage();

		driver.close();
	}

}
