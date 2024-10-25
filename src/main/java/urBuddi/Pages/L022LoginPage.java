package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import urBuddi.CommonMethods;

public class L022LoginPage {
	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;

	public L022LoginPage(WebDriverWait w, WebDriver d) {
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

	public void loginToApplication(String userName, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void verifyLoginIsSuccessful() throws InterruptedException {
		Thread.sleep(5000);
		Boolean profileIconDisplayed = cm.isElementDisplayed(profileIcon);
		System.out.println("Profile Icon Displayed?==" + profileIconDisplayed);
		Assert.assertTrue(profileIconDisplayed, "Login is failed");

	}

}
