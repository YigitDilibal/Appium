package tests.day04;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import tests.utilities.Driver;

public class AllCurrency {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    AllCurrencyPage page = new AllCurrencyPage();

    @Test
    public void test01(){

        // AllCurrency Converter uygulamasinin yuklendigi dogulanir
        // Uygulamanin acildigi dogrulanir
        // Cevirmek istedigimiz para birimiKanada dolari olarak secilir
        // Cevirilecek tutar tuslanir
        // Cevirilecek olan para birimi Türk lirasi olarak secilir
        // Cevirilen tutar screenshot olarak kaydedilir
        // Ardindan Kanada dolarinin Türk lirasi karsiligi olan degeri kaydedilir
        // Sonuc kullaniciya sms olarak bildirilir

    }

}
