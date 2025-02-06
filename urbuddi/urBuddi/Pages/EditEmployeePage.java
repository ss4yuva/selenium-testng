package urBuddi.Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class EditEmployeePage {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;
	static Random random, randomNumber;
	int employeeIDRadomNumber;
	public String empIDInput;
	int bankAccountRadomNumber, bankIFSCRadomNumber, panRadomNumber;
	String bankIFSCNumberInput, panNumberInput;
	String editEmployeeFName, editEmployeeLName;

	public EditEmployeePage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
		random = new Random();
		randomNumber = new Random();
	}

	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder randomText = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			randomText.append(characters.charAt(index));
		}
		return randomText.toString();
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

	By bankName = By.id("bankName");
	By bankAccountNumber = By.id("bankAccountNumber");
	By bankIFSCNumber = By.id("ifsc");
	By panNumber = By.id("panNumber");

	By submitButton = By.xpath("//*[@type='submit']");

	// Search With Edit Employee After Details Edited
	By searchField = By.xpath("//*[@aria-label='NAME Filter Input']");

	public void searchNewEmployeeWithEmpID(String empID) throws InterruptedException {

		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		System.out.println("ID IS--->" + empID);
		driver.findElement(employeeIDSearchField).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);

		/*
		 * Thread.sleep(5000);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox))
		 * ; driver.findElement(employeeIDCheckBox).click(); By employeeSearchIDValue =
		 * By.xpath("//*[text()='" + empID + "']");
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * employeeIDSearchField)); driver.findElement(employeeIDSearchField).click();
		 * driver.findElement(employeeIDSearchField).sendKeys(empID);
		 */
	}

	public void clickOnEditButton() {

//		wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
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

	public void enterBankName(String employeeBankName) {
		wait.until(ExpectedConditions.elementToBeClickable(bankName));
		driver.findElement(bankName).click();
		driver.findElement(bankName).clear();
		driver.findElement(bankName).sendKeys(employeeBankName);
	}

	public void enterBankAccountNumber(String employeebankAccountNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(bankAccountNumber));
		driver.findElement(bankAccountNumber).click();
		driver.findElement(bankAccountNumber).clear();
		driver.findElement(bankAccountNumber).sendKeys(employeebankAccountNumber);
	}

	public void enterBankIFSCNumber(String employeeBankIFSCNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(bankIFSCNumber));
		driver.findElement(bankIFSCNumber).click();
		driver.findElement(bankIFSCNumber).clear();
		driver.findElement(bankIFSCNumber).sendKeys(employeeBankIFSCNumber);
	}

	public void enterPANNumber(String employeePANNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(panNumber));
		driver.findElement(panNumber).click();
		driver.findElement(panNumber).clear();
		driver.findElement(panNumber).sendKeys(employeePANNumber);
	}

	public void clickOnSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		driver.findElement(submitButton).click();
	}

	public void enterEditEmployeePageTestData() {

		editEmployeeFName = "ASDF";
		enterFirstName(editEmployeeFName);

		editEmployeeLName = "QWER";
		enterLastName(editEmployeeLName);

		String bankName = "AXIS";
		enterBankName(bankName);

		String bankAccountingNumber = "00987654321";
		enterBankAccountNumber(bankAccountingNumber);

		String bankISFSCNumber = "OW0012345678";
		enterBankIFSCNumber(bankISFSCNumber);

		String employeePanNumber = "OW12345678";
		enterPANNumber(employeePanNumber);

		/*
		 * RANDOM TEST DATA Thread.sleep(2000); String bankNameRandomText =
		 * generateRandomString(5); enterBankName(bankNameRandomText);
		 * 
		 * Thread.sleep(2000); int bankAccountRadomNumber =
		 * randomNumber.nextInt(1000000000); String bankNumberInput =
		 * "1"+bankAccountRadomNumber; enterBankAccountNumber(bankNumberInput);
		 * 
		 * Thread.sleep(2000); bankIFSCRadomNumber = randomNumber.nextInt(1000000000);
		 * bankIFSCNumberInput = "OW"+bankIFSCRadomNumber;
		 * enterBankIFSCNumber(bankIFSCNumberInput);
		 * 
		 * Thread.sleep(2000); panRadomNumber = randomNumber.nextInt(1000000000);
		 * panNumberInput = "OW"+panRadomNumber; enterPANNumber(panNumberInput);
		 */

		clickOnSubmitButton();
	}

	public void searchEditEmployeeDetailsWithEditedFirstAndLastName() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(submitButton));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		driver.findElement(searchField).click();
		driver.findElement(searchField).sendKeys(editEmployeeFName + " " + editEmployeeLName);
	}

	public void verifyEditEmployeeDetailsWithEditedFirstAndLastName() {

		By employeeSearchFirstAndLastNameValue = By
				.xpath("//*[text()='" + editEmployeeFName + " " + editEmployeeLName + "']");

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeSearchFirstAndLastNameValue));

		Boolean afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed = cm
				.isElementDisplayed(employeeSearchFirstAndLastNameValue);
		System.out.println("After Edit Employee First And Last Name With Edited Details Is Displayed?=="
				+ afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed);
		Assert.assertTrue(afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed,
				"After Edit Employee First And Last Name With Edited Details Is Not Showing");
	}

}