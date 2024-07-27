package tests.day22_crossBrowserRunTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_SearchTest extends TestBaseCross {

    @Test
    public void searchTest(){
        //testotomastonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //belirlenmis arnacak kelime ile arama yapin
        // POM'de locate'leri Page class'larindan aliriz
        // Ancak page class'larinda Driver Class'indaki getDriver() ile olusturulan WebDriver objesi tanimli
        // Eger cross browser calistiracagimiz class'lar fazla ise
        // driver'i tanimlayacagimiz yeni Page class'i olusturup, locate'leri oradan kullanabiliriz
        // bizim framework'umuzde CrossBrowser calisacak testler sinirli sayida oldugundan
        // yeni bir Page class'i olusturmak yerine
        // locate'leri eski usul ile @Test method'u icinde yapabiliriz

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch"),Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin


        String unExpectedResult = "0 Products Found";
        String actualResult = testotomasyonuPage.searchElement.getText();

        Assert.assertNotEquals(actualResult,unExpectedResult);
    }
}
