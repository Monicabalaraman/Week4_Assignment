package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.BaseNumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationUsingActionsClassInSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"))).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String items = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Number of Sports shoes :" +items);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//span[@class='arrow hidden']/parent::li")).click();
		String lowest = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		System.out.println("Lowest price is :" +lowest);
		String replaceAll3 = lowest.replaceAll("Rs. ", "");
		int low = Integer.parseInt(replaceAll3);
		
		
		
		List<Integer> cost=new ArrayList<Integer>();
		Thread.sleep(3000);
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	System.out.println("Price of all the products");
	for (WebElement i : price) {
		System.out.println(i.getText());
	}
		for (WebElement i : price) {
			
			String text = i.getText();
			
			String replaceAll = text.replaceAll("Rs. ", "");
			String replaceAll2 = replaceAll.replaceAll(",", "");
			
			int parseInt = Integer.parseInt(replaceAll2);
			cost.add(parseInt);
		}
		Collections.sort(cost);
		Integer least = cost.get(0);
	
		
		if (least.equals(low)) {
			System.out.println("Sorting verified");
		} else {
System.out.println("Sorting error");
		}
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("500");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("700");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
//driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[2]")).click();
		Thread.sleep(3000);
List<WebElement> filteredprice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
for (WebElement j : filteredprice) {
	String text = j.getText();
	String rep = text.replaceAll("Rs. ", "");
	int int1 = Integer.parseInt(rep);
	if ((int1>500)&&(int1<700)) {
		System.out.println("Cost of the shoes is within the price range");
	} else {
System.out.println("Price Range filter is not working properly");
	}
	
}
boolean colour = driver.findElement(By.xpath("//input[@class='filter-value visible-filter']")).isSelected();
if (colour) {
	System.out.println("Colour filter is verified");
} else {
System.out.println("Colour filter is unverified");
}
WebElement move = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
Actions act1=new Actions(driver);
act1.moveToElement(move).perform();
driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
Thread.sleep(2000);
String rate= driver.findElement(By.className("payBlkBig")).getText();
//String spcl = rate.replaceAll("[^0-9]", "");
String off = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
System.out.println("Price and discount percentage of the product are : " +rate +"& " +off);
WebElement snap = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
File scr=snap.getScreenshotAs(OutputType.FILE);
File des=new File("./Emp/shoes.jpg");
FileUtils.copyFile(scr, des);
Thread.sleep(2000);
driver.quit();
	}

}




//Precondition:
//- Initialize ChromeDriver
//- Load the URL (https://www.snapdeal.com/)
//- Maximize the browser window
//- Add an implicit wait to ensure the webpage elements are fully loaded
//Requirements:
//1. Launch (https://www.snapdeal.com/)
//2. Go to "Men's Fashion".
//3. Go to "Sports Shoes".
//4. Get the count of sports shoes.
//5. Click on "Training Shoes".
//6. Sort the products by "Low to High".
//7. Check if the displayed items are sorted correctly.
//8. Select any price range ex:(500-700).
//9. Filter by any colour.
//10. Verify all the applied filters.
//11. Mouse hover on the first resulting "Training Shoes".
//12. Click the "Quick View" button.
//13. Print the cost and the discount percentage.
//14. Take a snapshot of the shoes.
//15. Close the current window.
//16. Close the main window.