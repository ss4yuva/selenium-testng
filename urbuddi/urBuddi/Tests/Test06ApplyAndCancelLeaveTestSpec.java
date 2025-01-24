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
import urBuddi.Pages.LoginToApplication;

public class Test06ApplyAndCancelLeaveTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginToApplication loginToApplication;
	DashBoardLeaveManagementPage dashBoardLeaveManagementsLinks;
	LeaveManagementPage leaveManagement;
	CommonMethods cm;

	/*
	 * public Test06ApplyAndCancelLeaveTestSpec(WebDriverWait w, WebDriver d) {
	 * this.driver = d; this.wait = w; cm = new CommonMethods(wait, driver); }
	 */

	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		driver = getDriver();
		System.out.println("Before Test");

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginToApplication = new LoginToApplication(wait, driver);
		dashBoardLeaveManagementsLinks = new DashBoardLeaveManagementPage(wait, driver);
		leaveManagement = new LeaveManagementPage(wait, driver);
	}

	@Test
	public void verifyLeaveManagement() throws InterruptedException {
		System.out.println("Actual Test");

		loginToApplication.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		loginToApplication.verifyLoginIsSuccessful();

		dashBoardLeaveManagementsLinks.leaveManagementLinks();
		dashBoardLeaveManagementsLinks.verifyApplyLeavePage();

		leaveManagement.applyLeavepageInputs();
		leaveManagement.monthPicker();
		leaveManagement.verifyApplicationOfLeave();
		Thread.sleep(2000);
		leaveManagement.cancelAppliedLeave();
		Thread.sleep(2000);
		leaveManagement.verifyLeaveCancel();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}
