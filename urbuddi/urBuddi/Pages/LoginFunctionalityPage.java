package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class LoginFunctionalityPage {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;

	public LoginFunctionalityPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Locators
	By companyLogo = By.xpath("//*[@class='company-logo']");

	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By dashboard = By.xpath("(//*[text()='Dashboard'])[2]");

	By lagoutButton = By.xpath("//*[@class='logout-btn-nav']");
	By logoutPopupYes = By.xpath("//*[text()='Yes']");

	By emailError = By.xpath("(//*[text()='*required'])[1]");
	By passwordError = By.xpath("(//*[text()='*required'])[2]");

	By invalidCredentialsError = By.xpath("//*[@class='err-msg-display mt-3']");

	By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");

	By forgotPasswordHeaderText = By.xpath("//*[text()='Forgot Password']");

	public void verifyUrBuddiLoginPage() {
		String url = driver.getCurrentUrl();
		System.out.println("URL: " + url);

		Boolean companyLogoDisplayed = cm.isElementDisplayed(companyLogo);
		System.out.println("Company Logo is Displayed?==" + companyLogoDisplayed);
		Assert.assertTrue(companyLogoDisplayed, "Company Logo is Not Displayed");
	}

	public void loginWithValidCredentials(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void verifyLoginPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		Boolean dashBoardTextDisplayed = cm.isElementDisplayed(dashboard);
		System.out.println("DashBoard Text is Displayed?==" + dashBoardTextDisplayed);
		Assert.assertTrue(dashBoardTextDisplayed, "DashBoard Text is Not Displayed");
	}

	public void clickOnLogout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lagoutButton));
		driver.findElement(lagoutButton).click();
		driver.findElement(logoutPopupYes).click();
	}

	public void loginWithBlankCredentials() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
	}

	public void verifyErrorMessageLoginWithBlankCredentials() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
		Boolean emailErrorDisplayed = cm.isElementDisplayed(emailError);
		System.out.println("Email Error is Displayed?==" + emailErrorDisplayed);
		Assert.assertTrue(emailErrorDisplayed, "Email Error is Not Displayed");

		Boolean passwordErrorDisplayed = cm.isElementDisplayed(passwordError);
		System.out.println("Password Error is Displayed?==" + passwordErrorDisplayed);
		Assert.assertTrue(passwordErrorDisplayed, "Password Error is Not Displayed");
	}

	public void loginWithInValidCredentails(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).sendKeys(userName);

		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).sendKeys(password);

		driver.findElement(loginButton).click();
	}

	public void verifyErrorMessageLoginWithInvalidCredentials() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		Boolean invalidCredentialsErrorDisplayed = cm.isElementDisplayed(invalidCredentialsError);
		System.out.println("Invalid Credentails Error is Displayed?==" + invalidCredentialsErrorDisplayed);
		Assert.assertTrue(invalidCredentialsErrorDisplayed, "Invalid Credentials Error is Not Displayed");
	}

	public void loginWithValidEmailAndInValidPassword(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void verifyErrorMessageLoginWithValidEmailAndInValidPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		Boolean invalidCredentialsErrorDisplayed = cm.isElementDisplayed(invalidCredentialsError);
		System.out.println("Invalid Credentails Error is Displayed?==" + invalidCredentialsErrorDisplayed);
		Assert.assertTrue(invalidCredentialsErrorDisplayed, "Invalid Credentials Error is Not Displayed");
	}

	public void loginWithInValidEmailAndValidPassword(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputfield));
		wait.until(ExpectedConditions.elementToBeClickable(emailInputfield));
		driver.findElement(emailInputfield).click();
		driver.findElement(emailInputfield).clear();
		driver.findElement(emailInputfield).sendKeys(userName);
		driver.findElement(passwordInputfield).click();
		driver.findElement(passwordInputfield).clear();
		driver.findElement(passwordInputfield).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void verifyErrorMessageLoginWithInValidEmailAndValidPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsError));
		Boolean invalidCredentialsErrorDisplayed = cm.isElementDisplayed(invalidCredentialsError);
		System.out.println("Invalid Credentails Error is Displayed?==" + invalidCredentialsErrorDisplayed);
		Assert.assertTrue(invalidCredentialsErrorDisplayed, "Invalid Credentials Error is Not Displayed");
	}

	public void clickOnForgotPasswordLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
		wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
		driver.findElement(forgotPasswordLink).click();
	}

	public void verifyForgotPasswordPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordHeaderText));
		Boolean forgotPasswordHeaderTextDisplayed = cm.isElementDisplayed(forgotPasswordHeaderText);
		System.out.println("Forgot Password Header Text is Displayed?==" + forgotPasswordHeaderTextDisplayed);
		Assert.assertTrue(forgotPasswordHeaderTextDisplayed, "Forgot Password Header Text is Not Displayed");
	}
}