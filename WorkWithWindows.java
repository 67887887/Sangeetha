package week4.weekdayassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("home")).click();
		Set<String> windowsHandle=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowsHandle);
		driver.switchTo().window(handles.get(1));
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		driver.switchTo().window(handles.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		 String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowsMultipleHandle=driver.getWindowHandles();
		
		java.util.Iterator<String> multipleWindows=windowsMultipleHandle.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (multipleWindows.hasNext()) {
            String ChildWindow = multipleWindows.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }	
		
		
		
        }
	}
		
		
		

	}

