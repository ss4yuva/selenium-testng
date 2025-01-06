package urBuddi.Java.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.AddEmployeePage;
import urBuddi.Pages.DashBoardPage;
import urBuddi.Pages.DeleteAddEmployeeAfterEdit;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginToApplication;

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

		LoginToApplication loginPage = new LoginToApplication(wait, driver);
		DashBoardPage dashBoardPage = new DashBoardPage(wait, driver);
		AddEmployeePage addEmployeePage = new AddEmployeePage(wait, driver);
		EditEmployeePage editEmployee = new EditEmployeePage(wait, driver);
		DeleteAddEmployeeAfterEdit deleteEmployeeAfterEdit = new DeleteAddEmployeeAfterEdit(wait, driver);

		loginPage.loginToApplication("suresh.salloju@openskale.com", "suresh_123");
		loginPage.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		editEmployee.searchNewEmployeeWithEmpID(editEmployee.empIDInput);
		editEmployee.clickOnEditButton();
		editEmployee.verifyEditEmployeePage();
		editEmployee.enterEditEmployeePageTestData();
		editEmployee.searchEditEmployeeDetailsWithEditeedFirstAndLastName();
		editEmployee.verifyEditEmployeeDetailsWithEditeedFirstAndLastName();

		deleteEmployeeAfterEdit.deleteEditEmployeeWithSearchedFirstAndLastName();
		deleteEmployeeAfterEdit
				.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(deleteEmployeeAfterEdit.empIDInput);
	}

}
