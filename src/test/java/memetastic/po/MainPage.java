package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andreendo
 */
public class MainPage extends BasePage {
     @FindBy(id = "Open navigation drawer")
    RemoteWebElement menu;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Human\")")
    RemoteWebElement humanTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Animals\")")
    RemoteWebElement animalsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cartoon\")")
    RemoteWebElement cartoonTab;    
    
    
    public MainPage(AndroidDriver d) {
        super(d);
    }

    public void selectTabHumans() {
        humanTab.click();
    }

    public void selectTabAnimals() {
        animalsTab.click();
    }

    public void selectTabCartoon() {
        cartoonTab.click();
    }

    public MenuPage openMenu() {
        menu.click();
        return new MenuPage(d);
    }
    
}
