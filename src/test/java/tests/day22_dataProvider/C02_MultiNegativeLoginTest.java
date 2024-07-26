package tests.day22_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_MultiNegativeLoginTest {


    @DataProvider
    public static Object[][] kullaniciBilgileriniGetir() {

        String[][] KullaniciBilgileriArray = {
                {"banu@gmail.com", "898989"},
                {"sedat@yahoo.com", "989887"},
                {"orkong@tmail.com", "122334"},
                {"fatih@hotmail.com", "454545"},
                {"arzu@senmail.com", "676767"},
                {"mehmet@mynet.com", "878987"}
        };


        return KullaniciBilgileriArray;
    }





     /*
        1. testotomasyonu anasayfaya gidin
        2. Account linkine tiklayin
        3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        4.  banu@gmail.com     898989
            sedat@yahoo.com    989887
            orkong@tmail.com   122334
            fatih@hotmail.com  454545
            arzu@senmail.com   676767
            mehmet@mynet.com   878987

     */


    @Test(dataProvider = "kullaniciBilgileriniGetir")
    public void multiNegativeLoginTest(String email, String password) {
        //      1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        //      2. Account linkine tiklayin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        //      3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        //      4.  banu@gmail.com     898989
        testotomasyonuPage.loginEmailBox.sendKeys(email);
        testotomasyonuPage.loginPasswordBox.sendKeys(password);
        testotomasyonuPage.loginSigninButton.click();

        Assert.assertTrue(testotomasyonuPage.loginEmailBox.isEnabled());
    }
}
