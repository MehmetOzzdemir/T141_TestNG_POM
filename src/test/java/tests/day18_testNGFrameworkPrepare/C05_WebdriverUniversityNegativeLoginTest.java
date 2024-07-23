package tests.day18_testNGFrameworkPrepare;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebdriverUniversityNegativeLoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebdriverUniversityNegativeLoginTest {

    @Test
    public void negativeLoginTest(){
        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");
        WebdriverUniversityNegativeLoginPage webdriverUniversityNegativeLoginPage = new WebdriverUniversityNegativeLoginPage();


        //2."Login Portal" a kadar asagi inin
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'})",webdriverUniversityNegativeLoginPage.loginPortalYazisi);


        //3."Login Portal" a tiklayin
        webdriverUniversityNegativeLoginPage.loginPortalYazisi.click();

        //4.Diger window'a gecin
        ReusableMethods.windowaGec("https://webdriveruniversity.com/Login-Portal/index.html",Driver.getDriver());


        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();

        webdriverUniversityNegativeLoginPage.usernameKutusu.sendKeys(faker.name().username());
        webdriverUniversityNegativeLoginPage.passwordKutusu.sendKeys(faker.internet().password());


        //6."login" butonuna basin
        webdriverUniversityNegativeLoginPage.loginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedAlertText = "validation failed";
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertText,expectedAlertText);



        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        ReusableMethods.windowaGec("https://webdriveruniversity.com/",Driver.getDriver());


        //10.Ilk sayfaya donuldugunu test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);



        Driver.quitDriver();
    }
}
