package activities;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestActivity6 {
	public WebDriver driver;

	@Test
	public void login() {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://crm.alchemy.hguy.co");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.id("login-button")).click();
		WebElement found = driver.findElement(By.xpath("/html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/nav/div[1]/ul/li[4]/scrm-menu-item/scrm-base-menu-item/div"));
	
		assertEquals(found.isDisplayed(), true);
		driver.quit();
		}
}
