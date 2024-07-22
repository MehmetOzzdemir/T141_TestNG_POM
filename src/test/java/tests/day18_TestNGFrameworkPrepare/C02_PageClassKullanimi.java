package tests.day18_TestNGFrameworkPrepare;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_PageClassKullanimi {



    @Test
    public void test01(){


        //testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //phone icin arama yapin

        //POM' de PAge classlardaki locateleri kullanmak icin
        //page class lardan Obje olusturma yontemi benimsenmistir

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys("phone", Keys.ENTER);


        //arama sonucunda urun bulunabildigini test  edin

        String unExpectedResult = "0 Products Found";
        String actualResult = testotomasyonuPage.searchElement.getText();

        Assert.assertNotEquals(actualResult,unExpectedResult);

        //sayfayi kapatin
        Driver.quitDriver();
    }
}
