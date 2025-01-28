package urBuddi.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import Common.CommonMethods;
import urBuddi.Pages.DashBoardLeaveManagementPage;
import urBuddi.Pages.LeaveManagementPage;
import urBuddi.Pages.LoginPage;

public class Test06ApplyAndCancelLeaveTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardLeaveManagementPage dashBoardLeaveManagementPage;
	LeaveManagementPage leaveManagementPage;
	CommonMethods cm;

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();
		System.out.println("Before Test");

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardLeaveManagementPage = new DashBoardLeaveManagementPage(wait, driver);
		leaveManagementPage = new LeaveManagementPage(wait, driver);
	}

	@Test
	public void verifyLeaveManagement() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginPage.verifyLoginIsSuccessful();

		dashBoardLeaveManagementPage.leaveManagementLinks();
		dashBoardLeaveManagementPage.verifyApplyLeavePage();

		leaveManagementPage.applyLeavepageInputs();
		leaveManagementPage.monthPicker();
		leaveManagementPage.verifyApplicationOfLeave();
		leaveManagementPage.cancelAppliedLeave();
		leaveManagementPage.verifyLeaveCancel();

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}
