package urBuddi;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L01EMployeeAddAndDeleteMainMethod {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static Random random, randomNumber;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();

		driver.get("https://dev.urbuddi.com/login");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		random = new Random();
		randomNumber = new Random();

		TC013DeleteAndVerifyTheAddEmployee obj = new TC013DeleteAndVerifyTheAddEmployee();

		obj.loginToApplication("govardhan.gottemukkula@openskale.com", "Govardhan_123");
		obj.verifyLoginIsSuccessful();
		obj.addEmployeeLinks();
		Thread.sleep(10000);
		obj.verifyAddEmployeePage();
		obj.addEmployeeInputs();
		Thread.sleep(10000);
		obj.verifyAddEmployeeSuccessful(obj.empIDInput);
		obj.DeleteAddEmployee();
		obj.verifyAddEmployeeAfterDelete(obj.empIDInput);

		driver.close();

	}

}
