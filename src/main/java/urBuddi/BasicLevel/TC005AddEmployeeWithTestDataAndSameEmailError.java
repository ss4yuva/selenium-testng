package urBuddi.BasicLevel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TC005AddEmployeeWithTestDataAndSameEmailError {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));

		Random random = new Random();
		int x = random.nextInt(100);

		// Locators
		By emailInputfield = By.id("userEmail");
		By passwordInputfield = By.id("userPassword");
		By loginButton = By.xpath("//*[@type='submit']");

		By employeesLink = By.xpath("//*[text()='Employees']");
		By addEmployeeButton = By.xpath("//*[text()='Add Employee']");

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

		By idOrEmailExistError = By.xpath("//*[text()='Employee with ID or Email already exists.']");

		// Test Data
		String userNameValue = "suresh.salloju@openskale.com", passwordValue = "New@2024";

		// input fields Data
		String firstName = "First", lastName = "Last", email = "test@gmail.com", password = "abcd@123",
				department = "Software", designation = "QA Lead", location = "Hyderabad";

		int employeeID = 100, mobileNumber = 1234567890, salary = 25000;

		String roleValue = "Employee", qualificationsValue = "B.Tech", genderValue = "Female", bloodGroupValue = "O+",
				reportingValue = "test57@gmail.com";

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userNameValue);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(passwordValue);
		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeesLink));
		driver.findElement(employeesLink).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeButton));
		driver.findElement(addEmployeeButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInputfield));
		driver.findElement(firstNameInputfield).click();
		driver.findElement(firstNameInputfield).sendKeys(firstName);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputfield));
		driver.findElement(lastNameInputfield).click();
		driver.findElement(lastNameInputfield).sendKeys(lastName);

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDInputfield));
		driver.findElement(employeeIDInputfield).click();
		driver.findElement(employeeIDInputfield).sendKeys("" + employeeID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeEmailInputfield));
		driver.findElement(addEmployeeEmailInputfield).click();
		driver.findElement(addEmployeeEmailInputfield).sendKeys(email);

		wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
		Select selectRoleDropdown = new Select(driver.findElement(roleDropdown));
		selectRoleDropdown.selectByVisibleText(roleValue);

		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeePasswordInputfield));
		driver.findElement(addEmployeePasswordInputfield).click();
		driver.findElement(addEmployeePasswordInputfield).sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
		WebElement dob = driver.findElement(dateOfBirth);
		dob.sendKeys("28-08-1992");

		wait.until(ExpectedConditions.elementToBeClickable(joiningDate));
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("Today Date: " + formattedDate);
		driver.findElement(joiningDate).sendKeys(formattedDate);

		wait.until(ExpectedConditions.elementToBeClickable(qualificationsDropdown));
		Select selectQualificationsDropdown = new Select(driver.findElement(qualificationsDropdown));
		selectQualificationsDropdown.selectByVisibleText(qualificationsValue);

		wait.until(ExpectedConditions.visibilityOfElementLocated(departmentInputfield));
		driver.findElement(departmentInputfield).click();
		driver.findElement(departmentInputfield).sendKeys(department);

		wait.until(ExpectedConditions.elementToBeClickable(genderDropdown));
		Select selectGenderDropdown = new Select(driver.findElement(genderDropdown));
		selectGenderDropdown.selectByVisibleText(genderValue);

		wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberInputfield));
		driver.findElement(mobileNumberInputfield).click();
		driver.findElement(mobileNumberInputfield).sendKeys("" + mobileNumber);

		wait.until(ExpectedConditions.elementToBeClickable(bloodGroupDropdown));
		Select selectBloodGroupDropdown = new Select(driver.findElement(bloodGroupDropdown));
		selectBloodGroupDropdown.selectByVisibleText(bloodGroupValue);

		wait.until(ExpectedConditions.visibilityOfElementLocated(designationInputfield));
		driver.findElement(designationInputfield).click();
		driver.findElement(designationInputfield).sendKeys(designation);

		wait.until(ExpectedConditions.visibilityOfElementLocated(salaryInputfield));
		driver.findElement(salaryInputfield).click();
		driver.findElement(salaryInputfield).sendKeys("" + salary);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locationInputfield));
		driver.findElement(locationInputfield).click();
		driver.findElement(locationInputfield).sendKeys(location);

		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(reportingToDropdown));
		Select selectReportingToDropdown = new Select(driver.findElement(reportingToDropdown));
		selectReportingToDropdown.selectByVisibleText(reportingValue);

		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		driver.findElement(addButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(idOrEmailExistError));
		WebElement idOrEmailMatchingError = driver.findElement(idOrEmailExistError);
		String idorEmailerrorText = idOrEmailMatchingError.getText();
		System.out.println("id or Email error text is: " + idorEmailerrorText);
		if (idorEmailerrorText.equals("*Employee with ID or Email already exists.")) {
			System.out.println("Expected Error text is showing");
		} else {
			System.out.println("Expected Error text is not showing");
		}

		driver.close();
	}
}