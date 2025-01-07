package Trello;

/* *
 I have developed automation code on March 24th
 * */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginV2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.trello.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); 
		
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@title='Custom image'])[4]")));
		driver.findElement(By.xpath("(//*[@title='Custom image'])[4]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='hpTkUr3Giu3mxV'])[3]")));
		driver.findElement(By.xpath("(//*[@class='hpTkUr3Giu3mxV'])[3]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='create-board-title-input']")));
		driver.findElement(By.xpath("//*[@data-testid='create-board-title-input']")).click();
		driver.findElement(By.xpath("//*[@data-testid='create-board-title-input']")).sendKeys("sssa");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='create-board-submit-button']")));
		driver.findElement(By.xpath("//*[@data-testid='create-board-submit-button']")).click();
	
	//	driver.close();
	}


}
