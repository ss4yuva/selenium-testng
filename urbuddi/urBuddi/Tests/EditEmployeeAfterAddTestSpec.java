package urBuddi.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.AddEmployeeWithRoleAsEmployeePage;
import urBuddi.Pages.DashBoardEmployeesPage;
import urBuddi.Pages.LoginPage;
import urBuddi.Pages.EditEmployeePage;

public class EditEmployeeAfterAddTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardEmployeesPage dashBoardEmployeesPage;
	AddEmployeeWithRoleAsEmployeePage addEmployeePage;
	EditEmployeePage editEmployeePage;

	String url, username, password;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		FileInputStream file = new FileInputStream(
				"D:\\Automation\\selenium-testng\\test-data\\credentials.properties");
		p = new Properties();
		p.load(file);

		url = p.getProperty("url");
		username = p.getProperty("email");
		password = p.getProperty("password");

		driver = getDriver();
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardEmployeesPage = new DashBoardEmployeesPage(wait, driver);
		addEmployeePage = new AddEmployeeWithRoleAsEmployeePage(wait, driver);
		editEmployeePage = new EditEmployeePage(wait, driver);
	}

	@Test
	public void verifyEditEmployeeAfterAddingIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication(username, password);
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
