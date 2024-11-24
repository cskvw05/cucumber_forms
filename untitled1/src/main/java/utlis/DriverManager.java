package utlis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Initialize WebDriver instance
    public static synchronized void setDriver() {

        if (driverThreadLocal.get() == null) {
            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driverThreadLocal.set(driver);

            // Common WebDriver configurations
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

    }


    /**
     * Get the WebDriver instance for the current thread.
     *
     * @return WebDriver instance
     */
    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Quit the WebDriver instance for the current thread.
     */
    public static synchronized void quitDriver() {
        if(driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }

    }

}

