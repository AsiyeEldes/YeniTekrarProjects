package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

        //Bu sinif sadece Driver objesi olusturmak icin acildi
        //(Singleton driver) demek sadece bir driver objesi olusturuyoruz.bir daha olusturmuyoruz
        //initialize the driver instance.

        //null oldugunda driver ini olustur diyor.ornegin Chrome dan bir driver olustur diyor
        // Driver classinda farkli  browser(chrome,firefox,headless)lar var
        private Driver() {
            //kimse ulasmasin diye private kullan

        }
        //Baska obje olusturulmasin boylece
        //instance bir driver olustur
        //static driver class da kullandim diyebiliriz interview
        public static WebDriver driver;

        //to initialize the driver we create a static method
        public static WebDriver getDriver() {
            //driver null ise browser sec
            if (driver == null) {
                System.setProperty(ConfigReader.getProperty("chromedriver"), ConfigReader.getProperty("chromedriverpath"));
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }
    }

