package week4.weekdayassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert confirmBox = driver.switchTo().alert();
		confirmBox.accept();
		String confirmText = driver.findElement(By.id("result")).getText();
		System.out.println(confirmText);
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert promptALert = driver.switchTo().alert();
		promptALert.sendKeys("Lakshanaa");
		promptALert.accept();
		String confirmPromptText = driver.findElement(By.id("result1")).getText();
		System.out.println(confirmPromptText);
		Thread.sleep(2000);
		
		alert.accept();
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
