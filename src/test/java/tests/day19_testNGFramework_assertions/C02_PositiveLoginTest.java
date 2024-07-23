package tests.day19_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PositiveLoginTest {

    @Test
    public void positiveLoginTest() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        ReusableMethods.wait(1);

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage
                .loginEmailBox
                .sendKeys(ConfigReader.getProperty("toValidEmail"));


        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage
                .loginPasswordBox
                .sendKeys(ConfigReader.getProperty("toValidPassword"));

        //5- Login butonuna basarak login olun
        testotomasyonuPage
                .loginSigninButton
                .click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButton.isDisplayed());

        Driver.quitDriver();

    }
}
