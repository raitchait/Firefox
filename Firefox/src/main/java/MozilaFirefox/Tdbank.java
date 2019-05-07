package MozilaFirefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tdbank {

    public static String SOS = null;
    public static WebDriver driver = null;

    public static WebDriver getDriver(String platform, String url, String browser) {
        if (platform.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\RACHID\\Firefox\\src\\Drivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\RACHID\\Firefox\\src\\Drivers\\geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.td.com");

        return driver;

    }
    @Test
    public static void Tdnak() {
        getDriver("windows", "https://www.td.com", "Firefox");

        driver.findElement(By.xpath("//*[@Class='td-button td-button-secondary td-button-large td-copy-nowrap loginout']")).click();

        driver.findElement(By.xpath("//*[@id='formElement_1']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='formElement_2']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@Class='pull-right ng-binding ng-isolate-scope td-margin-0 td-button td-button-primary td-button-compact']")).click();

        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}