package tests.day21_xmlFiles_HTMLReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_ReportNegativeLoginTest extends TestBaseRapor {

    @Test(groups = "smoke")
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Gecersiz password ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");
        //3- gecerli email, gecersiz password girin
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
        extentTest.info("gecerli email, gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

    }

    @Test
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                "Gecersiz email ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");
        //3- gecersiz email, gecerli password girin
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toValidPassword"));
        extentTest.info("gecersiz email, gecerli password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Gecersiz Password Testi",
                "Gecersiz email ve gecersiz password ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");
        //3- gecersiz email, gecersiz password girin
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
        extentTest.info("gecersiz email, gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

    }

}
