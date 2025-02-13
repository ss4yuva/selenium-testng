package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class LoginPage {
	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods cm;

	public LoginPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Login Page Locators
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");

	// After Login Success
	By profileIcon = By.xpath("//*[@class='profile-icon-container']");

	// Logout
	By lagoutButton = By.xpath("//*[@class='logout-btn-nav']");
	By logoutPopupYes = By.xpath("//*[text()='Yes']");

	public void loginToApplication(String userName, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void emailInput(String userName) {
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
	}

	public void passwordInput(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordInputfield));
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
	}

	public void login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		driver.findElement(loginButton).click();
	}

	public void loginToApplicationInputs() {
		emailInput("suresh.salloju@openskale.com");

		passwordInput("New@2024");

		login();
	}

	public void verifyLoginIsSuccessful() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(profileIcon));
		Boolean profileIconDisplayed = cm.isElementDisplayed(profileIcon);
		System.out.println("Profile Icon Displayed?==" + profileIconDisplayed);
		Assert.assertTrue(profileIconDisplayed, "Login is failed");
	}

	public void logoutToApplication() {
		wait.until(ExpectedConditions.elementToBeClickable(lagoutButton));
		driver.findElement(lagoutButton).click();

		wait.until(ExpectedConditions.elementToBeClickable(logoutPopupYes));
		driver.findElement(logoutPopupYes).click();
	}

}
