package urBuddi.BasicLevel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC012VerificationOfAddEmployeeWithAssertion {

	static WebDriver driver;
	static WebDriverWait wait;
	static Random random, randomNumber;
	int employeeIDRadomNumber;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10000));

		random = new Random();
		randomNumber = new Random();

		TC012VerificationOfAddEmployeeWithAssertion obj = new TC012VerificationOfAddEmployeeWithAssertion();

		obj.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		obj.verifyLoginIsSuccessful();
		obj.addEmployeeLinks();
		Thread.sleep(10000);
		obj.verifyAddEmployeePage();
		obj.addEmployeeInputs();
		Thread.sleep(10000);
		obj.verifyAddEmployeeSuccessful(obj.employeeIDRadomNumber);

		driver.close();
	}

	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder randomText = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			// stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
			int index = random.nextInt(characters.length());
			randomText.append(characters.charAt(index));
		}
		return randomText.toString();
	}

	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");

	By profileIcon = By.xpath("//*[@class='profile-icon-container']");

	By employeesLink = By.xpath("//*[text()='Employees']");
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

	By employeeIDSearchField = By.xpath("//*[@aria-label='EMP ID Filter Input']");

	public void loginToApplication(String userName, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void verifyLoginIsSuccessful() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
		Assert.assertTrue(true, "Login is Successful");
	}

	public void addEmployeeLinks() {
		wait.until(ExpectedConditions.elementToBeClickable(employeesLink));
		driver.findElement(employeesLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
		driver.findElement(addEmployeeButton).click();
	}

	public void verifyAddEmployeePage() {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeePageText));
		WebElement employeePageText = driver.findElement(addEmployeePageText);
		String employeePageT = employeePageText.getText();
		Assert.assertEquals(employeePageT, "Add Employee");
	}

	public void firstName(String employeefirstName) {
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInputfield));
		driver.findElement(firstNameInputfield).click();
		driver.findElement(firstNameInputfield).sendKeys(employeefirstName);
	}

	public void lastName(String employeeLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInputfield));
		driver.findElement(lastNameInputfield).click();
		driver.findElement(lastNameInputfield).sendKeys(employeeLastName);
	}

	public void employeeID(int employeeIDNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(employeeIDInputfield));
		driver.findElement(employeeIDInputfield).click();
		driver.findElement(employeeIDInputfield).sendKeys("" + employeeIDNumber);

	}

	public void email(String employeeEmail) {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeEmailInputfield));
		driver.findElement(addEmployeeEmailInputfield).click();
		driver.findElement(addEmployeeEmailInputfield).sendKeys(employeeEmail);
	}

	public void role(String employeeRole) {
		wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
		Select selectRoleDropdown = new Select(driver.findElement(roleDropdown));
		selectRoleDropdown.selectByVisibleText(employeeRole);
	}

	public void password(String employeePassword) {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeePasswordInputfield));
		driver.findElement(addEmployeePasswordInputfield).click();
		driver.findElement(addEmployeePasswordInputfield).sendKeys(employeePassword);
	}

	public void dob(String birthDate) {
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
		WebElement dob = driver.findElement(dateOfBirth);
		dob.sendKeys(birthDate);
	}

	public void joiningDate() {
		wait.until(ExpectedConditions.elementToBeClickable(joiningDate));
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		driver.findElement(joiningDate).sendKeys(formattedDate);
	}

	public void qualifications(String employeeQualifications) {
		wait.until(ExpectedConditions.elementToBeClickable(qualificationsDropdown));
		Select selectQualificationsDropdown = new Select(driver.findElement(qualificationsDropdown));
		selectQualificationsDropdown.selectByVisibleText(employeeQualifications);
	}

	public void department(String employeeDepartment) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(departmentInputfield));
		driver.findElement(departmentInputfield).click();
		driver.findElement(departmentInputfield).sendKeys(employeeDepartment);
	}

	public void gender(String employeeGender) {
		wait.until(ExpectedConditions.elementToBeClickable(genderDropdown));
		Select selectGenderDropdown = new Select(driver.findElement(genderDropdown));
		selectGenderDropdown.selectByVisibleText(employeeGender);
	}

	public void mobileNumber(int employeeMobileNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberInputfield));
		driver.findElement(mobileNumberInputfield).click();
		driver.findElement(mobileNumberInputfield).sendKeys("1" + employeeMobileNumber);
	}

	public void bloodGroup(String employeeBloodGroup) {
		wait.until(ExpectedConditions.elementToBeClickable(bloodGroupDropdown));
		Select selectBloodGroupDropdown = new Select(driver.findElement(bloodGroupDropdown));
		selectBloodGroupDropdown.selectByVisibleText(employeeBloodGroup);
	}

	public void designation(String employeeDesignation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(designationInputfield));
		driver.findElement(designationInputfield).click();
		driver.findElement(designationInputfield).sendKeys(employeeDesignation);
	}

	public void salary(int employeeSalary) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(salaryInputfield));
		driver.findElement(salaryInputfield).click();
		driver.findElement(salaryInputfield).sendKeys("" + employeeSalary);
	}

	public void location(String employeeLocation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationInputfield));
		driver.findElement(locationInputfield).click();
		driver.findElement(locationInputfield).sendKeys(employeeLocation);
	}

	public void reporting(String reportingDetails) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(reportingToDropdown));
		Select selectReportingToDropdown = new Select(driver.findElement(reportingToDropdown));
		selectReportingToDropdown.selectByVisibleText(reportingDetails);
	}

	public void addButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		driver.findElement(addButton).click();
	}

	public void verifyAddEmployeeSuccessful(int empID) {

		By employeeSearchIDValue = By.xpath("//*[text()='" + Integer.toString(empID) + "']");

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		Assert.assertTrue(true, "Login is Successful");
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys("" + empID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeSearchIDValue));
		driver.findElement(employeeSearchIDValue).click();

	}

	public void addEmployeeInputs() {
		String firstnameRandomText = generateRandomString(6);
		firstName(firstnameRandomText);

		String lastNameRandomText = generateRandomString(6);
		lastName(lastNameRandomText);

		employeeIDRadomNumber = randomNumber.nextInt(1000);
		employeeID(employeeIDRadomNumber);

		int emailRandom = randomNumber.nextInt(100);
		email("qa" + emailRandom + "@gmail.com");

		role("Employee");

		int randomPassword = randomNumber.nextInt(100);
		password("abcd@" + randomPassword);

		dob("28-08-1992");

		joiningDate();

		qualifications("B.Tech");

		String departmentRandomText = generateRandomString(6);
		department(departmentRandomText);

		gender("Female");

		int mobileNumberRadomNumber = randomNumber.nextInt(1000000000);
		mobileNumber(mobileNumberRadomNumber);

		bloodGroup("O+");

		String designationRandomText = generateRandomString(6);
		designation(designationRandomText);

		int salaryRadomNumber = randomNumber.nextInt(100000);
		salary(salaryRadomNumber);

		String locationRandomText = generateRandomString(10);
		location(locationRandomText);

		reporting("test57@gmail.com");

		addButton();
	}

}
