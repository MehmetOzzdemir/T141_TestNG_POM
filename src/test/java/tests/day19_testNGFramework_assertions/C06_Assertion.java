package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_Assertion {


    @Test
    public void test01() {

        /*
            TestNG assertion konusnda bize 2 alternatif sunar

                1-JUnşt de oldugu gibi Assert.... ile assertion'lari yapabiliriz
                Bu kullanimda FAILED olan ilk assertion da
                kodun calismasi durur
                o satirdan sonra calismaya engel bir hata varsa onlari bize soylemez

                2-SoftAssert Kullanimi
                Kodumuz bizim belirledigimiz satira kadar
                Assertion lar FAILED olsa da calismaya devam eder
                bizim belirledigimiz satirda
                yaptigi tum assertion'lardan FAILED olan(lar) varsa rapor eder
                ve calismayi o satirda durdurur



         */

        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //anasayfaya gittiginiz test edin
        String expectedUrl = ConfigReader.getProperty("toURL");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        //phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch") + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.resultElementList.size() > 0);

        //ilk urunu tiklayin
        testotomasyonuPage.resultElementList.get(0).click();

        //acilan sayfadaki urun isminde case sensitive olarak
        //aranacak kelime bulundugunu test edin

        String expectedProductName = ConfigReader.getProperty("toSearch");
        String actualProductName = testotomasyonuPage.firstProductName.getText().toLowerCase();

        Assert.assertTrue(actualProductName.contains(expectedProductName));

        //sayfayi kapatin
        Driver.quitDriver();

    }
}
