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
import urBuddi.Pages.LoginPageVerificationPage;

public class Test001_LoginPageVerificationTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPageVerificationPage verificationOfLoginPage;

	String url;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		p = getPropertiesObj();

		url = p.getProperty("url");

		driver = getDriver();
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		verificationOfLoginPage = new LoginPageVerificationPage(wait, driver);
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