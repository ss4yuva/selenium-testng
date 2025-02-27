package urBuddi.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.LoginFunctionalityPage;

public class Test003_LoginFunctionalityTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginFunctionalityPage loginFunctionalityPage;

	String url, username, password;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		p = getPropertiesObj();

		url = p.getProperty("url");
		username = p.getProperty("email");
		password = p.getProperty("password");

		driver = getDriver();
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginFunctionalityPage = new LoginFunctionalityPage(wait, driver);
	}

	@Test
	public void verificationOfLoginFunctionalityIsSuccess() throws InterruptedException {
		System.out.println("Test");

		loginFunctionalityPage.loginWithValidCredentials(username, password);
		loginFunctionalityPage.verifyLoginPage();
		loginFunctionalityPage.clickOnLogout();
		loginFunctionalityPage.loginWithBlankCredentials();
		loginFunctionalityPage.verifyErrorMessageLoginWithBlankCredentials();
		loginFunctionalityPage.loginWithInValidCredentails("ss4yuvan@gmail.com", "ss@123");
		loginFunctionalityPage.verifyErrorMessageLoginWithInvalidCredentials();
		loginFunctionalityPage.loginWithValidEmailAndInValidPassword(username, "ss@123");
		loginFunctionalityPage.verifyErrorMessageLoginWithValidEmailAndInValidPassword();
		loginFunctionalityPage.loginWithInValidEmailAndValidPassword("ss4yuvan@gmail.com", password);
		loginFunctionalityPage.verifyErrorMessageLoginWithInValidEmailAndValidPassword();
		loginFunctionalityPage.clickOnForgotPasswordLink();
		loginFunctionalityPage.verifyForgotPasswordPage();
	}

	@AfterTest
	public void browserclose() {
		System.out.println("After Test");
		driver.close();
	}

}
