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

public class TestActivities8 {

    @Test
    public void printOddRows() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://crm.alchemy.hguy.co");

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")))
                .sendKeys("admin");

        driver.findElement(By.name("password"))
                .sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.id("login-button")).click();

        // Wait for dashboard
        Thread.sleep(5000);

        // Hover on Leads
        WebElement leads = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Leads")));

        Actions act = new Actions(driver);
        act.moveToElement(leads).perform();

        Thread.sleep(2000);

        // Click View Leads
        driver.findElement(
                By.xpath("//*[contains(text(),'View Leads')]"))
                .click();

        // Wait for table
        Thread.sleep(5000);

        // Get all rows
        List<WebElement> rows = driver.findElements(
                By.xpath("//tbody/tr"));

        System.out.println("Total Rows Found = " + rows.size());

        System.out.println("First 5 Odd Numbered Rows:");

        int count = 0;

        for (int i = 0; i < rows.size(); i += 2) {

            String rowText = rows.get(i).getText();

            System.out.println(rowText);

            count++;

            if (count == 5)
                break;
        }

        driver.quit();
    }
}