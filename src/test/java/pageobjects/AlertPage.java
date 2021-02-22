package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepDefnition.StepDefinitions;

public class AlertPage {

    @iOSXCUITFindBy(accessibility = "Text Entry")
    @AndroidFindBy(xpath = "TBD")
    public WebElement TextEntry;

    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    @AndroidFindBy(xpath = "TBD")
    public WebElement txtField;

    public AlertPage(AppiumDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver),this);
    }

    public void userTapsOnTextEntry() throws InterruptedException {
        StepDefinitions.utilities.tapOnIOSElement(TextEntry);
    }


    public void enterTextAs(String arg0) {
        StepDefinitions.utilities.fnEnterTextValue(txtField,arg0);
    }
}
