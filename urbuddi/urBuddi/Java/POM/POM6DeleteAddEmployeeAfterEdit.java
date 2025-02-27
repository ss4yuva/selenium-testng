package urBuddi.Java.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.AddEmployeeWithRoleAsEmployeePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEditPage;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginPage;

public class POM6DeleteAddEmployeeAfterEdit {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		LoginPage loginPage = new LoginPage(wait, driver);
		DashBoardEmployeesPage dashBoardPage = new DashBoardEmployeesPage(wait, driver);
		AddEmployeeWithRoleAsEmployeePage addEmployeePage = new AddEmployeeWithRoleAsEmployeePage(wait, driver);
		EditEmployeePage editEmployee = new EditEmployeePage(wait, driver);
		DeleteAddEmployeeAfterEditPage deleteEmployeeAfterEdit = new DeleteAddEmployeeAfterEditPage(wait, driver);

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		editEmployee.searchNewEmployeeWithEmpID(addEmployeePage.empIDInput);
		editEmployee.clickOnEditButton();
		editEmployee.verifyEditEmployeePage();
		editEmployee.enterEditEmployeePageTestData();
		editEmployee.searchEditEmployeeDetailsWithEditedFirstAndLastName();
		editEmployee.verifyEditEmployeeDetailsWithEditedFirstAndLastName();

		deleteEmployeeAfterEdit.deleteEditEmployeeWithSearchedFirstAndLastName();
		deleteEmployeeAfterEdit
				.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(deleteEmployeeAfterEdit.empIDInput);

		driver.close();
	}

}
