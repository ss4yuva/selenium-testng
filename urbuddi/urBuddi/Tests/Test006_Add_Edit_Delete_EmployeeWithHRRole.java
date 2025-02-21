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
import urBuddi.Pages.AddEmployeeWithHRRole;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEditPage;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginPage;

public class Test006_Add_Edit_Delete_EmployeeWithHRRole extends BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithHRRole addEmployeeWithHRRolePage;
	EditEmployeePage editEmployeePage;
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
		addEmployeeWithHRRolePage = new AddEmployeeWithHRRole(wait, driver);
		editEmployeePage = new EditEmployeePage(wait, driver);
		deleteAddEmployeeAfterEditPage = new DeleteAddEmployeeAfterEditPage(wait, driver);
	}

	@Test
	public void verifyAddEditDeleteEmployeeWithHRRoleIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeeWithHRRolePage.addEmployeeInputs();
		addEmployeeWithHRRolePage.verifyAddEmployeeSuccessful(addEmployeeWithHRRolePage.empIDInput);

		editEmployeePage.searchNewEmployeeWithEmpID(addEmployeeWithHRRolePage.empIDInput);
		editEmployeePage.clickOnEditButton();
		editEmployeePage.verifyEditEmployeePage();
		editEmployeePage.enterEditEmployeePageTestData();
		editEmployeePage.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		editEmployeePage.verifyEditEmployeeDetailsWithEditedFirstAndLastName();

		deleteAddEmployeeAfterEditPage.deleteEditEmployeeWithSearchedFirstAndLastName();
		deleteAddEmployeeAfterEditPage
				.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(addEmployeeWithHRRolePage.empIDInput);

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}