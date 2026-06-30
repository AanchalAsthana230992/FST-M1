package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestActivity3 {
public WebDriver driver;

@Test
public void verifyHeader() {
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://crm.alchemy.hguy.co");
	
	String footerText = driver.findElement(By.xpath("(//scrm-footer-ui/div[1]/div[@class='copyright-links']/a)[1]")).getText();
	System.out.print(footerText);
	driver.quit();


}


}
