package pageobjects;

import Utilities.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepDefnition.StepDefinitions;

public class UIKitCatalogHomePage {

    @iOSXCUITFindBy(accessibility = "Alert Views")
    @AndroidBy(xpath = "TBD")
    public WebElement alertViews;

    public UIKitCatalogHomePage(AppiumDriver iosDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver),this);
    }

    public void userTapsOnAlertView() throws InterruptedException {
            StepDefinitions.utilities.tapOnIOSElement(alertViews);
    }
}
