package tests.day18_testNGFrameworkPrepare;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_BasicDriverClass {

    @Test
    public void test01(){

        //testotomsyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //phone icin arama yapalim
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edelim
        WebElement searchResultElement = Driver.getDriver().findElement(By.className("product-count-text"));

        String actualResult = searchResultElement.getText();
        String unExpectedResult = "0 Product Found";
        Assert.assertNotEquals(actualResult,unExpectedResult);

        //sayfayi kapatin
        Driver.quitDriver();
    }
}
