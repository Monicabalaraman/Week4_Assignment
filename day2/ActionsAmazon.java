package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of the first displayed item :" +price);
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Number of customer rating for the first product :" +rating);
		
		
		
		
		
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
        WebElement dr = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
        File source=dr.getScreenshotAs(OutputType.FILE);
        File target=new File("./Emp/phone1.png");
        FileUtils.copyFile(source, target);
        //WebElement mte = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base']/following-sibling::i"));
        Actions act=new Actions(driver);
		
        act.doubleClick(driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"))).perform();
		
		Thread.sleep(3000);
		String carttotal = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		
        System.out.println("The sub carttotal is :" +carttotal);
        if (carttotal.contains(price)) {
			System.out.println("Price is verified");
		} else {
System.out.println("Price mismatch");
		}
        driver.quit();
        
	}

}






//Precondition:
//- Initialize ChromeDriver
//- Load the URL (https://www.amazon.in/)
//- Maximize the browser window
//- Add an implicit wait to ensure the webpage elements are fully loaded
//Requirements:
//1. Load the URL (https://www.amazon.in/)
//2. Search for "oneplus 9 pro".
//3. Get the price of the first product.
//4. Print the number of customer ratings for the first displayed product.
//5. Click the first text link of the first image.
//6. Take a screenshot of the product displayed.
//7. Click the 'Add to Cart' button.
//8. Get the cart subtotal and verify if it is correct.
//9. Close the browser.
//Hints to Solve:
//- Use Selenium's Actions class methods such as `moveToElement()`, ‘perform()’ and Selenium methods such as`click()`, 
//`sendKeys()`.
//- Utilize appropriate locators and techniques to interact with web elements.
//- Switch between windows using `getwindowHandles()` and switchTo().window().