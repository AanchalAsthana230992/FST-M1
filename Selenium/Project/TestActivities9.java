package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestActivities9 {

    @Test
    public void printNameAndUser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open CRM
        driver.get("https://crm.alchemy.hguy.co");

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='username']")))
                .sendKeys("admin");

        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000);

        // Hover over Leads
        WebElement leads = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Leads")));

        Actions actions = new Actions(driver);
        actions.moveToElement(leads).perform();

        Thread.sleep(2000);

        // Click View Leads
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'View Leads')]")))
                .click();

        // Wait for table
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tbody/tr")));

        List<WebElement> rows =
                driver.findElements(By.xpath("//tbody/tr"));

        System.out.println("Name\t\t\tUser");
        System.out.println("-----------------------------------");

        int limit = Math.min(10, rows.size());

        for (int i = 0; i < limit; i++) {

            List<WebElement> cols =
                    rows.get(i).findElements(By.tagName("td"));

            String name = cols.get(2).getText(); // Name column
            String user = cols.get(7).getText(); // User column

            System.out.println(name + "  -->  " + user);
        }

        driver.quit();
    }
}