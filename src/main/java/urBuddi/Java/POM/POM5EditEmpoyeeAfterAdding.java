package urBuddi.Java.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.AddEmployeePage;
import urBuddi.Pages.DashBoardPage;
import urBuddi.Pages.EditEmployeePage;
import urBuddi.Pages.LoginToApplication;

public class POM5EditEmpoyeeAfterAdding {

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

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		Thread.sleep(1000);
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);
		Thread.sleep(1000);

		editEmployee.searchNewEmployeeWithEmpID(addEmployeePage.empIDInput);
		Thread.sleep(1000);
		editEmployee.clickOnEditButton();
		Thread.sleep(1000);
		editEmployee.verifyEditEmployeePage();
		Thread.sleep(1000);
		editEmployee.enterEditEmployeePageTestData();
		editEmployee.searchEditEmployeeDetailsWithEditeedFirstAndLastName();
		editEmployee.verifyEditEmployeeDetailsWithEditeedFirstAndLastName();
	}
}
