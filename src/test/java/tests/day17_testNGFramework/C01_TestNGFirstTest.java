package tests.day17_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_TestNGFirstTest {

    //tek test methodu oldugu icin @BeforeTest veya @BeforeMethod kullanabiliriz

    WebDriver driver;

    @Test
    public void test01() {
        //testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        //phone icin arama yapalim
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edelim
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));
        String actualResult = searchResultElement.getText();
        String unExpectedResult = "0 Product Found";
        Assert.assertNotEquals(actualResult,unExpectedResult);
    }

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
}
