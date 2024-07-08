package tests.day17_testNGFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {


    //3 farkli test methodu olusturun
    //ve her bir method da asagida verilen websayfalarindan birisine gidip
    //o sayfaya gidildigini test edin
    //1-testotomasyonu.com
    //2-wisequarter.com
    //3-bestbuy.com


    WebDriver driver;

    @BeforeClass
    public void setup() {

        //WebDriverManager.chromedriver().setup();
        //sirket bize bir Webdriver verirse onun kullaniriz
        //yoksa Selenium un kendi WebDriver'ini kullanabiliriz
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    /*
        JUnit'de test methodlarinin hangi sira ile calisacagini ONGEREMEYIZ
        AMMA TestNG method lari isim sirasina gore calistirir

        Eger methodlari istedigimiz sirada calistirmak istersek
        priority kullanabiliriz

        1-eger priority degeri atamazsak default degeri 0'dir
        2- priority kucukten buyuge dogru calisir
        3- priority degerleri her turlu tamsayi olabilir , belirli bir aralikla yazilma sarti yoktur
        4-eger bir method da priority atamazsak default degeri olan 0'a gore siralanir
        5-eger birden fazla method un priority degeri esitse
            esit olanlar kendi icinde harf sirasina gore calisir
            digerleri ile priority degerine gore siralanir

     */

    @Test (priority = 1)
    public void testOtomasyonuTest() {
        driver.get("https://www.testotomasyonu.com");

        //url in testotomayonu icerdigini kontrol edin

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test (priority = 2)
    public void wisequarterTest() {
        driver.get("https://www.wisequarter.com");

        //url in wisequarter icerdigini kontrol edin

        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test (priority = 3)
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");

        //url in bestbuy icerdigini kontrol edin

        String expectedUrl = "bestbuy";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
