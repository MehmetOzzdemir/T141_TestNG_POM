package tests.day20_softAssertion_xmlFiles;

public class C03_xmlFile {
    /*
        Test Cesitleri
            1-islevsel acidan
            fonksiyonel testler ve fonksiyonel olmayan testler
            2-icerik acisindan
            black-box testing ve white box testing
            3-yapilis bicimi acisindan
            manuel testler ve otomasyon ile yapilan testler

                smoke test:islevsel acian fonksiyonel
                icerik acisindan black-box
                yapilis acisindan otomasyon testidir.



        Smoke Test
        E2E Test
        Regression Test
        Kullanici Kabul Test
        Entegrasyon TEst

        Belirli bir amac icin calistirilan tum kodlardir
        Bu kodlar method lar class lar veya package lar icerebilir

        Testler bir araya getirilerek test suite'leri olusturulabilir


        Örnek olarak
        Bizim smoke testimiz
            -day17 package'indaki tum classlar
            -day18 den C05 ve C6
            -day19 daki C03 classindaki gecersiEmailTest
            -day20 deki C01 classlarindan olusur

            smoke testi olusturan tum kodlari tek seferde calistirip raporlamak istiyoruz

            TestNG istedigimiz konfigrasyonlarda istedigimiz sayida
            package/class ve test methodunu toplu olarak calistirabilmeniz icin
            TestNG xmlk dosyalari hazirlamistir

            TestNG kullanilarak toplu kod calistirmak istedigimizde
            .xml dosalarini kullanabiliriz
            1-Kullanacagimiz .xml dosyalarinin ilk satirinda
                TestNG nin DTD dosyalarini isaret etmek icin
                 <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                   satiri MUTLAKA olmalidir

            2- Bu satirin altinda hiyerarsiye uygun olarak
           suite ve test secilip sonra
           verilen goreve uygun package / class veya test method'lari secilebilir





     */
}
