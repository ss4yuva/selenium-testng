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
import urBuddi.Pages.AddEmployeeWithAdminRolePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEditPage;
import urBuddi.Pages.EmployeeWithEmployeeStatusAsReleasedAtEditPage;
import urBuddi.Pages.LoginPage;

public class Test016_Add_Edit_EmployeeWithReleasedStatusTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithAdminRolePage addEmployeeWithAdminRolePage;
	EmployeeWithEmployeeStatusAsReleasedAtEditPage employeeWithEmployeeStatusAsReleasedAtEditPage;

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
		addEmployeeWithAdminRolePage = new AddEmployeeWithAdminRolePage(wait, driver);
		employeeWithEmployeeStatusAsReleasedAtEditPage = new EmployeeWithEmployeeStatusAsReleasedAtEditPage(wait,
				driver);

	}

	@Test
	public void verifyAddEditEmployeeWithReleasedStatusIsSuccessful() throws InterruptedException {
		System.out.println("Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeeWithAdminRolePage.addEmployeeInputs();
		addEmployeeWithAdminRolePage.verifyAddEmployeeSuccessful(addEmployeeWithAdminRolePage.empIDInput);

		employeeWithEmployeeStatusAsReleasedAtEditPage
				.searchNewEmployeeWithEmpID(addEmployeeWithAdminRolePage.empIDInput);
		employeeWithEmployeeStatusAsReleasedAtEditPage.clickOnEditButton();
		employeeWithEmployeeStatusAsReleasedAtEditPage.verifyEditEmployeePage();
		employeeWithEmployeeStatusAsReleasedAtEditPage.enterEditEmployeePageTestData();
		employeeWithEmployeeStatusAsReleasedAtEditPage.clickOnReleasedLink();
		employeeWithEmployeeStatusAsReleasedAtEditPage.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		employeeWithEmployeeStatusAsReleasedAtEditPage.verifyEditEmployeeDetailsWithReleasedStatus();

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
