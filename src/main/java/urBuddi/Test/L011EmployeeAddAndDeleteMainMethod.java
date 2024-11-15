package urBuddi.Test;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urBuddi.Pages.L012EmployeeAddAndDeleteMethods;

public class L011EmployeeAddAndDeleteMainMethod {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		L012EmployeeAddAndDeleteMethods obj = new L012EmployeeAddAndDeleteMethods(wait, driver);

		obj.loginToApplication("suresh.salloju@openskale.com", "suresh_123");
		obj.verifyLoginIsSuccessful();
		obj.addEmployeeLinks();
		Thread.sleep(5000);
		obj.verifyAddEmployeePage();
		obj.addEmployeeInputs();
		Thread.sleep(5000);
		obj.verifyAddEmployeeSuccessful(obj.empIDInput);
		Thread.sleep(5000);
		obj.DeleteAddEmployee();
		Thread.sleep(5000);
		obj.verifyAddEmployeeAfterDelete(obj.empIDInput);

		driver.close();

	}

}
