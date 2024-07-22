package tests.day18_TestNGFrameworkPrepare;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_FormDoldurma {

    @Test
    public void dormDoldurmaTest(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        //5- Secilen değerleri konsolda yazdirin
        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
    }
}
