package testPack;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program3 {

    WebDriver driver;

    @BeforeSuite
    public void suiteMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRIDUL\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    }

    @BeforeClass
    public void bcMethod() {
        driver = new ChromeDriver();
    }

    @BeforeMethod //Is triggered before any @test method gets executed
    public void bmMethod() throws InterruptedException {
    	driver.manage().window().maximize();
    	driver.get("https://www.linkedin.com");
    	Thread.sleep(3000);
    }


    @Test //******************THIS TESTCASE IS FAILED ON PURPOSE TO SHOW PASSES/FAILS IN HTML REPORTS*************************
    public void verifyTrendingButtonVisibility() {
        driver.get("https://www.linkedin.com");
        WebElement articlesButton = driver.findElement(By.xpath("//a[contains(text(), 'abcd')]"));
        Assert.assertTrue(articlesButton.isDisplayed(), "articles button is not displayed on the LinkedIn login page.");
    }

    @AfterMethod //Is triggered once after every @Test method is completed
    public void tearDown() {
    	
            driver.quit(); //quits the browser
    }

    }

