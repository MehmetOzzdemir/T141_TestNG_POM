package tests.day21_xmlFiles_HTMLReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_ReportSearchTest extends TestBaseRapor {


    @Test
    public void searchTest() {
        extentTest =extentReports.createTest("Search Test","Belirlenen kelimenin bulunabildini test eder");

        //testoromasyonu anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici Testotomasyonu anasayfaya gider");


        //belirlenen kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch"),Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");

        //arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.resultElementList.size() > 0);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

    }
}
