package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class DashBoardLeaveManagementPage {
	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods cm;

	public DashBoardLeaveManagementPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Dashboard Page: Leave Management Links
	By leaveManagementLink = By.xpath("//*[text()='Leave Management']");
	By applyLeaveButton = By.xpath("//*[text()='Apply Leave']");
	By lopWarningOkButton = By.xpath("//*[text()='Ok']");

	// Verification of Leave Page
	By applyLeavePageText = By.xpath("(//*[text()='Apply Leave'])[2]");

	public void leaveManagementLinks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveManagementLink));
		wait.until(ExpectedConditions.elementToBeClickable(leaveManagementLink));
		driver.findElement(leaveManagementLink).click();
//		wait.until(ExpectedConditions.elementToBeClickable(lopWarningOkButton));
//		driver.findElement(lopWarningOkButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(applyLeaveButton));
		driver.findElement(applyLeaveButton).click();
	}

	public void verifyApplyLeavePage() {
		wait.until(ExpectedConditions.elementToBeClickable(applyLeavePageText));
		Boolean applyLeaveTextDisplayed = cm.isElementDisplayed(applyLeavePageText);
		System.out.println("Apply Leave text is Displayed?==" + applyLeaveTextDisplayed);
		Assert.assertTrue(applyLeaveTextDisplayed, "Apply Leave text is not displayed");
	}

}
