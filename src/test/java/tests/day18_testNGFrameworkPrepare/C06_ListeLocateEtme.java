package tests.day18_testNGFrameworkPrepare;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_ListeLocateEtme {

    // Tek test method'u olusturup, asagidaki gorevleri tamamlayin

       // 1- testotomasyonu anasayfaya gidin
       //    ve sayfaya gittiginizi test edin
       // 2- phone icin arama yapin
       //    arama sonucunda urun bulunabildigini test edelim


    @Test
    public void searchTest(){
        // 1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://testotomasyonu.com");

        //    ve sayfaya gittiginizi test edin
        // url in testotomasyonu icerdigini test edelim
        String expectedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


        // 2- phone icin arama yapin

        TestotomasyonuPage testotomasyonuPage =new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys("phone"+ Keys.ENTER);


        //    arama sonucunda urun bulunabildigini test edelim

        int bulunanResultNumber = testotomasyonuPage.resultElementList.size();
        Assert.assertTrue(bulunanResultNumber>0);

        Driver.quitDriver();
    }
}
