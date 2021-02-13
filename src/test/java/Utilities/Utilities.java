package Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.core.gherkin.Step;
import io.appium.java_client.TouchAction.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import stepDefnition.StepDefinitions;

public class Utilities {

    public void tapOnElement(AndroidElement myElement) {
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
}
