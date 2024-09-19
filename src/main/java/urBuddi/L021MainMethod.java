package urBuddi;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L021MainMethod {
	static WebDriver driver;
	static WebDriverWait wait;
	String empIDInput;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		L022LoginPage loginPage = new L022LoginPage(wait, driver);
		L023DashBoardPage dashBoardPage = new L023DashBoardPage(wait, driver);
		L024EmployeesPage employeePage = new L024EmployeesPage(wait, driver);

		loginPage.loginToApplication("govardhan.gottemukkula@openskale.com", "Govardhan_123");
		loginPage.verifyLoginIsSuccessful();
		dashBoardPage.employeesButton();
		employeePage.addEmployeeButton();
		employeePage.verifyAddEmployeePage();
		employeePage.addEmployeePageTestData();
		employeePage.verifyNewEmployeeIsAddedSuccessful();
		employeePage.searchNewEmployee(employeePage.empIDInput);
		employeePage.deleteNewlyAddedEmployee();
		employeePage.verifyNewlyAddedEmployeeDelettionIsSuccessful(employeePage.empIDInput);
		Thread.sleep(5000);
		
		driver.close();
	}

}
