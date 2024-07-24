package tests.day19_testNGFramework_assertions;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegativeLoginTest {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    @Test(groups = "smoke")
    public void invalidPasswordTest() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        //	- gecerli email, gecersiz password
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        ReusableMethods.wait(1);


        Driver.quitDriver();


    }

    @Test
    public void invalidEmailTest() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        //	- gecersi email, gecerli password
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toValidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        ReusableMethods.wait(1);


        Driver.quitDriver();

    }

    @Test
    public void invalidEmailAndPasswordTest() {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        //	- gecersiz email, gecersi password
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSigninButton.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isDisplayed());
        ReusableMethods.wait(1);

        Driver.quitDriver();

    }


}
