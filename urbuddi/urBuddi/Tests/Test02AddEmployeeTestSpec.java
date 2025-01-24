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
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.LoginToApplication;

public class Test02AddEmployeeTestSpec extends BaseMethods {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginToApplication loginToApplication;
	DashBoardEmployeesPage dashBoardPage;
	AddEmployeePage addEmployeePage;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();
		System.out.println("Before Test");

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginToApplication = new LoginToApplication(wait, driver);
		dashBoardPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeePage = new AddEmployeePage(wait, driver);
	}

	@Test
	public void verifyAddEMployeeIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");	
		Thread.sleep(2000);
		loginToApplication.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginToApplication.verifyLoginIsSuccessful();

		dashBoardPage.clickOnEmployeesButton();
		addEmployeePage.verifyAddEmployeePage();
		addEmployeePage.addEmployeeInputs();
		Thread.sleep(1000);
		addEmployeePage.verifyAddEmployeeSuccessful(addEmployeePage.empIDInput);

		loginToApplication.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
