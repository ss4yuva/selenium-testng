package urBuddi.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.AddEmployeeWithEmployeeRolePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.LoginPage;
import urBuddi.Pages.EditEmployeePage;

public class Test04_EditEmployeeAfterAddTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithEmployeeRolePage addEmployeePage;
	EditEmployeePage editEmployeePage;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardEmployeesPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeePage = new AddEmployeeWithEmployeeRolePage(wait, driver);
		editEmployeePage = new EditEmployeePage(wait, driver);
	}

	@Test
	public void verifyLoginEditEmployeeAfterAddIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardEmployeesPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		editEmployeePage.searchNewEmployeeWithEmpID(addEmployeePage.empIDInput);
		editEmployeePage.clickOnEditButton();
		editEmployeePage.verifyEditEmployeePage();
		editEmployeePage.enterEditEmployeePageTestData();
		editEmployeePage.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		editEmployeePage.verifyEditEmployeeDetailsWithEditedFirstAndLastName();

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
