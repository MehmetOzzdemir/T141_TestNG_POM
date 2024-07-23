package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_ShoppingBoxTest {


    @Test
    public void shoppingBoxTest() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch"), Keys.ENTER);
        ReusableMethods.wait(1);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.resultElementList.get(0).click();

        //4- urun ismini kaydedin
        String productName = testotomasyonuPage.firstProductName.getText();

        // ve urunu sepete ekleyin
        testotomasyonuPage.addToCartButton.click();

        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCartButton.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin


        String shoppingBoxProductName =testotomasyonuPage.shoppingBoxProductName.getText();

        Assert.assertEquals(shoppingBoxProductName,productName);


        ReusableMethods.wait(1);
        //7- sayfayi kapatin
        Driver.quitDriver();
    }
}
