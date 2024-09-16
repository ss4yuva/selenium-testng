package urBuddi;

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

public class TC003AddEmployeeWithRandom {

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("govardhan.gottemukkula@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("Govardhan_123");
		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeesLink));
		driver.findElement(employeesLink).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeButton));
		driver.findElement(addEmployeeButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(firstNameInputfield));
		driver.findElement(firstNameInputfield).click();
		driver.findElement(firstNameInputfield).sendKeys("First Name");

		wait.until(ExpectedConditions.elementToBeClickable(lastNameInputfield));
		driver.findElement(lastNameInputfield).click();
		driver.findElement(lastNameInputfield).sendKeys("Last Name");

		wait.until(ExpectedConditions.elementToBeClickable(employeeIDInputfield));
		driver.findElement(employeeIDInputfield).click();
		driver.findElement(employeeIDInputfield).sendKeys("0" + x);

		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeEmailInputfield));
		driver.findElement(addEmployeeEmailInputfield).click();
		driver.findElement(addEmployeeEmailInputfield).sendKeys("test" + x + "@gmail.com");

		wait.until(ExpectedConditions.visibilityOfElementLocated(roleDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
		driver.findElement(roleDropdown).click();
		Thread.sleep(2000);
		int r = random.nextInt(3);
		Select selectRoleDropdown = new Select(driver.findElement(roleDropdown));
		selectRoleDropdown.selectByIndex(r);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(addEmployeePasswordInputfield));
		driver.findElement(addEmployeePasswordInputfield).click();
		driver.findElement(addEmployeePasswordInputfield).sendKeys("abcd@" + x);

		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth));
		WebElement dob = driver.findElement(dateOfBirth);
		dob.sendKeys("28-08-1992");

		wait.until(ExpectedConditions.elementToBeClickable(joiningDate));
		WebElement joining = driver.findElement(joiningDate);
		joining.sendKeys("01-01-2024");

		wait.until(ExpectedConditions.visibilityOfElementLocated(qualificationsDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(qualificationsDropdown));
		driver.findElement(qualificationsDropdown).click();
		Thread.sleep(2000);
		int q = random.nextInt(2);
		Select selectQualificationDropdown = new Select(driver.findElement(qualificationsDropdown));
		selectQualificationDropdown.selectByIndex(q);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(departmentInputfield));
		driver.findElement(departmentInputfield).click();
		driver.findElement(departmentInputfield).sendKeys("Software");

		wait.until(ExpectedConditions.visibilityOfElementLocated(genderDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(genderDropdown));
		driver.findElement(genderDropdown).click();
		int g = random.nextInt(3);
		Thread.sleep(2000);
		Select selectGenderDropdown = new Select(driver.findElement(genderDropdown));
		selectGenderDropdown.selectByIndex(g);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(mobileNumberInputfield));
		driver.findElement(mobileNumberInputfield).click();
		driver.findElement(mobileNumberInputfield).sendKeys("1234567890");

		wait.until(ExpectedConditions.visibilityOfElementLocated(bloodGroupDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(bloodGroupDropdown));
		Thread.sleep(2000);
		int b = random.nextInt(7);
		driver.findElement(bloodGroupDropdown).click();
		Select selectBloodGroupDropdown = new Select(driver.findElement(bloodGroupDropdown));
		selectBloodGroupDropdown.selectByIndex(b);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(designationInputfield));
		driver.findElement(designationInputfield).click();
		driver.findElement(designationInputfield).sendKeys("QA lead");

		wait.until(ExpectedConditions.elementToBeClickable(salaryInputfield));
		driver.findElement(salaryInputfield).click();
		driver.findElement(salaryInputfield).sendKeys("25000");

		wait.until(ExpectedConditions.elementToBeClickable(locationInputfield));
		driver.findElement(locationInputfield).click();
		driver.findElement(locationInputfield).sendKeys("Hyderabad");

		wait.until(ExpectedConditions.visibilityOfElementLocated(reportingToDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(reportingToDropdown));
		driver.findElement(reportingToDropdown).click();
		Thread.sleep(2000);
		int rp = random.nextInt(10);
		Select selectReportingDropdown = new Select(driver.findElement(reportingToDropdown));
		selectReportingDropdown.selectByIndex(rp);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(certificatesDropdown));
		driver.findElement(certificatesDropdown).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(certificateDropdownValue));
		driver.findElement(certificateDropdownValue).click();
		Thread.sleep(5000);
		driver.findElement(certificatesDropdown).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		driver.findElement(addButton).click();
		Thread.sleep(5000);

//		driver.close();

	}

}
