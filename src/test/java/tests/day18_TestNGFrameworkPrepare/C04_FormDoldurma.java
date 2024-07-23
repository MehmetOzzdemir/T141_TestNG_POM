package tests.day18_TestNGFrameworkPrepare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_FormDoldurma {

    @Test
    public void FormDoldurmaTest(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        TestotomasyonuFormPage testotomasyonuFormPage = new TestotomasyonuFormPage();

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectDay = new Select(testotomasyonuFormPage.dayDropdownElement);
        selectDay.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectMonth = new Select(testotomasyonuFormPage.monthDropdownElement);
        selectMonth.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYear = new Select(testotomasyonuFormPage.yearDropdownElement);
        selectYear.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(
                selectDay.getFirstSelectedOption().getText()+" "
                +selectMonth.getFirstSelectedOption().getText()+" "
                +selectYear.getFirstSelectedOption().getText()

        );

        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> monthList = selectMonth.getOptions();

        System.out.println(ReusableMethods.stringListChange(monthList));


        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedSize = 13;
        int actualSize = monthList.size();

        Assert.assertEquals(actualSize,expectedSize);


        Driver.quitDriver();
    }
}
