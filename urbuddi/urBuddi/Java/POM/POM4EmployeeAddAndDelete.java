package urBuddi.Java.POM;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.AddEmployeeWithRoleAsEmployeePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.DeleteAddEmployeePage;
import urBuddi.Pages.LoginPage;

public class POM4EmployeeAddAndDelete {

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
		DeleteAddEmployeePage deleteAddEmployee = new DeleteAddEmployeePage(wait, driver);

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();

		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		deleteAddEmployee.searchAndDeleteAddEmployee();
		deleteAddEmployee.verifyAddEmployeeAfterDelete(addEmployeePage.empIDInput);

		driver.close();

	}
}
