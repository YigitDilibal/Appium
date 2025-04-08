package tests.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ToDoList {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void install() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        caps.setCapability("deviceName","Pixel 4");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage","todolist.scheduleplanner.dailyplanner.todo.reminders");
        caps.setCapability("appActivity","app.todolist.activity.SplashActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, false);

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
// uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("todolist.scheduleplanner.dailyplanner.todo.reminders"));

// uygulaminin basarili bir sekilde acildigi dogrulanir
        AndroidElement cont = driver.findElementByXPath("//*[@text='CONTINUE']");
        Assert.assertTrue(cont.isDisplayed());

// Ileri butonlarina tiklanir ve pop-up lar kapatilir
        driver.findElementByXPath("//*[@text='CONTINUE']").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='CONTINUE']").click();
        Thread.sleep(500);
        driver.findElement(By.id("todolist.scheduleplanner.dailyplanner.todo.reminders:id/toolbar_back")).click();
        Thread.sleep(500);
        driver.findElement(By.id("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_pro_first_close")).click();
        Thread.sleep(500);

// görev ekleme adimina gecilir
        driver.findElement(By.id("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add")).click();

// görev adi girilir
        AndroidElement gorevAdi = driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_input");
        gorevAdi.sendKeys("gorev1");

// görev kaydedilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_btn").click();

        Thread.sleep(1500);

        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(878,1162)).release().perform();
        Thread.sleep(500);
        action.press(PointOption.point(878,1162)).release().perform();
        Thread.sleep(500);
        action.press(PointOption.point(878,1162)).release().perform();
        Thread.sleep(500);

// görev silinir

        action.press(
                        PointOption.point(870,450))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
                .moveTo(PointOption.point(240,450))
                .release()
                .perform();
        Thread.sleep(500);

        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_delete_layout").click();
        Thread.sleep(500);
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_confirm").click();
        Thread.sleep(500);
// Görev olusturma sayfasina geri dönüldügü dogrulanir

        Assert.assertTrue(driver.findElement(By.id("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add")).isDisplayed());
    }

}
