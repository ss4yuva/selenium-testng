package urBuddi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class DeleteAddEmployeeAfterEditPage {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;
	int employeeIDRadomNumber;
	public String empIDInput;

	public DeleteAddEmployeeAfterEditPage(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Delete Employee After Searching with edit First and Last Name
	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By deleteIcon = By.xpath("//*[@class='deleteIcon']");
	By employeeIDSearchField = By.xpath("//*[@aria-label='EMP ID Filter Input']");

	public void deleteEditEmployeeWithSearchedFirstAndLastName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox));
		wait.until(ExpectedConditions.elementToBeClickable(employeeIDCheckBox));
		driver.findElement(employeeIDCheckBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
		driver.findElement(deleteIcon).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteIcon));
	}

	public void verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(String empID) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteIcon));

		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		wait.until(ExpectedConditions.elementToBeClickable(employeeIDSearchField));

		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeSearchIDValue));

		Boolean eemployeeRecordIsPresent = cm.isElementDisplayed(employeeSearchIDValue);
		System.out.println("Employee Record Deleted After Edit Successful?==" + eemployeeRecordIsPresent);
		Assert.assertTrue(eemployeeRecordIsPresent, "Employee Record is not deleted");
	}
}
