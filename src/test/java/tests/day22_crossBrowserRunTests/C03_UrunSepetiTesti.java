package tests.day22_crossBrowserRunTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C03_UrunSepetiTesti extends TestBaseCross {

    @Test
    public void uruSepetiTesti() {

        //testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toURL"));

        //belirlenen arama kelimesini aratin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys(ConfigReader.getProperty("toSearch"), Keys.ENTER);

        //bulunan urunlerden ilkini tıklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        //acilan urun sayfasinda urun ismini kaydedin
        WebElement firstProductElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String firstProductName = firstProductElement.getText();


        //urunu sepete ekleyin
        driver.findElement(By.xpath("//*[@class='add-to-cart']"))
                .click();
        ReusableMethods.wait(1);
        //sepete gidin

        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[3]"))
                .click();

        //sepetteki urun ismi ile kaydettigimiz urun isminin ayni oldugunu test edin

        WebElement sepettekiUrunIsmiElementi = driver.findElement(By.xpath("//*[@*='product-title text-center']"));
        String sepettekiUrunIsmi = sepettekiUrunIsmiElementi.getText();
        ReusableMethods.wait(1);
        Assert.assertEquals(firstProductName,sepettekiUrunIsmi);


    }
}
