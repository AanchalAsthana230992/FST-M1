package activities;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class TestActivity5 {
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
		/*String homeMenuColor = driver.findElement(By.xpath("//html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/nav"))
		.getCssValue("color");
		String colorName = Color.fromString(homeMenuColor).asHex();
		System.out.println("Menu color of Home page is : "+ colorName);
		driver.quit();
*/
WebElement navMenu = driver.findElement(By.cssSelector("nav")); // update locator if needed

/*String color = navMenu.getCssValue("background-color");

System.out.println("Navigation menu color: " + color);

driver.quit();
*/


String rgba = navMenu.getCssValue("background-color");
String hex = Color.fromString(rgba).asHex();

System.out.println("Navigation menu color: " + hex);

driver.quit();


}}
