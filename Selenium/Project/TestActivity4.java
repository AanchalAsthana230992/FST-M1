package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestActivity4 {
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
		@Nullable
		String Homepage = driver.getTitle();
		assertEquals(Homepage, "SuiteCRM");
		driver.quit();


	}

}
