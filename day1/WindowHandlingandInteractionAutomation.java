package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingandInteractionAutomation {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		driver.switchTo().window(window.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windows=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(win.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(10000);
		String title = driver.getTitle();
		if (title.contains("Merge Contacts")) {
			System.out.println("Title verified");
		} else {
System.out.println("unverified title");
		}
	}

}




//- Initialize ChromeDriver
//- Load the URL (http://leaftaps.com/opentaps/control/login)
//- Maximize the browser window
//- Add an implicit wait to ensure the webpage elements are fully loaded
//Requirements:
//- Enter the username and password.
//- Click on the Login button.
//- Click on the CRM/SFA link.
//- Click on the Contacts button.
//- Click on Merge Contacts.
//- Click on the widget of the "From Contact".
//- Click on the first resulting contact.
//- Click on the widget of the "To Contact".
//- Click on the second resulting contact.
//- Click on the Merge button.
//- Accept the alert.
//- Verify the title of the page.