package projectPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCode {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRIDUL\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // Close any popup or overlay that may appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText("Privacy Policy")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        
        // Click on Flights
        WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='menu_Flights']")));
        flightsTab.click();

        // Select ROUND TRIP
        WebElement roundTripOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='roundTrip']")));
        roundTripOption.click();

        // Enter From Location as HYD
        WebElement fromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));
        fromCityInput.click();
        Thread.sleep(1000);
        //fromCityInput.clear();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
        driver.findElement(By.xpath("//p[text()='Hyderabad, India']")).click();

        Thread.sleep(1000);
        // Enter To Location as MAA
        WebElement toCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='toCity']")));
        toCityInput.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MAA");
        driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();

        Thread.sleep(1000);

        // Select DEPARTURE Date
        driver.findElement(By.xpath("//span[text()='Departure']")).click();
        //Thread.sleep(1000);
        WebElement depDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label, 'Sun Aug 27 2023')]")));
        depDate.click();
        
        Thread.sleep(1000);

        // Select RETURN Date
        driver.findElement(By.xpath("//span[text()='Return']")).click();
        WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label, 'Thu Aug 31 2023')]")));
        returnDate.click();
        
        Thread.sleep(1000);

        // Click on Search Button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
        searchButton.click();
        
        Thread.sleep(18000);
        
        driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='splitVw']")));
            System.out.println("Flights are available on the search results page.");
        } catch (Exception e) {
            System.out.println("No flights found on the search results page.");
        }
        
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
