package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class VerificationOfLoginPage {

	static WebDriver driver;
	static WebDriverWait wait;
	static ChromeDriver chrome;
	CommonMethods cm;

	public VerificationOfLoginPage(WebDriverWait w, WebDriver d, ChromeDriver c) {
		this.driver = d;
		this.wait = w;
		this.chrome = c;
		cm = new CommonMethods(wait, driver);
	}

	// Locators
	By companyLogo = By.xpath("//*[@class='company-logo']");
	By headerText = By.xpath("//*[@class='welcomeMessage']");
	By subText = By.xpath("//*[@class='subtext']");
	By emailInputfield = By.id("userEmail");
	By passwordInputfield = By.id("userPassword");
	By loginButton = By.xpath("//*[@type='submit']");
	By forgotPasswordLink = By.xpath("//*[@class='forgot-pswd']");

	public void verifyUrBuddiLogo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogo));
		Boolean urBuddiLogoDisplayed = cm.isElementDisplayed(companyLogo);
		System.out.println("UrBuddi Logo is Displayed?==" + urBuddiLogoDisplayed);
		Assert.assertTrue(urBuddiLogoDisplayed, "UrBuddi Logo is Not Displayed");
	}

	public void verifyHeaderTextWelcomeToUrBuddi() {
		Boolean headerTextDisplayed = cm.isElementDisplayed(headerText);
		System.out.println("Header Text is Displayed?==" + headerTextDisplayed);
		Assert.assertTrue(headerTextDisplayed, "Header Text is Not Displayed");
	}

	public void verifySubtext() {
		Boolean subTextDisplayed = cm.isElementDisplayed(subText);
		System.out.println("Sub Text is Displayed?==" + subTextDisplayed);
		Assert.assertTrue(subTextDisplayed, "Sub Text is Not Displayed");
	}

	public void verifyEmailInputField() {
		Boolean emailInputFieldDisplayed = cm.isElementDisplayed(emailInputfield);
		System.out.println("Email InputField is Displayed?==" + emailInputFieldDisplayed);
		Assert.assertTrue(emailInputFieldDisplayed, "Email InputField is Not Displayed");
	}

	public void verifyPasswordInputField() {
		Boolean passwordInputFieldDisplayed = cm.isElementDisplayed(passwordInputfield);
		System.out.println("Password InputField is Displayed?==" + passwordInputFieldDisplayed);
		Assert.assertTrue(passwordInputFieldDisplayed, "Password InputField is Not Displayed");
	}

	public void verifyLoginButton() {
		Boolean loginButtonDisplayed = cm.isElementDisplayed(loginButton);
		System.out.println("Login button is Displayed?==" + loginButtonDisplayed);
		Assert.assertTrue(loginButtonDisplayed, "Login Button is Not Displayed");
	}

	public void verifyForgotPasswordLink() {
		Boolean forgotPasswordLinkDisplayed = cm.isElementDisplayed(forgotPasswordLink);
		System.out.println("Forgot Password Link is Displayed?==" + forgotPasswordLinkDisplayed);
		Assert.assertTrue(forgotPasswordLinkDisplayed, "Forgot Password Link is Not Displayed");
	}
}
