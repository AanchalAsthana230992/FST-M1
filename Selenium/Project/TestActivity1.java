package activities;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestActivity1 {

	public static WebDriver driver;
	
	@Test
	public void crmTitle1Verify() {
		
		driver=new ChromeDriver();
		driver.get("https://crm.alchemy.hguy.co");
		driver.manage().window().maximize();
		String pagetitle=driver.getTitle();
		assertEquals(pagetitle, "SuiteCRM");
		driver.close();
		
	}
		
	}

