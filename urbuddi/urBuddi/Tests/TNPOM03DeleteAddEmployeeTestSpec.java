package urBuddi.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.AddEmployeePage;
import urBuddi.Pages.DashBoardPage;
import urBuddi.Pages.LoginToApplication;
import urBuddi.Pages.DeleteAddEmployee;

public class TNPOM03DeleteAddEmployeeTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginToApplication loginToApplication;
	DashBoardPage dashBoardPage;
	AddEmployeePage addEmployeePage;
	DeleteAddEmployee deleteAddEmployee;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginToApplication = new LoginToApplication(wait, driver);
		dashBoardPage = new DashBoardPage(wait, driver);
		addEmployeePage = new AddEmployeePage(wait, driver);
		deleteAddEmployee = new DeleteAddEmployee(wait, driver);
	}

	@Test
	public void verifyLoginIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginToApplication.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginToApplication.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();
		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		Thread.sleep(1000);
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);
		deleteAddEmployee.searchAndDeleteAddEmployee();
		deleteAddEmployee.verifyAddEmployeeAfterDelete(addEmployeePage.empIDInput);

		loginToApplication.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
