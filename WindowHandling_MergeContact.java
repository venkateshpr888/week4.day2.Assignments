package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling_MergeContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		String StartingPage = driver.getWindowHandle();
		System.out.println(StartingPage);
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);
		WebElement FirstResult = driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//div/a)[1]"));
		String Name = FirstResult.getText();
		System.out.println(Name);
		FirstResult.click();
		driver.switchTo().window(StartingPage);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		String secondWindow1 = list1.get(1);
		driver.switchTo().window(secondWindow1);
		WebElement SecondResult = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]"));
		String Name1 = SecondResult.getText();
		System.out.println(Name1);
		SecondResult.click();
		driver.switchTo().window(StartingPage);
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Both merged");
		//Thread.sleep(1000);
		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);

//		(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//div/a)[1]
//				(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]//a)[2]
	}

}
