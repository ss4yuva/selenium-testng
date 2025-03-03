package urBuddi.Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class ApplyLeaveWithRequestTypeAsWorkFromHomePage {
	static WebDriver driver;
	static WebDriverWait wait;

	public String todayFormattedDate;

	CommonMethods cm;

	public ApplyLeaveWithRequestTypeAsWorkFromHomePage(WebDriverWait w, WebDriver d) {
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
	By selectRequestTypeCheckBox = By.id("workFromHome");
	By submitButton = By.xpath("//*[text()='Submit']");

	By monthPickerButton = By.xpath("(//*[@class='react-datepicker__input-container'])[2]");
	By febMonth = By.xpath("//*[text()='Feb']");

	// Verification of Leave application
	By startDateInputField = By.xpath("(//*[@class='ag-input-field-input ag-text-field-input'])[1]");
	By leaveAppliedRow = By.xpath("(//*[@col-id='startDate'])[2]");
	By requestTypeAsWFHField = By.xpath("//*[text()='WFH']");

	public void fromDateInputField() {
		// wait.until(ExpectedConditions.elementToBeClickable(fromDateField));
		// WebElement fDateFiled = driver.findElement(fromDateField);
		// fDateFiled.sendKeys(fromDate);

		wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
		wait.until(ExpectedConditions.elementToBeClickable(fromDateField));
		LocalDate todayDate = LocalDate.now();
		DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("dd-MM");
		todayFormattedDate = todayDate.format(todayFormatter);
		driver.findElement(fromDateField).sendKeys(todayFormattedDate);
	}

	public void toDateInputField() {
		// wait.until(ExpectedConditions.elementToBeClickable(todateField));
		// WebElement tDateFiled = driver.findElement(todateField);
		// tDateFiled.sendKeys(toDate);

		wait.until(ExpectedConditions.visibilityOfElementLocated(todateField));
		wait.until(ExpectedConditions.elementToBeClickable(todateField));
		LocalDate todaytDate = LocalDate.now();
		DateTimeFormatter todayDateFormatter = DateTimeFormatter.ofPattern("dd-MM");
		String formattedDate = todaytDate.format(todayDateFormatter);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter tomorrowDateFormatter = DateTimeFormatter.ofPattern("dd-MM");
		String tomorrowFormattedDate = tomorrow.format(tomorrowDateFormatter);

		WebElement tomorrowDatePicker = driver.findElement(todateField);
		tomorrowDatePicker.sendKeys(tomorrowFormattedDate);
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
		fromDateInputField();

		toDateInputField();

		selectLead("ow.urbuddy@optimworks.com");

		subjectInput("Test");

		reasonForLeave("Automation Testing");

		requestType("Work from Home");

		submit();
	}

	// month change
	public void monthPicker() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(monthPickerButton));
		wait.until(ExpectedConditions.elementToBeClickable(monthPickerButton));
		driver.findElement(monthPickerButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(febMonth));
		driver.findElement(febMonth).click();
	}

	// VERIFY LEAVE APPLIED OR NOT
	public void verifyApplicationOfLeave() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInputField));
		wait.until(ExpectedConditions.elementToBeClickable(startDateInputField));
		driver.findElement(startDateInputField).clear();
		driver.findElement(startDateInputField).click();
		driver.findElement(startDateInputField).sendKeys(todayFormattedDate);

		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveAppliedRow));
		wait.until(ExpectedConditions.elementToBeClickable(leaveAppliedRow));

		Boolean leaveappliedRowDisplayed = cm.isElementDisplayed(requestTypeAsWFHField);
		System.out.println("Leave applied With WFH Option Row is Displayed?==" + leaveappliedRowDisplayed);
		Assert.assertTrue(leaveappliedRowDisplayed, "Leave Applied With WFH Option row is not displayed");
	}

}
