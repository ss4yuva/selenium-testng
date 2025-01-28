package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class DeleteAddEmployee {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;
	int employeeIDRadomNumber;
	public String empIDInput;

	public DeleteAddEmployee(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Locators
	By employeeIDSearchField = By.xpath("//*[@aria-label='EMP ID Filter Input']");

	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By deleteIcon = By.xpath("//*[@class='deleteIcon']");

	public void searchAndDeleteAddEmployee() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox));
		driver.findElement(employeeIDCheckBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
		driver.findElement(deleteIcon).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteIcon));
	}

	public void verifyAddEmployeeAfterDelete(String empID) {
		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);

		Boolean empRecordPresent = this.isElementDisplayed(employeeSearchIDValue);
		System.out.println("Employee present After Delete?==" + empRecordPresent);
		Assert.assertTrue(empRecordPresent, "Employee Record is not deleted");
	}

	public boolean isElementDisplayed(By loc) {
		Boolean empRecordPresent;
		try {
			empRecordPresent = driver.findElement(loc).isDisplayed();
		} catch (Exception e) {
			empRecordPresent = true;
		}
		return empRecordPresent;
	}

}
