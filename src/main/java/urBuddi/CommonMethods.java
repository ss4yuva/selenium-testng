package urBuddi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	static WebDriver driver;
	static WebDriverWait wait;

	CommonMethods(WebDriverWait w, WebDriver d) {
		this.driver = d;
		this.wait = w;
	}

	public boolean isElementDisplayed(By loc) {
		Boolean empRecordPresent;
		try {
			empRecordPresent = driver.findElement(loc).isDisplayed();
		} catch (Exception e) {
			empRecordPresent = false;
		}
		return empRecordPresent;

	}

}
