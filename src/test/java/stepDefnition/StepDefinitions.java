package stepDefnition;

import Utilities.Utilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import io.cucumber.java.hu.De;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.support.FindBy;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class StepDefinitions {



    public static AndroidDriver<AndroidElement> driver;
    public static Utilities utilities;
    public static IOSDriver<IOSElement> IOSDriver;
    @iOSFindBy(accessibility="Activity Indicators")
    @AndroidBy(id="TBD")
    private MobileElement myelement;

    @Given("User prints hello world")
    public void Userprintshelloworld(){
        System.out.println("Hello World");
    }

    @Given("User launches app")
    public void userLaunchesApp() throws MalformedURLException {
        utilities=new Utilities();
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy S9+")  ;
        capabilities.setCapability(MobileCapabilityType.UDID,"42345a3836313098");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/vishwanathchenni/Downloads/ApiDemos-debug.apk");

        driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Accessibility").click();
        TouchAction touchAction=new TouchAction(driver);
//        touchAction.tap(driver.findElementByAccessibilityId("Accessibility")).perform();
    }

    @Given("User taps on element")
    public void userTapsOnElement() {
      AndroidElement myElement=  driver.findElementByAccessibilityId("Accessibility");
      utilities.tapOnElement(myElement);
    }
    @Given("Given User Enters Value in edibox")
    public void GivenUserEntersValueinedibox() {
        AndroidElement myElement=StepDefinitions.driver.findElementByAccessibilityId("Accessibility");
        utilities.fnEnterTextValue(myElement,"myValue");
    }

    @Given("User taps on Views")
    public void userTapsOnViews() {
        utilities.tapOnElement(StepDefinitions.driver.findElementByAccessibilityId("Views"));
        utilities.tapOnElementUpdate(myelement);;
    }

    @Then("Click on Date Widgets")
    public void clickOnDateWidgets() {
        utilities.tapOnElement(StepDefinitions.driver.findElementByAccessibilityId("Date Widgets"));
    }

    @Then("Then tap on inline watch")
    public void thenTapOnInlineWatch() {
       AndroidElement myelement= StepDefinitions.driver.findElementByAccessibilityId("2. Inline");
       TouchAction touchAction=new TouchAction(StepDefinitions.driver);
       touchAction.tap(tapOptions().withElement(element(myelement))).perform();

    }

    @And("Swipe from from {int} to {int}")
    public void swipeFromFromTo(int arg0, int arg1) {
        WebElement fromElement=StepDefinitions.driver.findElementByXPath("//*[@content-desc='12']");
        WebElement ToElement=StepDefinitions.driver.findElementByXPath("//*[@content-desc='6']");
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.longPress(longPressOptions().
                withElement(element(fromElement)).
                withDuration(ofSeconds(2))).
                moveTo(element(ToElement)).release().perform();
    }

    @Then("User scrolls down")
    public void userScrollsDown() {

        //The viewing size of the device
        Dimension size = StepDefinitions.driver.manage().window().getSize();

        //x position set to mid-screen horizontally
        int width = size.width / 2;

        //Starting y location set to 80% of the height (near bottom)
        int startPoint = (int) (size.getHeight() * 0.80);

        //Ending y location set to 20% of the height (near top)
        int endPoint = (int) (size.getHeight() * 0.20);

//        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
        TouchAction touchAction=new TouchAction(StepDefinitions.driver);
        touchAction.press(PointOption.point(width,startPoint)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10))).
                moveTo(PointOption.point(width,endPoint)).
                release().
                perform();
    }

    @Given("User taps on Drag and Drop")
    public void userTapsOnDragAndDrop() {
        utilities.tapOnElement(StepDefinitions.driver.findElementByAccessibilityId("Drag and Drop"));
    }

    @Then("Drag first element to Second element")
    public void dragFirstElementToSecondElement() {
        AndroidElement fromElement=StepDefinitions.driver.findElementsByClassName("android.view.View").get(0);
        AndroidElement toElement=StepDefinitions.driver.findElementsByClassName("android.view.View").get(2);

        utilities.dragFirstElementToSecondElement(fromElement,toElement);
    }

    @And("then press andoid back button")
    public void thenPressAndoidBackButton() {
//        StepDefinitions.driver.pressKeyCode(AndroidKeyCode.BACK);
        StepDefinitions.driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        List of keys available at below location
//        https://developer.android.com/reference/android/view/KeyEvent#KEYCODE_BACK
    }

    @Given("User launches an existing app in mobile")
    public void userLaunchesAnExistingAppInMobile() throws MalformedURLException {
//  Install Application.Info from play store get activity details
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID,"42345a3836313098");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy S9+");
        capabilities.setCapability("appPackage", "packagename");
        capabilities.setCapability("appActivity", "packagename.MainLaunchActivity");
        driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("User launches chrome browser in mobile")
    public void userLaunchesChromeBrowserInMobile() throws MalformedURLException {
        Utilities utilities=new Utilities();
        utilities.userLaunchesChromeBrowserInMobile();

    }

    @Given("user launches general store app")
    public void userLaunchesGeneralStoreApp() throws MalformedURLException {
        utilities=new Utilities();
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy S9+");
        capabilities.setCapability(MobileCapabilityType.UDID,"42345a3836313098");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/vishwanathchenni/Documents/AppiumProjectUpdatedV4.0/AppiumProject/App/General-Store.apk");
        driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Given("User Selects {string} from dropdown")
    public void userSelectsFromDropdown(String arg0) {
        AndroidElement myElement=StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        utilities.tapOnElement(myElement);
        utilities.scrollTillAnElementWithTextIsDisplayed(arg0);

    }

    @Then("User click on Lets shop button")
    public void userClickOnLetsShopButton() {
        utilities.tapOnElement(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/btnLetsShop"));
    }

    @Then("Enter your name as {string}")
    public void enterYourNameAs(String arg0) {
        utilities.fnEnterTextValue(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/nameField"),arg0);
    }

    @Then("Select Female Radio button")
    public void selectFemaleRadioButton() {
        utilities.tapOnElement(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/radioFemale"));
    }

    @And("Scroll tll {string} is displayed")
    public void scrollTllIsDisplayed(String arg0) {
        utilities.scrollTillAnElementWithTextIsDisplayed(arg0);
    }

    @Then("Click on add to cart button for {string}")
    public void clickOnAddToCartButtonFor(String arg0) {
//        utilities.tapOnElement(StepDefinitions.driver.findElementByXPath("//*[@text='ADD TO CART']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/android.widget.TextView[@text='Air Jordan 9 Retro']"));
        utilities.tapOnElement(StepDefinitions.driver.findElementByXPath("//*[@text='"+arg0+"']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']"));
    }

    @Then("User click on cart icon")
    public void userClickOnCartIcon() {
        utilities.tapOnElement(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart"));
    }

    @Then("long press on terms and condition")
    public void longPressOnTermsAndCondition() {
        utilities.longPressOnElement(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/termsButton"));
    }

    @Then("Click on close button of terms and condition")
    public void clickOnCloseButtonOfTermsAndCondition() {
        utilities.tapOnElement(StepDefinitions.driver.findElementById("android:id/button1"));
    }

    @And("tap on visit website")
    public void tapOnVisitWebsite() {
        utilities.tapOnElement(StepDefinitions.driver.findElementById("com.androidsample.generalstore:id/btnProceed"));
    }

    @And("verify edit box on webview")
    public void verifyEditBoxOnWebview() throws InterruptedException {
        utilities.switchNativeToWeb();
        StepDefinitions.driver.findElementByXPath("//input[@name='q']").sendKeys("Vishwanath");
        StepDefinitions.driver.findElementByXPath("//input[@name='q']").sendKeys(Keys.RETURN);
    }

    @Given("User launches IOS App")
    public void userLaunchesIOSApp() throws IOException, InterruptedException {
        utilities=new Utilities();
        utilities.LoadProperiesFile();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        cap.setCapability(MobileCapabilityType.UDID, "F8BFFE83-3FFE-4E59-8C45-356F0702006F");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT,500000);
        cap.setCapability(MobileCapabilityType.APP, ""+Utilities.properties.getProperty("iOSAppPath"));
        StepDefinitions.IOSDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        IOSDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        utilities.tapOnIOSElement(IOSDriver.findElementByAccessibilityId("Alert Views"));

        utilities.tapOnIOSElement(IOSDriver.findElementByAccessibilityId("Text Entry"));

        utilities.enterTextInIOSEditBox(IOSDriver.findElementByXPath("//*[@type='XCUIElementTypeTextField']"),"Sample");

        utilities.tapOnIOSElement(IOSDriver.findElementByAccessibilityId("Confirm / Cancel"));

        utilities.tapOnIOSElement(IOSDriver.findElementByAccessibilityId("Confirm"));

    }
}
