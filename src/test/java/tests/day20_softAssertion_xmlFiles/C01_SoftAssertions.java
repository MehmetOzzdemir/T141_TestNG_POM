package tests.day20_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertions {
    @Test
    public void searchTest() {

         /*
        SoftAssertion'da 3 adim var
        1- softAssert objesi olustur
        2- istenen tum assertion'lari softAssert objesini kullanarak yap
        3- assertion'lar bittikten sonra, softAssert'un rapor vermesi icin
           assertAll() calistir.
     */


        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //anasayfaya gittiginiz test edin
        String expectedUrl = ConfigReader.getProperty("toURL");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //1. adim sofAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();
        //2. adim olusturdugumuz objei ile istenen tum assertion'lari yapin
        softAssert.assertEquals(actualUrl, expectedUrl, "URL istenenden farkli ,satir 34");

        //phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch") + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        softAssert.assertTrue(testotomasyonuPage.resultElementList.size() > 0, "bulunan urun sayisi istenen kadar degil ,satir 40");

        //ilk urunu tiklayin
        testotomasyonuPage.resultElementList.get(0).click();

        //acilan sayfadaki urun isminde case sensitive olarak
        //aranacak kelime bulundugunu test edin

        String expectedProductName = ConfigReader.getProperty("toSearch");
        String actualProductName = testotomasyonuPage.firstProductName.getText().toLowerCase();
        softAssert.assertTrue(actualProductName.contains(expectedProductName), "ilk urunun isminde aranacak kelime yok ,satir 51");


        //3.adim softAssert'un raporlamasi icin asserAll() calistir
        softAssert.assertAll();

        //sayfayi kapatin
        Driver.quitDriver();


    }
}
