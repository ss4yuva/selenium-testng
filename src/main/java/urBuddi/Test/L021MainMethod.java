package urBuddi.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.L022LoginPage;
import urBuddi.Pages.L023DashBoardPage;
import urBuddi.Pages.L024EmployeesPage;
import urBuddi.Pages.L025EditEmployeePage;

public class L021MainMethod {
	static WebDriver driver;
	static WebDriverWait wait;
	String empIDInput;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		L022LoginPage loginPage = new L022LoginPage(wait, driver);
		L023DashBoardPage dashBoardPage = new L023DashBoardPage(wait, driver);
		L024EmployeesPage employeePage = new L024EmployeesPage(wait, driver);
		L025EditEmployeePage editEmployeePage = new L025EditEmployeePage(wait, driver);

		loginPage.loginToApplication("suresh.salloju@openskale.com", "suresh_123");
		loginPage.verifyLoginIsSuccessful();
		dashBoardPage.clickOnEmployeesButton();
		employeePage.clickOnAddEmployeeButton();
		employeePage.verifyAddEmployeePage();
		employeePage.enterAddEmployeePageTestData();
		employeePage.verifyNewEmployeeIsAddedSuccessful();
		employeePage.searchNewEmployeeWithEmpID(employeePage.empIDInput);
		// employeePage.deleteNewlyAddedEmployeeWithEmployeeID();
		// employeePage.verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(employeePage.empIDInput);
		Thread.sleep(5000);

		editEmployeePage.clickOnEditButton();
		editEmployeePage.verifyEditEmployeePage();
		editEmployeePage.enterEditEmployeePageTestData();
		editEmployeePage.searchEditEmployeeDetailsWithEditeedFirstAndLastName();
		editEmployeePage.verifyEditEmployeeDetailsWithEditeedFirstAndLastName();
		editEmployeePage.deleteEditEmployeeWithSearchedFirstAndLastName();

		driver.close();
	}

}
