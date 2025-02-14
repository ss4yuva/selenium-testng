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
import urBuddi.Pages.AddEmployeeWithEmployeeRolePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.LoginPage;

public class AddEmployeeTestSpec extends BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithEmployeeRolePage addEmployeePage;

	String url, username, password;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		FileInputStream file = new FileInputStream(
				"D:\\Automation\\selenium-testng\\test-data\\credentials.properties");
		p = new Properties();
		p.load(file);

		url = p.getProperty("url");
		username = p.getProperty("email");
		password = p.getProperty("password");

		driver = getDriver();

		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardEmployeesPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeePage = new AddEmployeeWithEmployeeRolePage(wait, driver);
	}

	@Test
	public void verifyAddEmployeeIsSuccessful() throws InterruptedException {
		System.out.println("Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
