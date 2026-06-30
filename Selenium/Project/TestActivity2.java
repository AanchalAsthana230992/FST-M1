package activities;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestActivity2 {
public WebDriver driver;

@Test
public void verifyHeader() {
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://crm.alchemy.hguy.co");
	
	String Imageurl = driver.findElement(By.xpath("//div/scrm-login-ui/div/form/div[1]/div/scrm-logo-ui/scrm-image/img"))
			.getAttribute("src");
		System.out.println("Image Url :"+ Imageurl);	
		driver.close();
}}
