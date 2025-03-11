package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.CommonMethods;

public class LoginWithRoleAdminPage {
	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods cm;

	public LoginWithRoleAdminPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}
	
	//Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");

	public void loginToApplicationWithRoleAsAdmin(String userName, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public void verifyLoginWithAdminRole() {
		
	}
	
	
	
}
