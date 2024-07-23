package tests.day18_TestNGFrameworkPrepare;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C07_BirdenFazlaTestMethodu {

    @Test(priority = 1)
    public void testOtomasyonuTest() {
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //url in testotomayonu icerdigini kontrol edin

        String expectedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Driver.quitDriver();
    }

    @Test (priority = 2)
    public void wisequarterTest() {
        Driver.getDriver().get("https://www.wisequarter.com");

        //url in wisequarter icerdigini kontrol edin

        String expectedUrl = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Driver.quitDriver();
    }

    @Test (priority = 3)
    public void bestBuyTest() {
        Driver.getDriver().get("https://www.bestbuy.com");

        //url in bestbuy icerdigini kontrol edin

        String expectedUrl = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Driver.quitDriver();
    }
}
