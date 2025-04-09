package tests.utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {

    public static void click(int x, int y) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(x,y)).release().perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    public static void drag(int x, int y, int sure, int x2, int y2) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(
                        PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(sure)))
                .moveTo(PointOption.point(x2,y2))
                .release()
                .perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }


    public static void bekle(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }


    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }


}
