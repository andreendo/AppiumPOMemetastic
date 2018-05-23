package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 *
 * @author andreendo
 */
public class OpenPage extends BasePage {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"OK\")")
    RemoteWebElement okButton;

    public OpenPage(AndroidDriver d) {
        super(d);
    }

    public MainPage pressOK() {
        okButton.click();
        
        return new MainPage(d);
    }
}
