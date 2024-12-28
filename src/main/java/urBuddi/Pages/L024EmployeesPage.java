package urBuddi.Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import urBuddi.CommonMethods;

public class L024EmployeesPage {

	static WebDriver driver;
	static WebDriverWait wait;
	static Random random, randomNumber;
	int employeeIDRadomNumber;
	public String empIDInput;
	CommonMethods cm;

	public L024EmployeesPage(WebDriverWait w, WebDriver d) {
		this.wait = w;
		this.driver = d;
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

	// Add Employee PopupPage Locators
	By addEmployeeButton = By.xpath("//*[text()='Add Employee']");
	By addEmployeePageText = By.xpath("//*[@class='modal-heading']");

	By firstNameInputfield = By.name("firstName");
	By lastNameInputfield = By.name("lastName");
	By employeeIDInputfield = By.id("employeeID");
	By addEmployeeEmailInputfield = By.name("email");
	By roleDropdown = By.id("role");
	By addEmployeePasswordInputfield = By.name("password");

	By dateOfBirth = By.name("dob");
	By joiningDate = By.name("joiningDate");

	By qualificationsDropdown = By.id("qualifications");
	By departmentInputfield = By.name("department");
	By genderDropdown = By.id("gender");
	By mobileNumberInputfield = By.name("mobileNumber");
	By bloodGroupDropdown = By.id("bloodGroup");
	By designationInputfield = By.name("designation");
	By salaryInputfield = By.id("salary");
	By locationInputfield = By.name("location");
	By reportingToDropdown = By.id("reportingTo");
	By certificatesDropdown = By.xpath("//*[@class='dropdown-btn']");
	By certificateDropdownValue = By.name("Intermediate");
	By addButton = By.xpath("//*[text()='Add']");

	// After Add Employee Login Success Message
	By loginSuccessMessage = By.id("root");

	// After Add Employee Search And Delete Locators
	By employeeIDSearchField = By.xpath("//*[@aria-label='EMP ID Filter Input']");

	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By deleteIcon = By.xpath("//*[@class='deleteIcon']");

	public void clickOnAddEmployeeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
		driver.findElement(addEmployeeButton).click();
	}

	public void verifyAddEmployeePage() throws InterruptedException {
		Thread.sleep(5000);
		Boolean addEMployeeTextDisplayed = cm.isElementDisplayed(addEmployeePageText);
		System.out.println("Add Employee Text Is Displayed?==" + addEMployeeTextDisplayed);
		Assert.assertTrue(addEMployeeTextDisplayed, "Add Employee Button Is Not Clicked");
	}

	public void enterFirstName(String employeefirstName) {
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInputfield));
		driver.findElement(firstNameInputfield).click();
		driver.findElement(firstNameInputfield).sendKeys(employeefirstName);
	}

	public void enterLastName(String employeeLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInputfield));
		driver.findElement(lastNameInputfield).click();
		driver.findElement(lastNameInputfield).sendKeys(employeeLastName);
	}

	public void enterEmployeeID(String employeeIDNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(employeeIDInputfield));
		driver.findElement(employeeIDInputfield).click();
		driver.findElement(employeeIDInputfield).sendKeys(employeeIDNumber);

	}

	public void enterEmail(String employeeEmail) {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeEmailInputfield));
		driver.findElement(addEmployeeEmailInputfield).click();
		driver.findElement(addEmployeeEmailInputfield).sendKeys(employeeEmail);
	}

	public void enterRole(String employeeRole) {
		wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
		Select selectRoleDropdown = new Select(driver.findElement(roleDropdown));
		selectRoleDropdown.selectByVisibleText(employeeRole);
	}

	public void enterPassword(String employeePassword) {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeePasswordInputfield));
		driver.findElement(addEmployeePasswordInputfield).click();
		driver.findElement(addEmployeePasswordInputfield).sendKeys(employeePassword);
	}

	public void enterDOB(String birthDate) {
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
		WebElement dob = driver.findElement(dateOfBirth);
		dob.sendKeys(birthDate);
	}

	public void enterJoiningDate() {
		wait.until(ExpectedConditions.elementToBeClickable(joiningDate));
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		driver.findElement(joiningDate).sendKeys(formattedDate);
	}

	public void enterQualifications(String employeeQualifications) {
		wait.until(ExpectedConditions.elementToBeClickable(qualificationsDropdown));
		Select selectQualificationsDropdown = new Select(driver.findElement(qualificationsDropdown));
		selectQualificationsDropdown.selectByVisibleText(employeeQualifications);
	}

	public void enterDepartment(String employeeDepartment) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(departmentInputfield));
		driver.findElement(departmentInputfield).click();
		driver.findElement(departmentInputfield).sendKeys(employeeDepartment);
	}

	public void enterGender(String employeeGender) {
		wait.until(ExpectedConditions.elementToBeClickable(genderDropdown));
		Select selectGenderDropdown = new Select(driver.findElement(genderDropdown));
		selectGenderDropdown.selectByVisibleText(employeeGender);
	}

	public void enterMobileNumber(String employeeMobileNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberInputfield));
		driver.findElement(mobileNumberInputfield).click();
		driver.findElement(mobileNumberInputfield).sendKeys(employeeMobileNumber);
	}

	public void enterBloodGroup(String employeeBloodGroup) {
		wait.until(ExpectedConditions.elementToBeClickable(bloodGroupDropdown));
		Select selectBloodGroupDropdown = new Select(driver.findElement(bloodGroupDropdown));
		selectBloodGroupDropdown.selectByVisibleText(employeeBloodGroup);
	}

	public void enterDesignation(String employeeDesignation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(designationInputfield));
		driver.findElement(designationInputfield).click();
		driver.findElement(designationInputfield).sendKeys(employeeDesignation);
	}

	public void enterSalary(int employeeSalary) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(salaryInputfield));
		driver.findElement(salaryInputfield).click();
		driver.findElement(salaryInputfield).sendKeys("" + employeeSalary);
	}

	public void enterLocation(String employeeLocation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationInputfield));
		driver.findElement(locationInputfield).click();
		driver.findElement(locationInputfield).sendKeys(employeeLocation);
	}

	public void enterReportingTo(String reportingDetails) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(reportingToDropdown));
		Select selectReportingToDropdown = new Select(driver.findElement(reportingToDropdown));
		selectReportingToDropdown.selectByVisibleText(reportingDetails);
	}

	public void clickOnAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		driver.findElement(addButton).click();
	}

	public void enterAddEmployeePageTestData() {
		String firstnameRandomText = generateRandomString(6);
		enterFirstName(firstnameRandomText);

		String lastNameRandomText = generateRandomString(6);
		enterLastName(lastNameRandomText);

		employeeIDRadomNumber = randomNumber.nextInt(10000);
		empIDInput = "OW" + employeeIDRadomNumber;
		enterEmployeeID(empIDInput);

		int emailRandom = randomNumber.nextInt(1000);
		String inputEmail = "qa" + emailRandom + "@gmail.com";
		enterEmail(inputEmail);

		enterRole("Employee");

		int randomPassword = randomNumber.nextInt(100);
		String inputPassword = "abcd@" + randomPassword;
		enterPassword(inputPassword);

		enterDOB("28-08-1992");

		enterJoiningDate();

		enterQualifications("B.Tech");

		String departmentRandomText = generateRandomString(6);
		enterDepartment(departmentRandomText);

		enterGender("Female");

		int mobileNumberRadomNumber = randomNumber.nextInt(1000000000);
		String mobileNumnerinput = "1" + mobileNumberRadomNumber;
		enterMobileNumber(mobileNumnerinput);

		enterBloodGroup("O+");

		String designationRandomText = generateRandomString(6);
		enterDesignation(designationRandomText);

		int salaryRadomNumber = randomNumber.nextInt(100000);
		enterSalary(salaryRadomNumber);

		String locationRandomText = generateRandomString(10);
		enterLocation(locationRandomText);

		enterReportingTo("lead@optimworks.com");

		clickOnAddButton();
	}

	public void verifyNewEmployeeIsAddedSuccessful() throws InterruptedException {
		Thread.sleep(5000);
		Boolean loginPopUpDisplayed = cm.isElementDisplayed(loginSuccessMessage);
		System.out.println("Login Success PopUp Is Displayed?==" + loginPopUpDisplayed);
		Assert.assertTrue(loginPopUpDisplayed, "Login Success PopUp Is Not Displayed");
	}

	public void searchNewEmployeeWithEmpID(String empID) throws InterruptedException {
		Thread.sleep(5000);
		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);
	}

	public void deleteNewlyAddedEmployeeWithEmployeeID() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox));
		driver.findElement(employeeIDCheckBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
		driver.findElement(deleteIcon).click();
		Thread.sleep(1500);
	}

	public void verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(String empID) throws InterruptedException {
		Thread.sleep(5000);
		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);
		Thread.sleep(2000);
		Boolean eemployeeRecordIsPresent = cm.isElementDisplayed(employeeSearchIDValue);
		System.out.println("Employee Record Deleted Successful?==" + eemployeeRecordIsPresent);
		Assert.assertTrue(eemployeeRecordIsPresent, "Employee Record is not deleted");
	}
}
