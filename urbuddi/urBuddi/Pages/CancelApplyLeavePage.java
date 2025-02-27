package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class CancelApplyLeavePage {
	static WebDriver driver;
	static WebDriverWait wait;

	public String todayFormattedDate;

	CommonMethods cm;

	public CancelApplyLeavePage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Locators
	// Leave cancel
	By leaveCancelButton = By.xpath("//*[text()='Cancel']");
	By leaveCancelReasonInputField = By.id("reason");
	By leaveCanelSubmitButton = By.xpath("//*[text()='Submit']");

	By cancelReasonText = By.xpath("//*[text()='Test of Leave cancel']");

	// Verification of Leave application
	By startDateInputField = By.xpath("(//*[@class='ag-input-field-input ag-text-field-input'])[1]");
	By leaveAppliedRow = By.xpath("(//*[@col-id='startDate'])[2]");
	By requestTypeAsLeaveField = By.xpath("//*[text()='Leave']");

	public void cancelAppliedLeave() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInputField));
		wait.until(ExpectedConditions.elementToBeClickable(startDateInputField));
		driver.findElement(startDateInputField).clear();
		driver.findElement(startDateInputField).click();
		driver.findElement(startDateInputField).sendKeys(todayFormattedDate);

		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveCancelButton));
		wait.until(ExpectedConditions.elementToBeClickable(leaveCancelButton));
		driver.findElement(leaveCancelButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(leaveCancelReasonInputField));
		driver.findElement(leaveCancelReasonInputField).click();
		driver.findElement(leaveCancelReasonInputField).sendKeys("Test of Leave cancel");

		wait.until(ExpectedConditions.elementToBeClickable(leaveCanelSubmitButton));
		driver.findElement(leaveCanelSubmitButton).click();
	}

	public void verifyLeaveCancel() {
		driver.navigate().refresh();

		wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInputField));
		wait.until(ExpectedConditions.elementToBeClickable(startDateInputField));
		driver.findElement(startDateInputField).clear();
		driver.findElement(startDateInputField).click();
		driver.findElement(startDateInputField).sendKeys(todayFormattedDate);

		Boolean leaveappliedRowDisplayedorNot = cm.isElementDisplayed(requestTypeAsLeaveField);

		wait.until(ExpectedConditions.visibilityOfElementLocated(cancelReasonText));
		wait.until(ExpectedConditions.elementToBeClickable(cancelReasonText));
		Boolean cancelRequestTextDisplayed = cm.isElementDisplayed(cancelReasonText);
		System.out.println("Cancel Request text is Displayed?==" + cancelRequestTextDisplayed);
		Assert.assertTrue(cancelRequestTextDisplayed, "Cancel Request text is not Displayed");
	}

}
