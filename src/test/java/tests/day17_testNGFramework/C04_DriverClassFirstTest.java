package tests.day17_testNGFramework;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassFirstTest {

    //TestNG PAge Object Model de
    //bizim elimiz kolumuz gozumuz olan webdriver objesi olusturmak icin
    //Driver classindaki static getDriver() kullanilir

    @Test
    public void test01() throws InterruptedException {

        Driver.getDriver().get("https://www.testotomasyonu.com");


        Thread.sleep(1000);
        Driver.quitDriver();



    }



}
