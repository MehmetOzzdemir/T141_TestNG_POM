package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_TestDatasiKullanimi {

    @Test
    public void searchTest() {

        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));


        //phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch"), Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.resultElementList.size() > 0);

        //sayfayi kapatin
        Driver.quitDriver();
    }
}
