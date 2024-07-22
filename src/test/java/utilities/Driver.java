package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //Driver class i WebDriver objesini olusturacagimiz
    //ve gerekli ayarlari yapacagimiz class olacak
    // Hedef Configuration properties den hangi browser secilirse
    //bize o Browser i üretecek bir class olusturmak

    // Driver class inda bize drive robjesini dondurecek getDriver() olusturacagiz


    public static WebDriver driver;

    public static WebDriver getDriver(){

        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }

}
