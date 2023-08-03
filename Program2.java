package testPack;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program2 {

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
    	driver.get("https://www.youtube.com");
    	Thread.sleep(3000);
    }

    @Test
    public void testPageTitle() {
        driver.get("https://www.youtube.com");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "YouTube");
    } 


    @AfterMethod //Is triggered once after every @Test method is completed
    public void tearDown() {
    	
            driver.quit(); //quits the browser
    }

    }

