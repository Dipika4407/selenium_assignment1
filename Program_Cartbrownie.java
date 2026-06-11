package seleniumassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program_Cartbrownie {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://files.wiseapp.live/upload_files/6932afb3c05630afe5a997f1/upload_e8b6df31-b24c-452b-9cf7-44ccd9eed91d.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("foodHeading")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));

		System.out.println("Menu item is visible");

		WebElement category = driver.findElement(
		        By.xpath("//button[contains(text(),'Dessert')]"));
		category.click();

		WebElement cart = driver.findElement(
		        By.xpath("(//button[contains(text(),'Add to Cart')])[2]"));
		cart.click();

		wait.until(ExpectedConditions.textToBePresentInElementLocated(
		        By.id("cartCount"), "1"));
		
		WebElement cartConfirm = driver.findElement(By.id("confirmOrderBtn"));
		cartConfirm.click();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your order has been placed successfully.')]")));

		WebElement close = driver.findElement(By.id("closePopupBtn"));
		close.click();
		
		

	}

}
