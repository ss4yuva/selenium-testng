package urBuddi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestNg {
	
	WebDriver driver = new ChromeDriver();
//	System.setProperty("webdriver.chrome.driver",
//			"D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
//	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
  
	//Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By dashboard = By.xpath("(//*[text()='Dashboard'])[2]");
	By invalidCredentialsError = By.xpath("//*[@class='err-msg-display mt-3']");
	By logoutButton = By.xpath("//*[@class='logout-btn-nav']");
  @BeforeMethod
  public void beforeMethod() {
		driver.get("https://dev.urbuddi.com/login");
  }
  @Test
  public void loginWithValidCredentails() {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("govardhan.gottemukkula@openskale.com");
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("Govardhan_123");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		WebElement dashboardT = driver.findElement(dashboard);
		String dashboardText = dashboardT.getText();
		System.out.println("Dashboard text is: " + dashboardText);
		if (dashboardText.equals("Dashboard")) {
			System.out.println("Expected Dashboard text is showing");
		} else {
			System.out.println("Expected Dashbaord text is not showing");
		}
		driver.findElement(logoutButton).click();
  }  
  @AfterTest
  public void loginWithInValidCredentails() {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys("ss4yuvan@gmail.com");

		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys("sruthi1234");

		driver.findElement(loginButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		WebElement errorMessage = driver.findElement(invalidCredentialsError);
		String errorText = errorMessage.getText();
		System.out.println("Error Message is: " + errorText);
		if (errorText.contains("*Invalid credentials")) {
			System.out.println("Expected Error Message is showing");
		} else {
			System.out.println("Expected Error Message is not showing");
		}

  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}
  /*
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }
*/

