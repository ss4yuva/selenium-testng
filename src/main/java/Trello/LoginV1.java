package Trello;

/*
 * I have developed automation code on March 24th
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginV1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Sruthi\\Automation Practice\\Files\\Drivers\\chromedriver-win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.trello.com");
		
		Thread.sleep(200);
		driver.findElement(By.linkText("Log in")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("ss4yuvan@gmail.com");
		
		driver.findElement(By.cssSelector("#login-submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#password")).sendKeys("Orbita@11");
		
		driver.findElement(By.cssSelector("#login-submit")).click();
		
		driver.close();
	}


}
