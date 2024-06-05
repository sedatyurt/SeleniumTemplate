package basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver webDriver;
    protected final String URL = "https://www.google.com/";

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        webDriver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }

    public void threadSleep(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }   catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}