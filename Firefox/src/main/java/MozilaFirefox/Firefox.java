package MozilaFirefox;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Firefox {

    public static String SOS = null;
    public static WebDriver driver = null;

    public static WebDriver getDriver(String platform, String url,String browser) {
        if (platform.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\RACHID\\Firefox\\src\\Drivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\RACHID\\Firefox\\src\\Drivers\\geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://signin.ebay.com");

        return driver;
    }
    @AfterTest
    public void  quitDriver(){

        try {
            Thread.sleep(9000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
@Test
    public static void ebaylogin() {
       getDriver("windows","https://signin.ebay.com","Firefox");
        //driver.findElement(By.xpath("//*[@ Class='gLFyf gsfi']")).sendKeys("facebook");
        driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("username");

        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("passwoord");

         driver.findElement(By.xpath("//*[@id='sgnBt']")).click();

         try {
            Thread.sleep(9000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
    @Test
public static void creatacount(){
    getDriver("windows","https://signin.ebay.com","Firefox");

    driver.findElement(By.linkText("create an account")).click();

        try {
            Thread.sleep(8000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



}

}





