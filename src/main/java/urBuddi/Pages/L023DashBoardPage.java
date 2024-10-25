package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L023DashBoardPage {

	static WebDriver driver;
	static WebDriverWait wait;
	String empIDInput;

	public L023DashBoardPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
	}

	// DashBoardPage Locators
	By employeesLink = By.xpath("//*[text()='Employees']");

	public void clickOnEmployeesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(employeesLink));
		driver.findElement(employeesLink).click();

	}

}
