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
import urBuddi.Pages.AddEmployeeWithRoleAsAdminPage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEditPage;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginPage;
import urBuddi.Pages.LoginWithRoleAdminPage;

public class Test018_Add_Login_Edit_ProfileOfAddEmployeeWithAdminRoleTestSpec extends BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithRoleAsAdminPage addEmployeeWithRoleAsAdminPage;
	LoginWithRoleAdminPage loginWithRoleAdminPage;

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

		loginPage = new LoginPage(wait, driver);
		dashBoardEmployeesPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeeWithRoleAsAdminPage = new AddEmployeeWithRoleAsAdminPage(wait, driver);
		loginWithRoleAdminPage = new LoginWithRoleAdminPage(wait, driver);
	}

	@Test
	public void verifyAddEditDeleteEmployeeWithAdminRoleIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeeWithRoleAsAdminPage.addEmployeeInputs();
		addEmployeeWithRoleAsAdminPage.verifyAddEmployeeSuccessful(addEmployeeWithRoleAsAdminPage.empIDInput);

		loginPage.logoutToApplication();

		loginWithRoleAdminPage.loginToApplicationWithRoleAsAdmin("admin"+emailRandom+"@gmail.com", "admin@"+randomPassword+"A");
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}
