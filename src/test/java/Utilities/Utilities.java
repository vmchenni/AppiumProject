package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.gherkin.Step;
import io.appium.java_client.TouchAction.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepDefnition.StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public  void tapOnElement(AndroidElement myElement) {
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
//        touchAction.tap(tapOptions().withElement(element(myElement))).perform();
//        touchAction.tap(TapOptions.tapOptions().withElement(element(myElement)));
        touchAction.tap(TapOptions.tapOptions().withElement(element(myElement))).perform();
    }
    public void longPressOnElement(AndroidElement myElement){
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.longPress(longPressOptions().withElement(element(myElement)).withDuration(ofSeconds(2))).release().perform();
    }
    public void doubleTapOnElement(AndroidElement myElement){
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.tap(TapOptions.tapOptions().withElement(element(myElement))).release().perform().
                tap(TapOptions.tapOptions().withElement(element(myElement))).release().perform();
    }
    public void fnEnterTextValue(AndroidElement myElement,String myValue){
//        myElement.sendKeys(myValue);
        myElement.sendKeys(myValue);
        StepDefinitions.driver.hideKeyboard();
    }
    public void DragAndDropElement(AndroidElement fromElement,AndroidElement toElement){
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.longPress(longPressOptions().withElement(element(fromElement))).
                moveTo(element(toElement)).release().perform();

    }

    public void dragFirstElementToSecondElement(AndroidElement fromElement, AndroidElement toElement) {
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(fromElement)))
                .moveTo(element(toElement)).release().perform();
    }

    public void userLaunchesChromeBrowserInMobile() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy S9+")  ;
        capabilities.setCapability(MobileCapabilityType.UDID,"42345a3836313098");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
//        driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.timesofindia.com");
    }

    public void userSelectsFromDropdown(String arg0) {
        AndroidElement myelement=StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        tapOnElement(myelement);
    }
    public void scrollTillAnElementWithTextIsDisplayed(String arg0) {
     AndroidElement expectedElement = null;
     Dimension size=StepDefinitions.driver.manage().window().getSize();
        //x position set to mid-screen horizontally
        int width = size.width / 2;
        //Starting y location set to 80% of the height (near bottom)
        int startPoint = (int) (size.getHeight() * 0.80);
        //Ending y location set to 20% of the height (near top)
        int endPoint = (int) (size.getHeight() * 0.30);

     TouchAction touchAction=new TouchAction(StepDefinitions.driver);

         do {
             try{
                 expectedElement=StepDefinitions.driver.findElementByXPath("//*[@text='"+arg0+"']");
                if(expectedElement.isDisplayed()){
                    tapOnElement(expectedElement);
                    break;
                }

             }catch(Exception e){
                 touchAction.press(PointOption.point(width,startPoint)).
                         waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
                         moveTo(PointOption.point(width,endPoint)).
                         release().
                         perform();
                 continue;
             }
         }while (true);
    }

    public void switchNativeToWeb() throws InterruptedException {
        Thread.sleep(10000);
        Set<String> contextNames = StepDefinitions.driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        StepDefinitions.driver.context((String) contextNames.toArray()[1]);
//        StepDefinitions.driver.context("NATIVE_APP");

    }
    public void switchWebToNative() {
        StepDefinitions.driver.context("NATIVE_APP");
    }
}
