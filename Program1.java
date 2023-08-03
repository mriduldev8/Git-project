package testPack;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program1 {

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
    	driver.get("https://www.google.com");
    	Thread.sleep(3000);
    }


    @Test
    public void verifySignInLink() {
        driver.get("https://www.google.com");
        WebElement signInBtn = driver.findElement(By.xpath("//a[@class='gb_ta gb_qd gb_Sd gb_qe']")); 
        Assert.assertTrue(signInBtn.isDisplayed(), "Sign in btn displayed.");
    }

    @AfterMethod //Is triggered once after every @Test method is completed
    public void tearDown() {
    	
            driver.quit(); //quits the browser
    }

    }

