package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestActivities7 {

    @Test
    public void readLeadPopupDetails() throws Exception {

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

        // Wait for page to load
        Thread.sleep(5000);

        // Wait for overlay to disappear
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.className("app-overlay")));
        } catch (Exception e) {
            System.out.println("Overlay not present");
        }

        // Click Leads using JavaScript
        WebElement leads = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.linkText("Leads")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", leads);

        // Wait for Leads page
        Thread.sleep(3000);

        // Click first 3-dot icon
        WebElement threeDots = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//scrm-record-details-popup-button//button)[1]")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", threeDots);

        // Wait for popup
        Thread.sleep(2000);

        // Read popup text
        WebElement popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ngb-popover-window")));

        System.out.println("================================");
        System.out.println("POPUP DETAILS");
        System.out.println("================================");
        System.out.println(popup.getText());

        // Print email if found
        try {
            String email = popup.findElement(
                    By.xpath(".//a[contains(text(),'@')]"))
                    .getText();

            System.out.println("Email Found : " + email);
        } catch (Exception e) {
            System.out.println("Email not found in popup");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}