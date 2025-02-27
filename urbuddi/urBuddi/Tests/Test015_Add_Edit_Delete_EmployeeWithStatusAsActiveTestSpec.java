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
import urBuddi.Pages.EmployeeWithEmployeeStatusAsActiveAtEditPage;
import urBuddi.Pages.LoginPage;

public class Test015_Add_Edit_Delete_EmployeeWithStatusAsActiveTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithRoleAsAdminPage addEmployeeWithRoleAsAdminRolePage;
	EmployeeWithEmployeeStatusAsActiveAtEditPage employeeWithEmployeeStatusAsActiveAtEditPage;
	DeleteAddEmployeeAfterEditPage deleteAddEmployeeAfterEditPage;

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
		addEmployeeWithRoleAsAdminRolePage = new AddEmployeeWithRoleAsAdminPage(wait, driver);
		employeeWithEmployeeStatusAsActiveAtEditPage = new EmployeeWithEmployeeStatusAsActiveAtEditPage(wait, driver);
		deleteAddEmployeeAfterEditPage = new DeleteAddEmployeeAfterEditPage(wait, driver);
	}

	@Test
	public void verifyAddEditDeleteEmployeeWithActiveStatusIsSuccessful() throws InterruptedException {
		System.out.println("Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeeWithRoleAsAdminRolePage.addEmployeeInputs();
		addEmployeeWithRoleAsAdminRolePage.verifyAddEmployeeSuccessful(addEmployeeWithRoleAsAdminRolePage.empIDInput);

		employeeWithEmployeeStatusAsActiveAtEditPage
				.searchNewEmployeeWithEmpID(addEmployeeWithRoleAsAdminRolePage.empIDInput);
		employeeWithEmployeeStatusAsActiveAtEditPage.clickOnEditButton();
		employeeWithEmployeeStatusAsActiveAtEditPage.verifyEditEmployeePage();
		employeeWithEmployeeStatusAsActiveAtEditPage.enterEditEmployeePageTestData();
		employeeWithEmployeeStatusAsActiveAtEditPage.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		employeeWithEmployeeStatusAsActiveAtEditPage.verifyEditEmployeeDetailsWithActiveStatus();

		deleteAddEmployeeAfterEditPage.deleteEditEmployeeWithSearchedFirstAndLastName();
		deleteAddEmployeeAfterEditPage
				.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(addEmployeeWithRoleAsAdminRolePage.empIDInput);

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
