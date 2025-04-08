package tests.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;
import tests.utilities.ReusableMethods;

public class Kiwi {

    AndroidDriver<AndroidElement>driver= Driver.getAndroidDriver();

    KiwiPage page = new KiwiPage();

    @Test
    public void test01(){

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiAppPackage")));

        //uygulamanin basariyla acildigi dogrulanir]
        Assert.assertTrue(page.continueAsGuest.isDisplayed());

        // misafir olarak devam et e tiklanir
        page.continueAsGuest.click();

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir
        ReusableMethods.click(550,2050);
        ReusableMethods.click(550,2050);
        ReusableMethods.click(550,2050);

        // Trip type,one way olarak secilir
        page.tripType.click();
        page.oneWay.click();
        ReusableMethods.bekle();


        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.bekle();
        page.from.click();
        driver.findElementByAccessibilityId("Clear All").click();
        ReusableMethods.bekle();

        // kalkis yapilacak sehir Ankara girilir ve sec e tiklanir
        page.fromTextbox.sendKeys("Ankara");
        ReusableMethods.bekle();
        page.ankara.click();
        ReusableMethods.bekle();
        page.choose.click();
        ReusableMethods.bekle();

        // varis  secenegi Frankfurt secilir
        page.to.click();
        ReusableMethods.bekle();
        page.fromTextbox.sendKeys("Frankfurt");
        ReusableMethods.bekle();
        page.frankfurt.click();
        ReusableMethods.bekle();
        page.choose.click();
        ReusableMethods.bekle();

        // gidis tarihi 23 Nisan olarak secilir ve set date e tiklanir
        page.departure.click();
        ReusableMethods.bekle();
        ReusableMethods.click(537,1140);
        page.setDate.click();
        ReusableMethods.bekle();

        // search butonuna tiklanir
        page.search.click();
        ReusableMethods.bekle();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.siralama.click();
        ReusableMethods.bekle();
        page.enUcuz.click();
        ReusableMethods.bekle();

        page.aktarma.click();
        ReusableMethods.bekle();
        page.aktarmasiz.click();
        ReusableMethods.bekle();

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyat = page.fiyat.getText();
        ReusableMethods.bekle();
        fiyat = fiyat.replaceAll("\\D","");
        int intFiyat = Integer.parseInt(fiyat)/100;

        System.out.println(intFiyat);
    }



}
