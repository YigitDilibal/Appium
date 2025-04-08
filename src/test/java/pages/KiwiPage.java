package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.utilities.Driver;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);


    }
    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueAsGuest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement tripType;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement from;

    @FindBy(className = "android.widget.EditText")
    public WebElement fromTextbox;

    @FindBy(xpath = "//*[@text='Ankara, Turkey']")
    public WebElement ankara;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement to;

    @FindBy(xpath = "//*[@text='Frankfurt, Hesse']")
    public WebElement frankfurt;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement departure;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDate;

    @FindBy(xpath = "//*[@text='Search']")
    public WebElement search;

    @FindBy(xpath = "//*[@text='Best']")
    public WebElement siralama;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement enUcuz;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement aktarma;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement aktarmasiz;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement fiyat;


}
