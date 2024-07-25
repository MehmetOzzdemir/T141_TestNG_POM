package tests.day21_xmlFiles_HTMLReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_ReportPositiveLoginTest extends TestBaseRapor {
    /*
        Varolan bir method u raporlu hale getirmek icin
        1- icinde bulundugu classi TestBaseReport a child yapin
        2- test adimlarini raporlamak icin ectentTest objesine deger atamasi yapin
        3- Raporda cikmasini istedigimiz test adimlarini info/pass olarak olusturun

     */


    @Test
    public void positiveLoginTest() {
        extentTest = extentReports.createTest("Positive Login Test ","Gecerli bilgilerle sisteme giris yapilabilir");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici Testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        extentTest.info("Account Linkine basar");

        ReusableMethods.wait(1);

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage
                .loginEmailBox
                .sendKeys(ConfigReader.getProperty("toValidEmail"));
        ReusableMethods.wait(1);
        extentTest.info("Kullanici email olarak gecerli email girer");

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage
                .loginPasswordBox
                .sendKeys(ConfigReader.getProperty("toValidPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli passwor girer");

        //5- Login butonuna basarak login olun
        testotomasyonuPage
                .loginSigninButton
                .click();
        extentTest.info("Login butunona basarak login yapar");

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButton.isDisplayed());
        extentTest.pass("Basarili bir giris yapilabildigini test eder");



    }
}
