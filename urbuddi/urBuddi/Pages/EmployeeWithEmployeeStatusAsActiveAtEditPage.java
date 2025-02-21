package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class EmployeeWithEmployeeStatusAsActiveAtEditPage {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;

	String editEmployeeFName, editEmployeeLName;

	public EmployeeWithEmployeeStatusAsActiveAtEditPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// After Add Employee Search Locators
	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By employeeIDSearchField = By.xpath("(//*[@class='ag-input-field-input ag-text-field-input'])[1]");

	// Edit Employee Locators
	By editButton = By.xpath("//*[@class='ag-cell ag-cell-not-inline-editing ag-cell-normal-height ag-cell-value']");
	By editEmployeeHeaderText = By.xpath("//*[text()='Edit Employee']");

	// Edit Employee Page Locators
	By firstNameInputfield = By.name("firstName");
	By lastNameInputfield = By.name("lastName");
	By employeeStatusDropdown = By.id("employeeStatus");

	By submitButton = By.xpath("//*[@type='submit']");

	// Search With Edit Employee After Details Edited
	By searchField = By.xpath("//*[@aria-label='NAME Filter Input']");

	By activeEmpStatus = By.xpath("//*[text()='Active']");

	public void searchNewEmployeeWithEmpID(String empID) throws InterruptedException {

		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		System.out.println("ID IS--->" + empID);
		driver.findElement(employeeIDSearchField).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);
	}

	public void clickOnEditButton() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		driver.findElement(editButton).click();
	}

	public void verifyEditEmployeePage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(editEmployeeHeaderText));
		Boolean editEmployeeHeaderTextDisplayed = cm.isElementDisplayed(editEmployeeHeaderText);
		System.out.println("Edit Employee Page Header text Is Displayed?==" + editEmployeeHeaderTextDisplayed);
		Assert.assertTrue(editEmployeeHeaderTextDisplayed, "Edit Employee Page Header text Is Not Showing");
	}

	public void enterFirstName(String editEmployeeFirstName) {
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInputfield));
		driver.findElement(firstNameInputfield).click();
		driver.findElement(firstNameInputfield).clear();
		driver.findElement(firstNameInputfield).sendKeys(editEmployeeFirstName);
	}

	public void enterLastName(String editEmployeeLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInputfield));
		driver.findElement(lastNameInputfield).click();
		driver.findElement(lastNameInputfield).clear();
		driver.findElement(lastNameInputfield).sendKeys(editEmployeeLastName);
	}

	public void enterEmployeeStatus(String employeeStatus) {
		wait.until(ExpectedConditions.elementToBeClickable(employeeStatusDropdown));
		driver.findElement(employeeStatusDropdown).click();
		driver.findElement(employeeStatusDropdown).sendKeys(employeeStatus);
	}

	public void clickOnSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		driver.findElement(submitButton).click();
	}

	public void enterEditEmployeePageTestData() {

		editEmployeeFName = "First";
		enterFirstName(editEmployeeFName);

		editEmployeeLName = "Last";
		enterLastName(editEmployeeLName);

		enterEmployeeStatus("Active");

		clickOnSubmitButton();
	}

	public void searchEditEmployeeDetailsWithEditedFirstAndLastName() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(submitButton));

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		driver.findElement(searchField).click();
		driver.findElement(searchField).sendKeys(editEmployeeFName + " " + editEmployeeLName);
	}

	public void verifyEditEmployeeDetailsWithActiveStatus() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(activeEmpStatus));

		Boolean afterEditEmployeeWithActiveStatusIsDisplayed = cm.isElementDisplayed(activeEmpStatus);
		System.out.println("After Edit Employee First And Last Name With Active Status Is Displayed?=="
				+ afterEditEmployeeWithActiveStatusIsDisplayed);
		Assert.assertTrue(afterEditEmployeeWithActiveStatusIsDisplayed,
				"After Edit Employee First And Last Name With Active Status Is Not Showing");
	}

}
