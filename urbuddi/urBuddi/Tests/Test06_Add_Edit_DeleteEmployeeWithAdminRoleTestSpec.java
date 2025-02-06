package urBuddi.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.AddEmployeeWithAdminRolePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEditPage;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginPage;

public class Test06_Add_Edit_DeleteEmployeeWithAdminRoleTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithAdminRolePage addEmployeeWithAdminRolePage;
	EditEmployeePage editEmployeePage;
	DeleteAddEmployeeAfterEditPage deleteAddEmployeeAfterEditPage;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();
		System.out.println("Before Test");

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardEmployeesPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeeWithAdminRolePage = new AddEmployeeWithAdminRolePage(wait, driver);
		editEmployeePage = new EditEmployeePage(wait, driver);
		deleteAddEmployeeAfterEditPage = new DeleteAddEmployeeAfterEditPage(wait, driver);
	}

	@Test
	public void verifyAddEMployeeIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeeWithAdminRolePage.addEmployeeInputs();
		addEmployeeWithAdminRolePage.verifyAddEmployeeSuccessful(addEmployeeWithAdminRolePage.empIDInput);

		editEmployeePage.searchNewEmployeeWithEmpID(addEmployeeWithAdminRolePage.empIDInput);
		editEmployeePage.clickOnEditButton();
		editEmployeePage.verifyEditEmployeePage();
		editEmployeePage.enterEditEmployeePageTestData();
		editEmployeePage.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		editEmployeePage.verifyEditEmployeeDetailsWithEditedFirstAndLastName();

		deleteAddEmployeeAfterEditPage.deleteEditEmployeeWithSearchedFirstAndLastName();
		deleteAddEmployeeAfterEditPage
				.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(addEmployeeWithAdminRolePage.empIDInput);

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}
