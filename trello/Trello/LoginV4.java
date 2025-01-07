package Trello;

/* *
I have developed automation code on March 26th
* */

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginV4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.trello.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		Random random = new Random();
		int x = random.nextInt(1000);
				
		By LoginButton = By.linkText("Log in");
		By UserNameField = By.id("username");
		By UserNameSubmit = By.cssSelector("#login-submit");
		By PasswordField = By.cssSelector("#password");
		By Submit = By.cssSelector("#login-submit");
		By CreateButton = By.xpath("//*[@data-testid='header-create-menu-button']");
		By CreateBoardButton = By.xpath("//*[@data-testid='header-create-board-button']");
		By ImageLink = By.xpath("(//*[@title='Custom image'])");
		By ColorLink = By.xpath("(//*[@class='hpTkUr3Giu3mxV'])");
		By BoardTitleInputField = By.xpath("//*[@data-testid='create-board-title-input']");
		By CreateSubmitButton = By.xpath("//*[@data-testid='create-board-submit-button']");
		By EnterTitleName = By.name("Enter list title…");
		By AddTitleName = By.xpath("//*[@data-testid='list-composer-add-list-button']");
		By AddCardInputLink = By.xpath("//*[@data-testid='list-add-card-button']");
		By AddCardInputField = By.xpath("//*[@data-testid='list-card-composer-textarea']");
		By AddCardButton = By.xpath("//*[@data-testid='list-card-composer-add-card-button']");
		WebElement TicketDrag = driver.findElement(By.xpath("//*[@data-testid='list-card']"));
		WebElement TicketDrop = driver.findElement(By.xpath("(//*[@data-testid='list-cards'])[2]"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
		driver.findElement(LoginButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameField));	
		driver.findElement(UserNameField).sendKeys("ss4yuvan@gmail.com");
		
		driver.findElement(UserNameSubmit).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
		driver.findElement(PasswordField).sendKeys("Orbita@11");
		
		driver.findElement(Submit).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CreateButton));
		driver.findElement(CreateButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CreateBoardButton));
		driver.findElement(CreateBoardButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ImageLink));
		wait.until(ExpectedConditions.elementToBeClickable(ImageLink));
		List<WebElement> images = driver.findElements(ImageLink);
		int allImages = images.size();
		int randomImage = random.nextInt(allImages);
		images.get(randomImage).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ColorLink));
        List<WebElement> colors = driver.findElements(ColorLink);
        int allColors = colors.size();
        int randomColors = random.nextInt(allColors);
        colors.get(randomColors).click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(BoardTitleInputField));
		driver.findElement(BoardTitleInputField).click();
		driver.findElement(BoardTitleInputField).sendKeys("ss"+x);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(CreateSubmitButton));
		driver.findElement(CreateSubmitButton).click();
		

		for(int i=1;i<=3;i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(EnterTitleName));
			driver.findElement(EnterTitleName).sendKeys("To_Do");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddTitleName));
			driver.findElement(AddTitleName).click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCardInputLink));
		driver.findElement(AddCardInputLink).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCardInputField));
		driver.findElement(AddCardInputField).sendKeys("Hi");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddCardButton));
		driver.findElement(AddCardButton).click();
		
		Actions act = new Actions(driver);
		act.dragAndDrop(TicketDrag, TicketDrop).perform();
		
		
		
	}

}
