package tests.day22_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {


    /*
        DataProvider methodu özel bir method dor
        - bu method @DataProvider notasyonu kullanir
        -iki katli object[][] array dondurur

     */
    @DataProvider
    public static Object[][] aranacakKelimeleriYolla() {

        String[][] searchWords = {{"phone"}, {"dress"}, {"java"},
                {"iphone"}, {"samsung"}, {"nutella"}, {"cokokrem"}};
        return searchWords;
    }


    // Asagidaki testi
    // phone, dress, java, iphone, samsung, nutella ve cokokrem kelimeleri icin ayri ayri calistirin

    @Test(dataProvider = "aranacakKelimeleriYolla")
    public void multiSearchTest(String searchWord) {
        extentTest = extentReports.createTest("Coklu arama testi",
                "Verilen tum kelimeler icin ayri ayri arama yapin");
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // verilen kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.searchBox.sendKeys(searchWord + Keys.ENTER);
        extentTest.info("verilen kelime icin arama yapar");

        // arama sonucunda urun bulunabildigini test edin
        Assert.assertNotEquals(testotomasyonuPage.searchElement.getText(), "0 Products Found");
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

    }@AfterClass
    public void teardown(){
        Driver.quitDriver();
    }
}
