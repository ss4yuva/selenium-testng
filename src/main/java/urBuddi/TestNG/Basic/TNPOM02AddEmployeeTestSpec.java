package urBuddi.TestNG.Basic;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import urBuddi.Pages.AddEmployeePage;
import urBuddi.Pages.DashBoardPage;
import urBuddi.Pages.LoginToApplication;

public class TNPOM02AddEmployeeTestSpec {
	static WebDriver driver;
	static WebDriverWait wait;
	LoginToApplication LoginToApplication;
	DashBoardPage DashBoardPage;
	AddEmployeePage AddEmployeePage;
	
	@BeforeTest
	public void browserLaunch() {
		System.out.println("Before Test");

		// driver = getDriver();
		System.out.println("Before Test");
		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");

		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		LoginToApplication = new LoginToApplication(wait, driver);
		DashBoardPage = new DashBoardPage(wait, driver);
		AddEmployeePage = new AddEmployeePage(wait, driver);
	}

	@Test
	public void verifyLoginIsSuccessful() throws InterruptedException {
		System.out.println("Actual Test");

		LoginToApplication.loginToApplication("suresh.salloju@openskale.com", "New@2024");
		LoginToApplication.verifyLoginIsSuccessful();

		DashBoardPage.clickOnEmployeesButton();
		AddEmployeePage.verifyAddEmployeePage();
		AddEmployeePage.addEmployeeInputs();
		Thread.sleep(1000);
		AddEmployeePage.verifyAddEmployeeSuccessful(AddEmployeePage.empIDInput);
	}

	@AfterTest
	public void close() {
		System.out.println("After Test");
		driver.close();
	}

}
