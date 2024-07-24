package tests.day20_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_softAssertion {

    @Test
    public void currencyTest(){

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webAppUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        // dogrulayin (verify) dendiginde genelde softAssert tercih edilir
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("webAppUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Gidilen Url farkli satir 29");

        // 3. Sign in butonuna basin
        WebAppPage webAppPage = new WebAppPage();
        webAppPage.signinButton.click();

        // 4. Login kutusuna “username” yazin
        webAppPage.loginBox.sendKeys(ConfigReader.getProperty("webAppUsername"));

        // 5. Password kutusuna “password” yazin
        webAppPage.passwordBox.sendKeys(ConfigReader.getProperty("webAppPassword"));

        // 6. Sign in tusuna basin
        webAppPage.signinBox.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();


        // 8. Giris yapilabildigini dogrulayin
        Assert.assertTrue(webAppPage.onlineBankingLink.isDisplayed(),"Giris yapilmadi 49");

        // 9. Online banking menusunu tiklayin
        webAppPage.onlineBankingMenu.click();

        //10. Pay Bills sayfasina gidin
        webAppPage.payBillsLink.click();

        //11. “Purchase Foreign Currency” tusuna basin
        webAppPage.purchaseForeignCurrencyLink.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(webAppPage.currencyDropdown.isEnabled(),"dropdown erisilebilir degil satir 61");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select  =new Select(webAppPage.currencyDropdown);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenKur = ConfigReader.getProperty("webAppSelectedCurrency");
        String actualSecilenKur = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenKur,expectedSecilenKur,"EUR secilmemis satir 71");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        String expectedDropdownMenuSize =ConfigReader.getProperty("webAppDropdownBoyut");
        Integer actualDropdownMenuSize = select.getOptions().size();

        softAssert.assertEquals(actualDropdownMenuSize+"",expectedDropdownMenuSize,"Dropdown Menu boyutu yanlis satir 77");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> optionsELementList = select.getOptions();
        List<String> dropdownOptionsStringList = ReusableMethods.stringListChange(optionsELementList);

        softAssert.assertTrue(dropdownOptionsStringList.contains(ConfigReader.getProperty("webAppDropdownIcerik")),"dropdown menu Canada dolari icermiyor satir 83");


        softAssert.assertAll();
        //17. Sayfayi kapatin
        Driver.quitDriver();


    }

}
