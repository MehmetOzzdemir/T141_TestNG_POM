package tests.day17_testNGFramework;

import org.checkerframework.checker.units.qual.K;
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

public class C03_DependsOnMethods {

    //3 farkli test methodu olusturup asagidaki gorevleri yerine getirin
    //1-test otomasyonu anasayfaya gidin ve sayfaya gittiginizi test edin
    // 2 2phone icin arama yapın ve urun bulunabildigini test edin
    //3 ilk urune tıklayip acilan sayfada case sensitive olmaksizin
    // urun isminin phone icerdigini test edin

    //Methoflar birbirini yakip eden görevler bulundurdugu icin
    //@BeforeClass ve @AfterClass kullanmaliyiz


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
        priority testlerin dogru sıralama ile calismasini saglar
        ANCAK bu ornekte oldugu gibi
        birbirine bagimli testlerde
        bir assertion failed oldugunda
        geriye kalanlarin calismasi ANLAMSIZ hale gelebilir

        bu durumda priority ileyapilan siralama guzel ama eksik kalir

        TESTNG ile bu ornekte oldugu gibi birbirine bagimli methodlarin
        calismasini da birbirine bagimli hale getirebiliriz
        boylece onceki test calisip PASSED olmazsa
        sonraki test(ler) direk IGNORE edilir ve HIC CALISTIRILMAZ

        1- dependsonMethods bir siralaa yontemi degildir
           Ama sira kendine gelen bir method baska bir method a baglanmissa
           onceligi ona verir

        2-  Biz test methodlarini bagimsiz olarak calistirabiliriz
        ANCAK bir methodu bagimsiz olarak calistirmak istedigimizde
        o method dependsOnMEthods ile baska bir method'a baglanmissa
        once bagli oldugu method'un calismasini sağlar
        ANCAK bu calisma 2 METHOD icindir,daha fazla method birbirini calistirmaz
     */
    @Test
    public void homepageTest(){
        driver.get("https://www.testotomasyonu.com");
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(dependsOnMethods = "homepageTest")
    public void phoneSearchTest(){

        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));
        String actualResult = searchResultElement.getText();
        String unExpectedResult = "0 Product Found";
        Assert.assertNotEquals(actualResult,unExpectedResult);

    }

    @Test(dependsOnMethods = "phoneSearchTest")
    public void firstProductNameTest(){

        driver.findElement(By.xpath("(//*[@class='prod-title mb-3 '])[1]")).click();

        //acilan sayfada case sensitive olmaksizin urun isminin phone icerdigini test edin

        String expectedText = "phone";
        String actualText = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']")).getText().toLowerCase();

        Assert.assertTrue(actualText.contains(expectedText));


    }
}
