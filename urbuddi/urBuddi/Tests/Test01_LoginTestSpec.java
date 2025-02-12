package urBuddi.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.LoginPage;

public class Test01_LoginTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();
		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
	}

	@Test
	public void verifyLoginIsSuccess() throws InterruptedException {
		System.out.println("Test");
		loginPage.loginToApplicationInputs();
		loginPage.verifyLoginIsSuccessful();
		loginPage.logoutToApplication();
	}

	@AfterTest
	public void browserclose() {
		System.out.println("After Test");
		driver.close();
	}

}
