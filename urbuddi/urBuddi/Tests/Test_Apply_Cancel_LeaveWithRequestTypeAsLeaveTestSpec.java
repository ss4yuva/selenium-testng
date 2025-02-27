package urBuddi.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;
import urBuddi.Pages.DashBoardLeaveManagementPage;
import urBuddi.Pages.ApplyLeaveWithRequestTypeAsLeavePage;
import urBuddi.Pages.CancelApplyLeavePage;
import urBuddi.Pages.LoginPage;

public class Test_Apply_Cancel_LeaveWithRequestTypeAsLeaveTestSpec extends BaseMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	LoginPage loginPage;
	DashBoardLeaveManagementPage dashBoardLeaveManagementPage;
	ApplyLeaveWithRequestTypeAsLeavePage applyLeaveWithRequestTypeAsLeavePage;
	CancelApplyLeavePage cancelApplyLeavePage;

	String url, username, password;
	Properties p;

	@BeforeTest
	public void browserLaunch() throws IOException {
		System.out.println("Before Test");

		p = getPropertiesObj();

		url = p.getProperty("url");
		username = p.getProperty("email");
		password = p.getProperty("password");

		driver = getDriver();
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		loginPage = new LoginPage(wait, driver);
		dashBoardLeaveManagementPage = new DashBoardLeaveManagementPage(wait, driver);
		applyLeaveWithRequestTypeAsLeavePage = new ApplyLeaveWithRequestTypeAsLeavePage(wait, driver);
		cancelApplyLeavePage = new CancelApplyLeavePage(wait, driver);
	}

	@Test
	public void verifyApplyAndCancelLeaveIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		loginPage.loginToApplication(username, password);
		loginPage.verifyLoginIsSuccessful();

		dashBoardLeaveManagementPage.leaveManagementLinks();
		dashBoardLeaveManagementPage.verifyApplyLeavePage();

		applyLeaveWithRequestTypeAsLeavePage.applyLeavepageInputs();
		applyLeaveWithRequestTypeAsLeavePage.monthPicker();
		applyLeaveWithRequestTypeAsLeavePage.verifyApplicationOfLeave();
		cancelApplyLeavePage.cancelAppliedLeave();
		cancelApplyLeavePage.verifyLeaveCancel();

		loginPage.logoutToApplication();
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}
}
