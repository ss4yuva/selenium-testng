package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

	static WebDriver driver;
	static WebDriverWait wait;
	String empIDInput;

	public DashBoardPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
	}

	// DashBoardPage Locators
	By employeesLink = By.xpath("//*[text()='Employees']");
	By addEmployeeButton = By.xpath("//*[text()='Add Employee']");

	public void clickOnEmployeesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(employeesLink));
		driver.findElement(employeesLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
		driver.findElement(addEmployeeButton).click();
	}

}
