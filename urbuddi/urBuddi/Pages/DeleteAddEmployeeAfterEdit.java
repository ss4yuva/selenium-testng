package urBuddi.Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.CommonMethods;

public class DeleteAddEmployeeAfterEdit {

	static WebDriver driver;
	static WebDriverWait wait;
	CommonMethods cm;
	int employeeIDRadomNumber;
	public String empIDInput;

	public DeleteAddEmployeeAfterEdit(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
		cm = new CommonMethods(wait, driver);
	}

	// Delete Employee After Searching with edit First and Last Name
	By employeeIDCheckBox = By.xpath("//*[@class='ag-selection-checkbox']");
	By deleteIcon = By.xpath("//*[@class='deleteIcon']");
	By employeeIDSearchField = By.xpath("//*[@aria-label='EMP ID Filter Input']");

	public void deleteEditEmployeeWithSearchedFirstAndLastName() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCheckBox));
		driver.findElement(employeeIDCheckBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
		driver.findElement(deleteIcon).click();
		Thread.sleep(1500);
	}

	public void verifyNewlyAddedEmployeeDelettionIsSuccessfulWithEmpID(String empID) throws InterruptedException {
		Thread.sleep(5000);
		By employeeSearchIDValue = By.xpath("//*[text()='" + empID + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDSearchField));
		driver.findElement(employeeIDSearchField).click();
		driver.findElement(employeeIDSearchField).sendKeys(empID);
		Thread.sleep(2000);
		Boolean eemployeeRecordIsPresent = cm.isElementDisplayed(employeeSearchIDValue);
		System.out.println("Employee Record Deleted Successful?==" + eemployeeRecordIsPresent);
		Assert.assertTrue(eemployeeRecordIsPresent, "Employee Record is not deleted");
	}

}
