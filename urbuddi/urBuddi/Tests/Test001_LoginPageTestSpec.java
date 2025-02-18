package urBuddi.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.VerificationOfLoginPage;

public class Test001_LoginPageTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	VerificationOfLoginPage verificationOfLoginPage;

	String url;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		FileInputStream file = new FileInputStream(
				"D:\\Automation\\selenium-testng\\test-data\\credentials.properties");
		p = new Properties();
		p.load(file);

		url = p.getProperty("url");

		driver = getDriver();
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		verificationOfLoginPage = new VerificationOfLoginPage(wait, driver);
	}

	@Test
	public void verificationOfLoginPageIsSuccess() throws InterruptedException {
		System.out.println("Test");

		verificationOfLoginPage.verifyUrBuddiLogo();
		verificationOfLoginPage.verifyHeaderTextWelcomeToUrBuddi();
		verificationOfLoginPage.verifySubtext();
		verificationOfLoginPage.verifyEmailInputField();
		verificationOfLoginPage.verifyPasswordInputField();
		verificationOfLoginPage.verifyLoginButton();
		verificationOfLoginPage.verifyForgotPasswordLink();
	}

	@AfterTest
	public void browserclose() {
		System.out.println("After Test");
		driver.close();
	}
}