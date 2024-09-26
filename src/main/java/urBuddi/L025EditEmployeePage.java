package urBuddi;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class L025EditEmployeePage {

	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods cm;
	static Random random, randomNumber;
	int bankAccountRadomNumber, bankIFSCRadomNumber, panRadomNumber;
	String bankIFSCNumberInput, panNumberInput;
	String editEmployeeFName, editEmployeeLName;

	L025EditEmployeePage(WebDriverWait w, WebDriver d) {
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

	// Edit Employee Locators
	By editButton = By.xpath("(//*[contains(@class,'ag-cell ag-cell-not-inline-editing')])[2]");
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

	// Delete Employee After Searching with edit First and Last Name
	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By deleteIcon = By.xpath("//*[@class='deleteIcon']");

	public void clickOnEditButton() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		driver.findElement(editButton).click();
	}

	public void verifyEditEmployeePage() throws InterruptedException {
		Thread.sleep(5000);
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

	public void enterEditEmployeePageTestData() throws InterruptedException {
		Thread.sleep(2000);
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
		 * Thread.sleep(2000); String bankNameRandomText = generateRandomString(5);
		 * enterBankName(bankNameRandomText);
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
		Thread.sleep(2000);
		clickOnSubmitButton();

	}

	public void searchEditEmployeeDetailsWithEditeedFirstAndLastName() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		driver.findElement(searchField).click();
		driver.findElement(searchField).sendKeys(editEmployeeFName + " " + editEmployeeLName);
	}

	public void verifyEditEmployeeDetailsWithEditeedFirstAndLastName() throws InterruptedException {
		Thread.sleep(5000);
		By employeeSearchFirstAndLastNameValue = By
				.xpath("//*[text()='" + editEmployeeFName + " " + editEmployeeLName + "']");
		Boolean afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed = cm
				.isElementDisplayed(employeeSearchFirstAndLastNameValue);
		System.out.println("After Edit Employee First And Last Name With Edited Details Is Displayed?=="
				+ afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed);
		Assert.assertTrue(afterEditEmployeeWithFirstAndLastNameEditedDetailsIsDisplayed,
				"After Edit Employee First And Last Name With Edited Details Is Not Showing");
	}

	public void deleteEditEmployeeWithSearchedFirstAndLastName() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox));
		driver.findElement(employeeIDCheckBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
		driver.findElement(deleteIcon).click();
		Thread.sleep(1500);
	}

}