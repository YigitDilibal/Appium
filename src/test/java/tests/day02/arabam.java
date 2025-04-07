package tests.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class arabam {


    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void install() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        caps.setCapability("deviceName","Pixel 4");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage","com.dogan.arabam");
        caps.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void test1(){
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("Ana Sayfa").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByAccessibilityId("İlan Ara").click();

        // kategori olarak Kiralık Araçlar secilir
        driver.findElementByXPath("//*[@text=\"Kiralık Araçlar\"]").click();

        // arac olarak Minivan&Panelvan secilir
        driver.findElementByXPath("//*[@text=\"Minivan & Panelvan\"]").click();

        // arac markasi olarak Mercedes benz secilir
        driver.findElementByXPath("//*[@text=\"Mercedes- Benz\"]").click();

        // Vito secilir
        driver.findElementByXPath("//*[@text='Vito']").click();

        // listenin geldigi dogrulanir

        List<AndroidElement> sonucListesi = driver.findElementsByXPath("//*[@resource-id=\"com.dogan.arabam:id/clItemAdvertList\"]");

        Assert.assertFalse(sonucListesi.isEmpty());

    }


    @Test
    public void test2() throws InterruptedException {
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByAccessibilityId("İlan Ara").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir

        Thread.sleep(500);

        TouchAction action = new TouchAction<>(driver);
        action.press(
                PointOption.point(530,1830))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(70)))
                .moveTo(PointOption.point(530,400))
                .release()
                .perform();

        Thread.sleep(500);

        // baslangic noktasiyla bitis noktasi arasindaki gecen sure (wait action)
        // eger sure azalirsa; gidilen yol mesafesi ARTAR. eger sureyi arttirirsan; gidilen yol mesafesi AZALIR !!
        // yani tamamen bir ters oranti vardir. ekranda daha fazla asagi ya da yukari gitmek istiyorsak birim zamanda sureyi azaltmaliyiz


        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi comfortline yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElement(By.id("com.dogan.arabam:id/constraintLayoutSorting")).click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir


        String ilkArabaFiyati = driver.findElementByXPath("(//*[@resource-id=\"com.dogan.arabam:id/tvPrice\"])[1]").getText();
        ilkArabaFiyati = ilkArabaFiyati.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(ilkArabaFiyati)>500000);


    }






}
