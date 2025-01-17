package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class LeaveManagementPage {
	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods cm;

	public LeaveManagementPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Locators
	// Login to Application locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");

	// Verification of Login
	By companyLogo = By.xpath("//*[@class='company-logo-header']");

	// Leave page
	By fromDateField = By.id("fromDate");
	By todateField = By.id("toDate");
	By numberofdatetext = By.xpath("//*[text()='No of Days : ']");
	By selectLeadInputField = By.name("lead");
	By subjectInputField = By.name("subject");
	By reasonForLeaveInputField = By.name("reason");
	By selectRequestTypeCheckBox = By.id("leave");
	By submitButton = By.xpath("//*[text()='Submit']");

	// Verification of Leave application
	By startDateInputField = By.xpath("(//*[@class='ag-input-field-input ag-text-field-input'])[1]");
	By leaveAppliedRow = By.xpath("//*[@class='ag-center-cols-container']");

	// Leave cancel
	By leaveCancelButton = By.xpath("//*[text()='Cancel']");
	By leaveCancelReasonInputField = By.id("reason");
	By leaveCanelSubmitButton = By.xpath("//*[text()='Submit']");

	By cancelReasonText = By.xpath("//*[text()='Test of Leave cancel']");

	public void fromDateInputField(String fromDate) {
		wait.until(ExpectedConditions.elementToBeClickable(fromDateField));
		WebElement fDateFiled = driver.findElement(fromDateField);
		fDateFiled.sendKeys(fromDate);
	}

	public void toDateInputField(String toDate) {
		wait.until(ExpectedConditions.elementToBeClickable(todateField));
		WebElement tDateFiled = driver.findElement(todateField);
		tDateFiled.sendKeys(toDate);
	}

	public void selectLead(String selectLeadDropdown) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectLeadInputField));
		Select leadDropdown = new Select(driver.findElement(selectLeadInputField));
		leadDropdown.selectByVisibleText(selectLeadDropdown);
	}

	public void subjectInput(String subject) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInputField));
		WebElement subjectInField = driver.findElement(subjectInputField);
		subjectInField.sendKeys(subject);
	}

	public void reasonForLeave(String reason) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(reasonForLeaveInputField));
		WebElement reasonInputField = driver.findElement(reasonForLeaveInputField);
		reasonInputField.sendKeys(reason);
	}

	public void requestType(String request) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectRequestTypeCheckBox));
		WebElement requestTypeCheckBok = driver.findElement(selectRequestTypeCheckBox);
		requestTypeCheckBok.click();
	}

	public void submit() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
		WebElement clickSubmit = driver.findElement(submitButton);
		clickSubmit.click();
	}

	public void applyLeavepageInputs() {
		fromDateInputField("25-01");

		toDateInputField("30-01");

		selectLead("test57@gmail.com");

		subjectInput("Test");

		reasonForLeave("Automation Testing");

		requestType("Leave");

		submit();
	}

	// VERIFY LEAVE APPLIED OR NOT
	public void verifyApplicationOfLeave() {
		wait.until(ExpectedConditions.elementToBeClickable(startDateInputField));
		driver.findElement(startDateInputField).click();
		driver.findElement(startDateInputField).sendKeys("12-01-2025");

		wait.until(ExpectedConditions.elementToBeClickable(leaveAppliedRow));
		Boolean leaveappliedRowDisplayed = cm.isElementDisplayed(leaveAppliedRow);
		System.out.println("Leave applied Row is Displayed?==" + leaveappliedRowDisplayed);
		Assert.assertTrue(leaveappliedRowDisplayed, "Leave Applied row is not displayed");
	}

	public void cancelAppliedLeave() {
		wait.until(ExpectedConditions.elementToBeClickable(leaveCancelButton));
		driver.findElement(leaveCancelButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(leaveCancelReasonInputField));
		driver.findElement(leaveCancelReasonInputField).click();
		driver.findElement(leaveCancelReasonInputField).sendKeys("Test of Leave cancel");

		wait.until(ExpectedConditions.elementToBeClickable(leaveCanelSubmitButton));
		driver.findElement(leaveCanelSubmitButton).click();
	}

	public void verifyLaeveCancel() {
		driver.navigate().refresh();

		wait.until(ExpectedConditions.elementToBeClickable(cancelReasonText));
		Boolean cancelRequestTextDisplayed = cm.isElementDisplayed(cancelReasonText);
		System.out.println("Cancel Request text is Displayed?==" + cancelRequestTextDisplayed);
		Assert.assertTrue(cancelRequestTextDisplayed, "Cancel Request text is not Displayed");
	}
}
