package urBuddi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunctionalityUsingMenthods1 {

	static WebDriver driver;
	// Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	
	public void loginToApplication(String userName, String password) throws InterruptedException {
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(15000);
	}
	
	public void loginToApplicationWithBlank() throws InterruptedException {
		driver.findElement(loginButton).click();
		Thread.sleep(15000);
	}
	
	public void loginWithInvalid(String userName, String password) {
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://dev.urbuddi.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	
		LoginFunctionalityUsingMenthods1 obj=new LoginFunctionalityUsingMenthods1();
		obj.loginToApplication("govardhan.gottemukkula@openskale.com", "Govardhan_123");
		obj.loginToApplicationWithBlank();
		obj.loginWithInvalid("ss4yuvan@gmail.com", "sruthi@123");

	}
	

}
