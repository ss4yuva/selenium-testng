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
	By employeeIDSearchField = By.xpath("(//*[@class='ag-input-field-input ag-text-field-input'])[1]");

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
		wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteIcon));

		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		wait.until(ExpectedConditions.elementToBeClickable(employeeIDSearchField));

		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);

		Boolean empRecordPresent = cm.isElementDeleted(employeeSearchIDValue);
		System.out.println("Employee present After Delete?==" + empRecordPresent);
		Assert.assertTrue(empRecordPresent, "Employee Record is not deleted");
	}

}
