package Trello;

/* *
I have developed automation code on March 25th
* */

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginV3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.trello.com");
		
		Random random = new Random();
		int x = random.nextInt(1000);
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));
		driver.findElement(By.linkText("Log in")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));	
		driver.findElement(By.id("username")).sendKeys("ss4yuvan@gmail.com");
		
		driver.findElement(By.cssSelector("#login-submit")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		driver.findElement(By.cssSelector("#password")).sendKeys("Orbita@11");
		
		driver.findElement(By.cssSelector("#login-submit")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='header-create-menu-button']")));
		driver.findElement(By.xpath("//*[@data-testid='header-create-menu-button']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='header-create-board-button']")));
		driver.findElement(By.xpath("//*[@data-testid='header-create-board-button']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@title='Custom image'])")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@title='Custom image'])")));
		List<WebElement> images = driver.findElements(By.xpath("(//*[@title='Custom image'])"));
		int allImages = images.size();
		int randomImage = random.nextInt(allImages);
		images.get(randomImage).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='hpTkUr3Giu3mxV'])")));
        List<WebElement> colors = driver.findElements(By.xpath("(//*[@class='hpTkUr3Giu3mxV'])"));
        int allColors = colors.size();
        int randomColors = random.nextInt(allColors);
        colors.get(randomColors).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='create-board-title-input']")));
		driver.findElement(By.xpath("//*[@data-testid='create-board-title-input']")).click();
		driver.findElement(By.xpath("//*[@data-testid='create-board-title-input']")).sendKeys("ss"+x);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='create-board-submit-button']")));
		driver.findElement(By.xpath("//*[@data-testid='create-board-submit-button']")).click();
		
		for(int i=1;i<=3;i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Enter list title…")));
			driver.findElement(By.name("Enter list title…")).sendKeys("To_Do");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='list-composer-add-list-button']")));
			driver.findElement(By.xpath("//*[@data-testid='list-composer-add-list-button']")).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='list-add-card-button']")));
		driver.findElement(By.xpath("//*[@data-testid='list-add-card-button']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='list-card-composer-textarea']")));
		driver.findElement(By.xpath("//*[@data-testid='list-card-composer-textarea']")).sendKeys("Hi");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='list-card-composer-add-card-button']")));
		driver.findElement(By.xpath("//*[@data-testid='list-card-composer-add-card-button']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='CloseIcon']")));
		driver.findElement(By.xpath("//*[@data-testid='CloseIcon']")).click();
//	driver.close();
	}

}
