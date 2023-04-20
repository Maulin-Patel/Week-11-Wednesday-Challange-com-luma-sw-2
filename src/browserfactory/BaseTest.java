package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver; // Reference variable driver which is of Web element type

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver(); // Assign driver variable to object of Chrome browser class
        driver.get(baseUrl);// Open url depending on baseUrl value
        driver.manage().window().maximize(); // Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Providing implicit wait
    }

    public void closeBrowser() {
        driver.quit(); // quits all browser windows opened by Selenium
    }
}
