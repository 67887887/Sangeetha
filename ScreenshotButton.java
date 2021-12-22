package week4.weekdayassignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotButton {public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.get("http://leafground.com/pages/frame.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	driver.findElement(By.id("Click")).click();
	//Getting the Screenshot
	File source=driver.getScreenshotAs(OutputType.FILE);
	File destination=new File("./Frames.png");
	FileUtils.copyFile(source, destination);
	driver.switchTo().defaultContent();
	driver.navigate().to("http://leafground.com/pages/frame.html");
	List<WebElement> framesize=driver.findElements(By.tagName("iframe"));
	System.out.println("The total no Frames in page:"+framesize.size());

}
}